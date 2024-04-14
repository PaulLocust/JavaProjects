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
 * Этот класс показывает сумму переведённых студентов из каждого элемента коллекции
 */
public class SumOfTransferredStudents extends AbstractCommand {
    private final CollectionManager collectionManager;

    public SumOfTransferredStudents(CollectionManager collectionManager) {
        super("sum_of_transferred_students", "","Display the sum of the values of the transferredStudents field for all elements of the collection");
        this.collectionManager = collectionManager;

    }

    /**
     * Этот метод выводит сумму переведённых студентов
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

            long transferredStudentsCount = 0;
            for (StudyGroup group: studyGroupCollection) {
                transferredStudentsCount += group.getTransferredStudents();
            }
            System.out.println(transferredStudentsCount);

        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        } catch (EmptyCollectionException e) {
            ResponseOutputer.appendError("Collection is empty!");
        }
        return false;
    }
}