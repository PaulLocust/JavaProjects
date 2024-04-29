package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class RemoveById extends AbstractCommand {
    public RemoveById() {
        name = "remove_by_id";
        description = "remove_by_id : удалить элемент коллекции по его id";
    }

    /**
     * Метод удаляет элемент из коллекции по его id
     */
    @Override
    public void execute() {
    }
}
