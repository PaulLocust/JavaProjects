package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class UpdateId extends AbstractCommand {
    public UpdateId() {
        name = "update";
        description = "update : обновить значения полей одного из элементов коллекции по его id";
    }

    /**
     * Метод, обновляющий один из элементов коллекции по его id
     */
    @Override
    public void execute() {
    }
}
