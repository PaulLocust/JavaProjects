package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class Clear extends AbstractCommand {
    public Clear() {
        name = "clear";
        description = "clear : очистить коллекцию";
    }

    /**
     * Метод, очищающий коллекцию.
     */
    @Override
    public void execute() {

    }
}
