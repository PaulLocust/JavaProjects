package commands.concreteCommands;

import commands.auxillary.AbstractCommand;
import exceptions.ExtraArgumentException;
import utility.Program;

import java.util.Scanner;

public class Exit extends AbstractCommand {
    public Exit() {
        name = "exit";
        description = "exit : завершить программу (с сохранением в файл)";
    }

    /**
     * Метод, предлагающий завершить программу.
     */
    @Override
    public void execute() {
        System.out.print("Уверены? Последние изменения не сохранятся y/n: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
            System.out.print("Уверены? Последние изменения не сохранятся y/n: ");
            answer = scanner.next();
        }
        if (answer.equalsIgnoreCase("y")) {
            Program.getInstance().stop();
        } else {
            System.out.println("Отмена завершения работы.");
        }
    }

    @Override
    public void execute(String arg) {
        try {
            throw new ExtraArgumentException(name);
        } catch (ExtraArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
