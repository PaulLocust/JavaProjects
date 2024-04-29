package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class RemoveLower extends AbstractCommand {
    public RemoveLower() {
        name = "remove_lower";
        description = "remove_lower : удалить из коллекции все элементы коллекции чьи значения поля studentsCount меньше заданного числа";
    }

    /**
     * Метод удаляет все элементы коллекции чьи значения поля studentsCount меньше заданного числа
     */
    @Override
    public void execute() {
    }
}
