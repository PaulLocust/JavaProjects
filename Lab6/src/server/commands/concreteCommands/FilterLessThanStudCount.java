package server.commands.concreteCommands;

import common.data.StudyGroup;
import common.exceptions.EmptyCollectionException;
import common.exceptions.WrongAmountOfElementsException;
import common.utility.Outputer;
import server.commands.auxillary.AbstractCommand;
import server.utility.CollectionManager;
import server.utility.ResponseOutputer;

import java.util.HashSet;

/**
 * Этот класс фильтрует элементы коллекции по значению поля studentsCount.
 */
public class FilterLessThanStudCount extends AbstractCommand {
    private final CollectionManager collectionManager;

    public FilterLessThanStudCount(CollectionManager collectionManager) {
        super("filter_less_than_students_count", "<value_to_compare>","Display elements whose studentsCount field value is less than the specified one.");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для показа всех элементов коллекции, значения полей studentsCount которых меньше заданного
     * @param stringArgument аргумент команды, введённой пользователем
     * @param objectArgument сериализованный объект класса StudyGroup, введённой пользователем
     * @return ответ на правильное исполнение команды
     */
    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try {
            if (!stringArgument.isEmpty() || objectArgument != null) throw new WrongAmountOfElementsException();
            HashSet<StudyGroup> studyGroupCollection = collectionManager.getCollection();
            if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();

            long arg = Long.parseLong(stringArgument);
            int i = 0;
            for (StudyGroup group: studyGroupCollection) {
                if (arg > group.getStudentsCount()) {
                    Outputer.printLn(group.toString());
                    i++;
                }
            }
            // english moment
            if (i == 1)
                System.out.println(i + " object was found");
            else System.out.println(i + " objects were found");

        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        } catch (EmptyCollectionException e) {
            ResponseOutputer.appendError("Collection is empty!");
        }
        return false;
    }


}