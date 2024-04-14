package server.commands.concreteCommands;

import client.utility.StudyGroupAsker;
import common.data.Coordinates;
import common.data.Person;
import common.data.Semester;
import common.data.StudyGroup;
import common.exceptions.*;
import common.interaction.StudyGroupRaw;
import server.commands.auxillary.AbstractCommand;
import server.utility.CollectionManager;
import server.utility.ResponseOutputer;

import java.time.ZonedDateTime;

/**
 * Класс, который нужен для обновления какого-либо элемента коллекции
 */
public class UpdateId extends AbstractCommand {

    private final CollectionManager collectionManager;

    public UpdateId(CollectionManager collectionManager) {
        super("update", "<id> {element}","Updating the value of a collection element whose identifier is equal to the given one.");
        this.collectionManager = collectionManager;

    }

    /**
     * Метод для обновления элемента коллекции
     * @param stringArgument аргумент команды, введённой пользователем
     * @param objectArgument сериализованный объект класса StudyGroup, введённой пользователем
     * @return ответ на правильное исполнение команды
     */
    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try{
            if (stringArgument.isEmpty() || objectArgument == null) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new EmptyCollectionException();

            int id = Integer.parseInt(stringArgument);
            if (id <= 0) throw new NumberFormatException();
            StudyGroup oldStudyGroup = collectionManager.getById(id);
            if (oldStudyGroup == null) throw new StudyGroupNotFound();

            StudyGroupRaw studyGroupRaw = (StudyGroupRaw) objectArgument;

            String name = studyGroupRaw.getName() == null ? oldStudyGroup.getName() : studyGroupRaw.getName();
            Coordinates coordinates = (studyGroupRaw.getCoordinates() == null || studyGroupRaw.getCoordinates().getY() == null || studyGroupRaw.getCoordinates().getY() > 849) ? oldStudyGroup.getCoordinates() : studyGroupRaw.getCoordinates();
            ZonedDateTime creationDate = oldStudyGroup.getCreationDate();
            Long studentsCount = studyGroupRaw.getStudentsCount() < 0 ? oldStudyGroup.getStudentsCount() : studyGroupRaw.getStudentsCount();
            long transferred = studyGroupRaw.getTransferredStudents() <= 0 ? oldStudyGroup.getTransferredStudents() : studyGroupRaw.getTransferredStudents();
            Long averageMark = studyGroupRaw.getAverageMark() < 0 ? oldStudyGroup.getAverageMark() : studyGroupRaw.getAverageMark();
            Semester semesterEnum = studyGroupRaw.getSemesterEnum() == null ? oldStudyGroup.getSemesterEnum() : studyGroupRaw.getSemesterEnum();
            Person groupAdmin = (studyGroupRaw.getGroupAdmin() != null && studyGroupRaw.getGroupAdmin().getName() != null && studyGroupRaw.getGroupAdmin().getHeight() > 0 && studyGroupRaw.getGroupAdmin().getEyeColor() != null) ? oldStudyGroup.getGroupAdmin() : studyGroupRaw.getGroupAdmin();

            collectionManager.removeFromCollection(oldStudyGroup);
            collectionManager.addToCollection(new StudyGroup(
                    id,
                    name,
                    coordinates,
                    creationDate,
                    studentsCount,
                    transferred,
                    averageMark,
                    semesterEnum,
                    groupAdmin
            ));
            ResponseOutputer.appendLn("StudyGroup was updated successfully");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        } catch (EmptyCollectionException exception) {
            ResponseOutputer.appendError("Collection is empty!");
        } catch (NumberFormatException exception) {
            ResponseOutputer.appendError("ID have to be a positive value!");
        } catch (StudyGroupNotFound exception) {
            ResponseOutputer.appendError("There is no study group with this ID in the collection!");
        } catch (ClassCastException exception) {
            ResponseOutputer.appendError("The object passed by the client is incorrect!");
        }
        return false;
    }


}