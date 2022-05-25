package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;

import java.util.List;

public class WhileStatement extends BlockStatement{

    public WhileStatement(Condition con, List<Statement> other){
        super(con,other);
    }


    @Override
    public void run(ProgramState programState) {
        while(super.getCondition().evaluate(programState)){
            for (Statement statement: super.getStatements()) {
                statement.run(programState);
            }
        }
    }
}
