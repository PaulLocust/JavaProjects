package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class Add extends AbstractCommand {
    public Add() {
        name = "add";
        description = "add : добавляет новый элемент в коллекцию";
    }

    /**
     * Метод, добавляющий новый элемент в коллекцию.
     */
    @Override
    public void execute() {

    }
}
