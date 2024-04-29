package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class RemoveGreater extends AbstractCommand {
    public RemoveGreater() {
        name = "remove_greater";
        description = "remove_greater : удалить из коллекции все элементы коллекции чьи значения поля studentsCount больше заданного числа";
    }

    /**
     * Метод удаляет все элементы коллекции чьи значения поля studentsCount больше заданного числа
     */
    @Override
    public void execute() {
    }
}
