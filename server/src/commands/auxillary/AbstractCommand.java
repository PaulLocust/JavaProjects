package commands.auxillary;

import java.io.Serializable;

public abstract class AbstractCommand implements Serializable {
    protected String name;
    protected String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void execute() {
        try {
            throw new NecessaryArgumentException(name);
        } catch (NecessaryArgumentException e) {
            ResponseBuilder responseBuilder = Program.getInstance().getResponseBuilder();
            responseBuilder.add(e.getMessage());
        }
    };

    public void execute(String arg) {
        try {
            throw new ExtraArgumentException(name);
        } catch (ExtraArgumentException e) {
            ResponseBuilder responseBuilder = Program.getInstance().getResponseBuilder();
            responseBuilder.add(e.getMessage());
        }
    }
}
