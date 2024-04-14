package server.commands.concreteCommands;

import common.exceptions.WrongAmountOfElementsException;
import common.utility.Outputer;
import server.commands.auxillary.AbstractCommand;
import server.utility.ResponseOutputer;

/**
 * Класс для показа истории ввода команд
 */
public class History extends AbstractCommand {


    public History() {
        super("history", "","Print the last 15 commands (without their arguments).");
    }

    /**
     * Метод для показа истории последних 15 команд, введённых в консоль приложения
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