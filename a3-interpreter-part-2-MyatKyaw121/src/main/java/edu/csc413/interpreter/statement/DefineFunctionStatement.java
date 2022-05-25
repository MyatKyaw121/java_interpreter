package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class DefineFunctionStatement implements Statement{
    private String funcName;
    private List<String>params;
    private List<Statement> statements;

    public DefineFunctionStatement(String funcName,List<String>params,List<Statement>statements)
    {
        this.funcName=funcName;
        this.params=params;
        this.statements=statements;
    }

    @Override
    public void run(ProgramState programState) {

    programState.registerFunction(funcName,params,statements);

    }
}
