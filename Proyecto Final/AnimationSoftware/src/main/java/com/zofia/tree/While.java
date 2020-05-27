/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.tree;

import com.zofia.logic.Environment;
import com.zofia.logic.Sym;
import java.util.LinkedList;

/**
 *
 * @author zofia
 */
public class While implements Instruction {
    private Expression condition;
    private LinkedList<Instruction> instructionsList;
    private int line, column;

    public While(Expression condition, LinkedList<Instruction> instructionsList, int line, int column) {
        this.condition = condition;
        this.instructionsList = instructionsList;
        this.line = line;
        this.column = column;
    }

     public Object execute(Environment environment) {
        boolean end = false;
        boolean next = false;

        try {
            condition.setParamsResult(executeParams(condition, environment));
            while ((boolean)((Sym)condition.execute(environment)).getValue()) {
                Environment localEnv = new Environment(environment);

                if(instructionsList != null) {
                    for(Instruction ins : instructionsList) {
      
                        if(ins instanceof Expression) {
                            Expression expression = (Expression) ins;
                            expression.setParamsResult(executeParams(expression, localEnv));
                            ins = expression;
                        } else if(ins instanceof Paint) {
                            
                        }
                        Object instruction = ins.execute(localEnv);
                      
            
                    }

                    if (end) break;
                    if (next) continue;
                }
            }
        }
        catch(Exception ex)
        {
            Error_ error = new Error_(line, column, "De ejecucion", "Excepcion no controlada en sentencia 'While'.");
            environment.getGlobal().errors.add(error);
        }
        return null;
    }
    
    public LinkedList<Sym> executeParams(LinkedList<Expression> parameters, Environment environment) {
        LinkedList<Sym> params = new LinkedList<>();
        if(parameters != null) {
            for(Expression exp : parameters) {
                exp.setParamsResult(executeParams(exp, environment));
                Object object = exp.execute(environment);
                if(object instanceof Sym) {
                    Sym s = (Sym) object;
                    params.add(s);
                }
            }
        }
        return params;
    }
    
    public LinkedList<Sym> executeParams(Expression expression, Environment environment) {
        LinkedList<Sym> paramsResult = null;
        if(expression != null && expression.getParameters() != null) {
            paramsResult = new LinkedList<>();
            for(int i = 0; i < expression.getParameters().size(); i++) {
                Expression exp = expression.getParameters().get(i);
                exp.setParamsResult(executeParams(exp, environment));
                Object object = exp.execute(environment);
                if(object instanceof Sym) {
                    final Sym sym = (Sym) object;
                    if(paramsResult.size() < expression.getParameters().size()) paramsResult.add(i, sym);
                    else paramsResult.set(i, sym);
                }
            }
        }
        return paramsResult;
    }
    
    @Override
    public int getLine() {
        return line;
    }
    
    @Override
    public int getColumn() {
        return column;
    }
}
