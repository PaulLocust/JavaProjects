package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class FilterStartsName extends AbstractCommand {
    public FilterStartsName() {
        name = "filter_starts_with_name";
        description = "filter_starts_with_name : показать те элементы коллекции, чьё имя начинается с заданной подстроки.";
    }

    /**
     * Метод, показывающий необходимые элементы коллекции.
     * @param filename название файла со скриптом
     */
    @Override
    public void execute(String filename) {
    }
}
