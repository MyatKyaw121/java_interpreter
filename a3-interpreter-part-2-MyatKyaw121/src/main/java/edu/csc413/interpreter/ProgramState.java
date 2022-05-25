package edu.csc413.interpreter;

import edu.csc413.interpreter.statement.ReturnStatement;
import edu.csc413.interpreter.statement.Statement;
import java.util.*;

/**
 * ProgramState represents the Program's storage information at any point in time while the program is running. It
 * should keep track of all defined variables, as well as their assigned values, and allow the running program to read
 * or set those values.
 */
public class ProgramState {
    private Stack<HashMap<String, Integer>> callStack;
    private Map<String,List<String>> funcParams;
    private Map<String,List<Statement>>FucnBodyStatements;
    private List<Integer>returnVal;
   // private int returnValue;



    // TODO: Implement. Add any other instance variables you need.
    public ProgramState() {
        callStack = new Stack<>();
        funcParams=new HashMap<>();
        FucnBodyStatements=new HashMap<>();
        returnVal=new ArrayList<>();
        addCallFrame();
        // TODO: Implement. Initialize any instance variables you added.
    }

    /** Returns the integer value associated with the specified variable name in the current call frame. */
    public int getVariable(String variable) {
        HashMap<String, Integer> topCallFrame = callStack.peek();
        if (!topCallFrame.containsKey(variable)) {
            throw new RuntimeException("Undefined variable: " + variable);
        }
        return topCallFrame.get(variable);
    }

    /** Sets the value for the specified variable name to the specified value in the current call frame. */
    public void setVariable(String variable, int value) {
        callStack.peek().put(variable, value);
    }

    /** Adds a new, empty call frame to the top of the call stack, making it the new current call frame. */
    public void addCallFrame() {
        callStack.push(new HashMap<>());
    }

    /**
     * Removes the topmost call frame from the call stack. The current call frame becomes the previous one in the stack.
     */
    public void removeCallFrame() {
        if (callStack.size() <= 1) {
            throw new RuntimeException("Current call frame is the main program call frame, and cannot be removed.");
        }
        callStack.pop();
    }

    /**
     * Registers a function's parameter names and function statements so that they can be looked up later on using just
     * the function name.
     */
    public void registerFunction(String functionName, List<String> parameterNames, List<Statement> functionStatements) {
       funcParams.put(functionName,parameterNames);
        FucnBodyStatements.put(functionName,functionStatements);

    }

    /** Returns the list of parameter names associated with the specified function name. */
    public List<String> getParameterNames(String functionName) {

        return funcParams.get(functionName);
    }

    /** Returns the list of function statements associated with the specified function name. */
    public List<Statement> getFunctionStatements(String functionName) {
        // TODO: Implement.
        return FucnBodyStatements.get(functionName);
    }

    /** Returns whether or not a return value has been recorded. */
    public boolean hasReturnValue() {
        // TODO: Implement.
        return !returnVal.isEmpty();
    }

    /** Returns the recorded return value, if it exists. */
    public int getReturnValue() {

      return this.returnVal.get(0);


    }

    /** Records a return value. hasReturnValue should return true after this method is called. */
    public void setReturnValue(int returnValue) {
        returnVal.clear();
        returnVal.add(returnValue);
    }

    /** Clears the recorded return value. hasReturnValue should return false after this method is called. */
    public void clearReturnValue() {
      returnVal.clear();
    }
}
