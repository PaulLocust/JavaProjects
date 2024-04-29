package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class SumOfTransferredStudents extends AbstractCommand {
    public SumOfTransferredStudents() {
        name = "sum_of_transferred_students";
        description = "sum_of_transferred_students : вывести в стандартный поток вывода сумму всех переведённых студентов коллекции";
    }

    /**
     * Метод, показывающий сумму переведённых студентов из каждого элемента нашей коллекции
     */
    @Override
    public void execute() {
    }
}
