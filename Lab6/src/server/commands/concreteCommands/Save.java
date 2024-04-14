package server.commands.concreteCommands;

import common.exceptions.WrongAmountOfElementsException;
import server.commands.auxillary.AbstractCommand;
import server.utility.CollectionFileManager;
import server.utility.CollectionManager;
import server.utility.ResponseOutputer;

/**
 * Сохранение коллекции в файл
 */
public class Save extends AbstractCommand {
    private final CollectionManager collectionManager;

    public Save(CollectionManager collectionManager) {
        super("save", "","Save the collection to a file.");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод для сохранения элементов коллекции в файл
     * @param stringArgument аргумент команды, введённой пользователем
     * @param objectArgument сериализованный объект класса StudyGroup, введённой пользователем
     * @return ответ на правильное исполнение команды
     */
    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try {
            if (!stringArgument.isEmpty() || objectArgument != null) throw new WrongAmountOfElementsException();
            collectionManager.saveCollection();
            return true;
        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        }
        return false;
    }


}