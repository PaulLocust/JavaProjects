package shared;

import commands.auxillary.AbstractCommand;
import models.StudyGroup;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 666L;

    private StudyGroup studyGroupArgument;
    private AbstractCommand command;
    private String stringArgument;

    public Request(AbstractCommand command) {
        this.command = command;
    }

    public Request(AbstractCommand command, StudyGroup studyGroupArgument) {
        this.command = command;
        this.studyGroupArgument = studyGroupArgument;
    }

    public Request(AbstractCommand command, String stringArgument) {
        this.command = command;
        this.stringArgument = stringArgument;
    }
    public Request(AbstractCommand command, String stringArgument, StudyGroup studyGroupArgument) {
        this.command = command;
        this.stringArgument = stringArgument;
        this.studyGroupArgument = studyGroupArgument;
    }

    public StudyGroup getStudyGroup() {
        return studyGroupArgument;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroupArgument = studyGroup;
    }

    public AbstractCommand getCommand() {
        return command;
    }

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public Object getStringArg() {
        return stringArgument;
    }

    public void setStringArg(String argument) {
        this.stringArgument = argument;
    }

    @Override
    public String toString() {
        return "Request: " + command + " " + studyGroupArgument + " " + stringArgument;
    }
}
