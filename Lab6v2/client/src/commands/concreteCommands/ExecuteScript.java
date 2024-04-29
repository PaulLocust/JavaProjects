package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class ExecuteScript extends AbstractCommand {
    public ExecuteScript() {
        name = "execute_script";
        description = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }

    /**
     * Метод, выполняющий скрипт заданного файла.
     * @param filename название файла со скриптом
     */
    @Override
    public void execute(String filename) {
    }
}
