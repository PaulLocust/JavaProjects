package server.commands.concreteCommands;

import common.data.StudyGroup;
import common.exceptions.WrongAmountOfElementsException;
import common.interaction.StudyGroupRaw;
import common.utility.Outputer;
import server.commands.auxillary.AbstractCommand;
import server.utility.CollectionManager;
import server.utility.ResponseOutputer;

import java.time.ZonedDateTime;

/**
 * Этот класс нужен для добавления новых элементов в коллекцию
 */
public class Add extends AbstractCommand {

    private final CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {

        super("add","{element}", "Adds new element to collection.");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод добавляет учебную организацию в коллекцию
     * @param stringArgument аргумент команды, введённой пользователем
     * @param objectArgument сериализованный объект класса StudyGroup, введённой пользователем
     * @return ответ на правильное исполнение команды
     */
    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try{
            if (!stringArgument.isEmpty() || objectArgument == null) throw new WrongAmountOfElementsException();
            StudyGroupRaw studyGroupRaw = (StudyGroupRaw) objectArgument;
            collectionManager.addToCollection(new StudyGroup(
                    collectionManager.generateNewIdForCollection(),
                    studyGroupRaw.getName(),
                    studyGroupRaw.getCoordinates(),
                    ZonedDateTime.now(),
                    studyGroupRaw.getStudentsCount(),
                    studyGroupRaw.getTransferredStudents(),
                    studyGroupRaw.getAverageMark(),
                    studyGroupRaw.getSemesterEnum(),
                    studyGroupRaw.getGroupAdmin()
            ));
            Outputer.printLn("StudyGroup was created successfully");
            return true;
        } catch (WrongAmountOfElementsException e){
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        } catch (ClassCastException exception) {
            ResponseOutputer.appendError("The object passed by the client is incorrect!");
        }
        return false;
    }


}
