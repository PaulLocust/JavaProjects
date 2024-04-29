package stateManager;

import commands.auxillary.AbstractCommand;
import commands.concreteCommands.*;
import models.StudyGroup;
import shared.Request;
import utility.ConsoleWriter;
import utility.Program;
import utility.StudyGroupScanner;

import java.util.Arrays;
import java.util.Map;

/**
 * Класс, отвечающий за определение команд и дальнейшее их исполнение.
 */
public class CommandsManager {
    private static final Map<String, AbstractCommand> commands = Map.ofEntries(
            Map.entry(new Help().getName(), new Help()),
            Map.entry(new Info().getName(), new Info()),
            Map.entry(new Show().getName(), new Show()),
            Map.entry(new Add().getName(), new Add()),
            Map.entry(new UpdateId().getName(), new UpdateId()),
            Map.entry(new RemoveById().getName(), new RemoveById()),
            Map.entry(new Clear().getName(), new Clear()),
            Map.entry(new ExecuteScript().getName(), new ExecuteScript()),
            Map.entry(new Exit().getName(), new Exit()),
            Map.entry(new RemoveGreater().getName(), new RemoveGreater()),
            Map.entry(new RemoveLower().getName(), new RemoveLower()),
            Map.entry(new History().getName(), new History()),
            Map.entry(new SumOfTransferredStudents().getName(), new SumOfTransferredStudents()),
            Map.entry(new FilterStartsName().getName(), new FilterStartsName()),
            Map.entry(new FilterLessThanStudCount().getName(), new FilterLessThanStudCount())
    );

    /**
     * Метод определяет команду для последующего исполнения.
     *
     * @param userInput строка считанная из консоли, в которой содержится команда
     */
    public static void defineCommand(String[] userInput) {
        String keyWord = userInput[0];
        if (commands.containsKey(keyWord)) {
            if (userInput.length > 2) {
                ConsoleWriter.getInstance().alert("Too much arguments!");
            } else if (userInput.length == 2) {
                sendCommand(keyWord, userInput[1]);
                try {
                    System.out.println(getResponse().trim());
                } catch (NullPointerException ignored) {}

            } else {
                if (keyWord.equals(new Exit().getName())) {
                    new Exit().execute();
                } else {
                    sendCommand(keyWord);
                    String response = getResponse();
                    try {
                        System.out.println(response.trim());
                    } catch (NullPointerException ignored) {}
                }
            }
        } else if (keyWord.isEmpty()) {
            ConsoleWriter.getInstance().alert("Пустая команда!");
        } else {
            ConsoleWriter.getInstance().alert("Такой команды нет!");
        }
    }

    private static void sendCommand(String commandName, String arg) {
        AbstractCommand command = commands.get(commandName);
        Request request;
        StudyGroup studyGroup;
        if (Arrays.asList(new Add().getName(), new UpdateId().getName()).contains(commandName)) {
            studyGroup = StudyGroupScanner.scan();
            request = new Request(command, arg, studyGroup);
        } else {
            request = new Request(command, arg);
        }
        Program.getInstance().getRequestLogic().send(request);
    }

    private static void sendCommand(String commandName) {
        AbstractCommand command = commands.get(commandName);
        Request request;
        StudyGroup studyGroup;
        if (Arrays.asList(new RemoveGreater().getName(), new RemoveLower().getName()).contains(commandName)) {
            studyGroup = StudyGroupScanner.scan();
            request = new Request(command, studyGroup);
        } else {
            request = new Request(command);
        }

        Program.getInstance().getRequestLogic().send(request);
    }

    private static String getResponse() {
        return Program.getInstance().getResponseLogic().receive();
    }
}
