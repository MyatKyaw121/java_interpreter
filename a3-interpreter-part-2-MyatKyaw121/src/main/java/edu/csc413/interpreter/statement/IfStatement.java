package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;
import edu.csc413.interpreter.expression.FunctionCallExpression;

import javax.swing.text.html.BlockView;
import java.util.List;

/**
 * Statement representing an if-statement, with a condition check and a list of statements that are only run if the
 * condition evaluates to true.
 */
// TODO: Implement. IfStatement and WhileStatement share a lot in common; find a way to avoid code duplication.
public class IfStatement extends BlockStatement {


    private boolean evaluated=false;
    public IfStatement(Condition condition, List<Statement> otherStatements) {
      super(condition,otherStatements);
    }


    @Override
    public void run(ProgramState programState) {
        if (super.getCondition().evaluate(programState)) {
            for (Statement statement: super.getStatements()) {
                statement.run(programState);
            }
        }
    }



}
