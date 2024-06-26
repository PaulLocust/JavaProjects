package server.utility;

import common.interaction.Request;
import common.interaction.Response;
import common.interaction.ResponseResult;

/**
 * Handles requests.
 */
public class RequestHandler {
    private final CommandManager commandManager;

    public RequestHandler(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    /**
     * Handles requests.
     *
     * @param request Request to be processed.
     * @return Response to request.
     */
    public Response handle(Request request){
        commandManager.addToHistory(request.getCommandName());
        ResponseResult responseResult = executeCommand(
                request.getCommandName(),
                request.getCommandStringArgument(),
                request.getCommandObjectArgument());
        return new Response(responseResult, ResponseOutputer.getAndClear());
    }

    /**
     * Executes a command from a request.
     *
     * @param command               Name of command.
     * @param commandStringArgument String argument for command.
     * @param commandObjectArgument Object argument for command.
     * @return Command execute status.
     */
    private ResponseResult executeCommand(String command, String commandStringArgument,
                                          Object commandObjectArgument) {

        switch (command) {
            case "":
                break;
            case "help":
                if (!commandManager.askHelp(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "info":
                if (!commandManager.giveInfo(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "show":
                if (!commandManager.showCollectionElements(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "add":
                if (!commandManager.addElement(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "update":
                if (!commandManager.updateElementById(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "remove_by_id":
                if (!commandManager.removeElementById(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "clear":
                if (!commandManager.clearCollection(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "save":
                if (!commandManager.saveCollection(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "execute_script":
                if (!commandManager.executeScript(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "remove_lower":
                if (!commandManager.removeLower(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "history":
                if (!commandManager.showCommandHistory(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "sum_of_transferred_students":
                if (!commandManager.showSumOfTransferredStudents(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "filter_starts_with_name":
                if (!commandManager.showFilterStartsWithName(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "filter_less_than_students_count":
                if (!commandManager.showFilteredLessThanStudCount(commandStringArgument, commandObjectArgument)) return ResponseResult.ERROR;
                break;
            case "server_exit":
                if (!commandManager.serverExit(commandStringArgument, commandObjectArgument))
                    return ResponseResult.ERROR;
                return ResponseResult.SERVER_EXIT;
            default:
                ResponseOutputer.appendLn("Command '" + command + "' was not found. Try to write 'help' for more info.");
                return ResponseResult.ERROR;
        }
        return ResponseResult.OK;
    }
}