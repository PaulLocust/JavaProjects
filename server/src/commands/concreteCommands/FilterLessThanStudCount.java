package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class FilterLessThanStudCount extends AbstractCommand {
    public FilterLessThanStudCount() {
        name = "filter_less_than_students_count";
        description = "filter_less_than_students_count : показать те элементы коллекции, у которых значение поля studentsCount меньше заданного числа";
    }

    /**
     * Метод, показывающий необходимые элементы коллекции.
     * @param filename название файла со скриптом
     */
    @Override
    public void execute(String filename) {
    }
}
