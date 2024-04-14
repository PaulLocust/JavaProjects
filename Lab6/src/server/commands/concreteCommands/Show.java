package server.commands.concreteCommands;

import common.data.StudyGroup;
import common.exceptions.WrongAmountOfElementsException;
import common.utility.Outputer;
import server.commands.auxillary.AbstractCommand;
import server.utility.CollectionManager;
import server.utility.ResponseOutputer;

import java.util.ArrayList;

/**
 * Класс, показывающий состояние всех полей каждого из элементов коллекции
 */
public class Show extends AbstractCommand {
    private final CollectionManager collectionManager;
    public Show(CollectionManager collectionManager) {
        super("show", "","Print to standard output all elements of the collection in string representation.");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для показа состояние всех полей каждого из элементов коллекции
     * @param stringArgument аргумент команды, введённой пользователем
     * @param objectArgument сериализованный объект класса StudyGroup, введённой пользователем
     * @return ответ на правильное исполнение команды
     */
    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try {
            if (!stringArgument.isEmpty() || objectArgument != null) throw new WrongAmountOfElementsException();
            ResponseOutputer.appendLn(collectionManager.showCollection());
            return true;
        } catch (WrongAmountOfElementsException e){
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        }
        return false;
    }


}