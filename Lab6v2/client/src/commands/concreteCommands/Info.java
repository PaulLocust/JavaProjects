package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class Info extends AbstractCommand {
    public Info() {
        name = "info";
        description = "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    /**
     * Метод выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     */
    @Override
    public void execute() {
    }
}
