package commands.concreteCommands;

import commands.auxillary.AbstractCommand;

public class Help extends AbstractCommand {
    public Help() {
        name = "help";
        description = "help : вывести справку по доступным командам";
    }

    @Override
    public void execute() {

    }
}
