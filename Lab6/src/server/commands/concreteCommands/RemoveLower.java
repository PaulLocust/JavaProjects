package server.commands.concreteCommands;

import common.data.StudyGroup;
import common.exceptions.EmptyCollectionException;
import common.exceptions.WrongAmountOfElementsException;
import common.utility.Outputer;
import server.commands.auxillary.AbstractCommand;
import server.utility.CollectionManager;
import server.utility.ResponseOutputer;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Класс, удаляющий все элементы коллекции, поле studentsCount которых меньше значения поля targetElement.
 * targetElement - целевой элемент, по которому идёт сравнение, он выбирается по id в аргументе команды
 */
public class RemoveLower extends AbstractCommand {
    private final CollectionManager collectionManager;

    private StudyGroup targetElement;

    public RemoveLower(CollectionManager collectionManager) {
        super("remove_lower","<value>", "Remove from a collection all elements smaller than a given one.");
        this.collectionManager = collectionManager;

    }

    /**
     * Метод для удаления всех элементов коллекции, поле studentsCount которых меньше значения поля targetElement.
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

            for (StudyGroup group: studyGroupCollection) {
                int id = group.getId();
                if(Integer.toString(id).equals(stringArgument)) {
                    targetElement = group;
                    break;
                }
            }

            Iterator<StudyGroup> iter = studyGroupCollection.iterator();
            int i = 0;
            while(iter.hasNext()) {
                if (targetElement.getStudentsCount() > iter.next().getStudentsCount()) {
                    iter.remove();
                    i++;
                }
            }
            // english moment
            if (i == 1)
                System.out.println(i + " object removed");
            else System.out.println(i + " objects removed");

        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        } catch (EmptyCollectionException e) {
            ResponseOutputer.appendError("Collection is empty!");
        }
        return false;
    }


}