package server;

import server.commands.concreteCommands.*;
import server.utility.CollectionFileManager;
import server.utility.CollectionManager;
import server.utility.CommandManager;
import server.utility.RequestHandler;
import java.util.logging.Logger;

public class App {

    public static final int PORT = 1821;
    public static final int CONNECTION_TIMEOUT = 60 * 1000;
    public static final Logger logger = Logger.getLogger(Server.class.getName());


    public static void main(String[] args) {
        String filename = "studyGroups.json";
        if(args.length == 1) filename = args[0];
        CollectionFileManager collectionFileManager = new CollectionFileManager(filename);
        CollectionManager collectionManager = new CollectionManager(collectionFileManager);
        CommandManager commandManager = new CommandManager(
                new Help(),
                new Info(collectionManager),
                new Show(collectionManager),
                new Add(collectionManager),
                new UpdateId(collectionManager),
                new RemoveById(collectionManager),
                new Clear(collectionManager),
                new Save(collectionManager),
                new ExecuteScript(),
                new Exit(),
                new RemoveGreater(collectionManager),
                new RemoveLower(collectionManager),
                new History(),
                new SumOfTransferredStudents(collectionManager),
                new FilterStartsName(collectionManager),
                new FilterLessThanStudCount(collectionManager),
                new ServerExitCommand()
        );
        RequestHandler requestHandler = new RequestHandler(commandManager);
        Server server = new Server(PORT, CONNECTION_TIMEOUT, requestHandler);
        server.run();
    }
}