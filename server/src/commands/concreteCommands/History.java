package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class History extends AbstractCommand {
    public History() {
        name = "history";
        description = "history : вывести последние 10 команд (без их аргументов)";
    }

    /**
     * Метод, показывающий последние 10 команд без их аргументов.
     */
    @Override
    public void execute() {

    }
}
