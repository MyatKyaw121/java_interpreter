package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;
import edu.csc413.interpreter.expression.Expression;

import java.util.List;

public class ForStatement extends BlockStatement{

    private String var;
    private Expression startVal;
    private Expression endVal;
    public ForStatement(List<Statement>other,String var,Expression startVal,Expression endVal){
        super(null,other);
        this.var=var;
        this.startVal=startVal;
        this.endVal=endVal;
    }



    @Override
    public void run(ProgramState programState) {

        int start=startVal.evaluate(programState);
        int end=endVal.evaluate(programState);
        programState.setVariable(var,startVal.evaluate(programState));
        while(programState.getVariable(var)!=end){
            for(Statement s:super.getStatements()){
                s.run(programState);
            }
            programState.setVariable(var, programState.getVariable(var)+1);

        }

    }
}
