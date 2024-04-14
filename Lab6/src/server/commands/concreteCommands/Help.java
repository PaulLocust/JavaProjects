package server.commands.concreteCommands;

import common.exceptions.WrongAmountOfElementsException;
import server.commands.auxillary.AbstractCommand;
import server.utility.ResponseOutputer;

/**
 * Этот класс показывает справку по всем доступным командам приложения
 */
public class Help extends AbstractCommand {

    public Help() {
        super("help", "", "Shows reference about available commands.");

    }

    /**
     * Метод для показа справки по командам
     * @param stringArgument аргумент команды, введённой пользователем
     * @param objectArgument сериализованный объект класса StudyGroup, введённой пользователем
     * @return ответ на правильное исполнение команды
     */
    @Override
    public boolean execute(String stringArgument, Object objectArgument) {
        try {
            if (!stringArgument.isEmpty() || objectArgument != null) throw new WrongAmountOfElementsException();
        } catch (WrongAmountOfElementsException exception) {
            ResponseOutputer.appendLn("Usage: '" + getName() + " " + getUsage() + "'");
        }
        return true;
    }

}
