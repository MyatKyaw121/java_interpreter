package edu.csc413.interpreter.expression;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.statement.ReturnStatement;
import edu.csc413.interpreter.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionCallExpression implements Expression{

    private String funcName;
    private List<Expression> expressions;
    private boolean con=false;

    public FunctionCallExpression(String funcName,List<Expression>expressions)
    {
        this.funcName=funcName;
        this.expressions=expressions;

    }




    @Override
    public int evaluate(ProgramState programState) {

        List<Integer> values = new ArrayList<>();
        for (Expression s : expressions) {
            values.add(s.evaluate(programState));
        }

        List<String> ParamNames = programState.getParameterNames(funcName);
            programState.addCallFrame();

            if (values.size() == ParamNames.size()) {
                for (int i = 0; i < values.size(); i++) {
                    programState.setVariable(ParamNames.get(i), values.get(i));
                }
            }



            boolean skip=false;
            for (Statement s : programState.getFunctionStatements(funcName)) {
                    if (programState.hasReturnValue()) {
                        skip = true;
                }else if (!skip){
                    s.run(programState);
                }
            }




            int val = programState.getReturnValue();
            programState.clearReturnValue();
            programState.removeCallFrame();


            return val;

}
}



