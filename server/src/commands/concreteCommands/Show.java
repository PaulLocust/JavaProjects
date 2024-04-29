package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class Show extends AbstractCommand {
    public Show() {
        name = "show";
        description = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * Метод, показывающий все элементы коллекции в строковом представлении
     */
    @Override
    public void execute() {
    }
}
