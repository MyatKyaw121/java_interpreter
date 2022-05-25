package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;
import edu.csc413.interpreter.expression.FunctionCallExpression;

public class ReturnStatement implements Statement{

    private Expression exp;

    public ReturnStatement(Expression exp){
        this.exp=exp;
    }

    @Override
    public void run(ProgramState programState) {
        programState.setReturnValue(exp.evaluate(programState));

    }

    public Expression getExpression(){
        return this.exp;
    }


}
