package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;

import java.util.List;

public abstract class BlockStatement implements Statement{
    private Condition condition;
    private List<Statement> otherStatements;


    public BlockStatement(Condition condition,List<Statement>otherStatements){
        this.condition=condition;
        this.otherStatements=otherStatements;
    }


    protected Condition getCondition(){
        return this.condition;
    }

    protected List<Statement> getStatements(){
        return this.otherStatements;
    }








}
