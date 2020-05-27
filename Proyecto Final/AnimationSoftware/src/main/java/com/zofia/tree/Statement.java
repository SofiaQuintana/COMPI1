/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.tree;

import com.zofia.logic.Environment;
import com.zofia.logic.Sym;
import com.zofia.logic.Sym.Type;
import java.util.LinkedList;
import com.zofia.logic.Error;

/**
 *
 * @author zofia
 */
public class Statement implements Instruction {
    private String id;
    private Expression value;
    private Type type;
    public int line, column;
    
    public Statement(String id, Type type, Expression value, int line, int column) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.line = line;
        this.column = column;
    }
    
    @Override
    public Object execute(Environment environment) {
        try {
            if(value != null) {
                value.setParamsResult(executeParams(value, environment));
                Sym valueResult = (Sym)value.execute(environment);

                    if(valueResult.getType() == type) {
                        Sym sym = new Sym(valueResult.getType(), valueResult.getValue());
                        boolean insert = environment.insert(id, sym);

                        if(!insert) {
                            Error error = new Error(line, column, "Semantico", "La variable '" + id + "' ya existe en el ambito actual.");
                            environment.getErrors().add(error);
                        }
                    } else {
                        Error error = new Error(line, column, "Semantico", "Error de tipos en declaracion, variable: '" + id + "'.");
                        environment.getErrors().add(error);
                    }
                } else {
                    Sym sym;
                    switch(type) {
                        case integer:
                            long integer = 0;
                            sym = new Sym(type, integer);
                            break;
                        case string:
                            sym = new Sym(type, "");
                            break;
                        case bool:
                            sym = new Sym(type, false);
                            break;
                        default:
                            sym = new Sym(type, "@null");
                            break;
                    }
                    boolean insert = environment.insert(id, sym);

                    if(!insert) {
                        Error error = new Error(line, column, "Semantico", "La variable '" + id + "' ya existe en el ambito actual.");
                        environment.getErrors().add(error);
                    }
                }
        } catch(Exception ex) {
            Error error = new Error(line, column, "De ejecucion", "Excepcion no controlada en declaracion de variable.");
            environment.getErrors().add(error);
        }
        return null;
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
                    final Sym s = (Sym) object;
                    if(paramsResult.size() < expression.getParameters().size()) paramsResult.add(i, s);
                    else paramsResult.set(i, s);
                }
            }
        }
        return paramsResult;
    }
    
    public Type getType(Expression.Expression_type type) {
        switch(type) {
            case ENTERO:
                return Type.integer;
            case STRING:
                return Type.string;
            case BOOLEAN:
                return Type.bool;
        }
        return Type.error;
    }
    
    @Override
    public int getLine() {
        return line;
    }
    
    @Override
    public int getColumn() {
        return column;
    }
    
    public void setExpression(Expression expression) {
        this.value = expression;
    }
}
