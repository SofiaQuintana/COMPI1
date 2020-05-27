/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.tree;

import com.zofia.logic.Environment;
import com.zofia.logic.Error;
import com.zofia.logic.Sym;
import com.zofia.logic.Sym.Type;
import java.util.LinkedList;

/**
 *
 * @author zofia
 */
public class Expression implements Instruction {
    public static enum Expression_type {
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NEGATIVO,
        ENTERO,
        STRING,
        BOOLEAN,
        IDENTIFICADOR,
        MAYOR_QUE,
        MENOR_QUE,
        MAYOR_IGUAL,
        MENOR_IGUAL,
        IGUAL_IGUAL,
        ENTRE,
        AND,
        OR
    }
     
    private LinkedList<Expression> parameters;
    private LinkedList<Sym> paramsResult, symResult;
    private Expression_type type;
    private Expression leftExp;
    private Expression rightExp;
    private Object value;
    private Sym val;
    private int line, column;

    public Expression(Expression leftExp, Expression rightExp, Expression_type type,  int line, int column) {
        this.type = type;
        this.leftExp = leftExp;
        this.rightExp = rightExp;
        this.val = new Sym();
        this.line = line;
        this.column = column;
    }
    
    public Expression(Expression exp, int line, int column) {
        this.type = exp.type;
        this.leftExp = exp.leftExp;
        this.rightExp = exp.rightExp;
        this.value = exp.value;
        this.val = new Sym();
        this.line = line;
        this.column = column;
    }
    
     //* Constructor para operaciones unarias (un operador), estas operaciones son:
     //* NEGATIVO NOT
    public Expression(Expression leftExp, Expression_type type, int line, int column) {
        this.type = type;
        this.leftExp = leftExp;
        this.val = new Sym();
        this.line = line;
        this.column = column;
    }
    
    public Expression(String id, Expression_type type, int line, int column) {
        this.value = id;
        this.type = type;
        this.val = new Sym();
        this.line = line;
        this.column = column;
    }
    
    public Expression(long integer, int line, int column) {
        this.value = integer;
        this.type = Expression_type.ENTERO;
        this.val = new Sym(Type.integer, integer);
        this.line = line;
        this.column = column;
    }
    
    public Expression(String string, int line, int column) {
        this.value = string;
        this.type = Expression_type.STRING;
        val = new Sym(Type.string, string);
        this.line = line;
        this.column = column;
    }
    
    public Expression(boolean booleano, int line, int column) {
        this.value = booleano;
        this.type = Expression_type.BOOLEAN;
        val = new Sym(Type.bool, booleano);
        this.line = line;
        this.column = column;
    }
    
    public LinkedList<Sym> executeParams(Expression expression, Environment environment) {
        LinkedList<Sym> temporal = null;
        
        if(expression != null && expression.getParameters() != null) {
            temporal = new LinkedList<>();
            for(int i = 0; i < expression.getParameters().size(); i++) {
                Expression exp = expression.getParameters().get(i);
                exp.setParamsResult(executeParams(exp, environment));
                Object object = exp.execute(environment);
                if(object instanceof Sym) {
                    final Sym sym = (Sym) object;
                    if(temporal.size() < expression.getParameters().size()) temporal.add(i, sym);
                    else temporal.set(i, sym);
                }
            }
        }
        return temporal;
    }
    
    @Override
    public Object execute(Environment environment) {
        if(leftExp != null) {
            leftExp.setParamsResult(executeParams(leftExp, environment));
        }
        if(rightExp != null) {
            rightExp.setParamsResult(executeParams(rightExp, environment));
        }
        
        switch (type) {
            case DIVISION:
                return division(environment);
            case MULTIPLICACION:
                return multiplicacion(environment);
            case RESTA:
                return resta(environment);
            case SUMA:
                return suma(environment);
            case MAYOR_QUE:
                return mayorQue(environment);
            case MENOR_QUE:
                return menorQue(environment);
            case MAYOR_IGUAL:
                return mayorIgual(environment);
            case MENOR_IGUAL:
                return menorIgual(environment);
            case IGUAL_IGUAL:
                return igualIgual(environment);
            case AND:
                return and(environment);
            case OR:
                return or(environment);
            case NEGATIVO:
                return negative(environment);
            case ENTERO:
                return val;
            case STRING:
                return val;
            case BOOLEAN:
                return val;
            case IDENTIFICADOR:
                return identifier(environment);
            default:
                return null;
        }
    }
    
    public Object identifier(Environment environment) {
        Sym sym = environment.search(value.toString());
        if(sym != null) {
            val = new Sym(sym.getType(), sym.getValue());
            return new Sym(sym.getType(), sym.getValue());
        }
        Error error = new Error(line, column, "Semantico", "La variable '" + value.toString() + "' no existe en el ambito actual.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object negative(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        
        if(leftResult.getType() == Type.integer) {
            val = new Sym(Type.integer, (long)leftResult.getValue() * -1);
            return new Sym(Type.integer, (long)leftResult.getValue() * -1);
        } 
        Error error = new Error(line, column, "Semantico", "El operando negativo solo puede aplicarse a datos de tipo entero.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object division(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        
        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    if((long)rightResult.getValue() == 0) {
                        Error error = new Error(line, column, "De ejecucion", "No se puede realizar division entre cero.");
                        environment.getErrors().add(error);
                        return new Sym(Type.error, "@error");
                    }
                    long result = (long)leftResult.getValue() / (long)rightResult.getValue();
                    val = new Sym(Type.integer, result);
                    return new Sym(Type.integer, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion division.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object multiplicacion(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        
        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer: 
                    long result = (long)leftResult.getValue() * (long)rightResult.getValue();
                    val = new Sym(Type.integer, result);
                    return new Sym(Type.integer, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion multiplicacion.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object resta(Environment env) {
        Sym leftResult = (Sym)leftExp.execute(env);
        Sym rightResult = (Sym)rightExp.execute(env);
        
        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer: 
                    long result = (long)leftResult.getValue() - (long)rightResult.getValue();
                    val = new Sym(Type.integer, result);
                    return new Sym(Type.integer, result);
            }      
        }     
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion resta.");
        env.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object suma(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);

        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    long result1 = (long)leftResult.getValue() + (long)rightResult.getValue();
                    val = new Sym(Type.integer, result1);
                    return new Sym(Type.integer, result1);

                case string:
                    String result = leftResult.getValue().toString() + (String)rightResult.getValue();
                    val = new Sym(Type.string, result);
                    return new Sym(Type.string, result);
            }
        } else if(leftResult.getType() == Type.string) {
            switch(rightResult.getType()) {
                case integer:
                    String result1 = (String)leftResult.getValue() + rightResult.getValue().toString();
                    val = new Sym(Type.string, result1);
                    return new Sym(Type.string, result1);

                case string:
                    String result2 = (String)leftResult.getValue() + rightResult.getValue().toString();
                    val = new Sym(Type.string, result2);
                    return new Sym(Type.string, result2);

                case bool:
                    String result3 =  (String)leftResult.getValue() + rightResult.getValue().toString();
                    val = new Sym(Type.string, result3);
                    return new Sym(Type.string, result3);
            }
        } else if(leftResult.getType() == Type.bool) {
            switch(rightResult.getType()) {
                case string:
                    String result =  leftResult.getValue().toString() + (String)rightResult.getValue();
                    val = new Sym(Type.string, result);
                    return new Sym(Type.string, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion suma.");
        environment.getErrors().add(error);
        return new Sym (Type.error, "@error");
    }
    
     public Object mayorQue(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        boolean result;

        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    result = (long)leftResult.getValue() > (long)rightResult.getValue();
                    val = new Sym(Type.bool, result);
                    return new Sym(Type.bool, result);
            }
        } 
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion mayor que.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object menorQue(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        boolean result;

        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    result = (long)leftResult.getValue() < (long)rightResult.getValue();
                    val = new Sym(Type.bool, result);
                    return new Sym(Type.bool, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion menor que.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object mayorIgual(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        boolean result;

        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    result = (long)leftResult.getValue() >= (long)rightResult.getValue();
                    val = new Sym(Type.bool, result);
                    return new Sym(Type.bool, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion mayor igual que.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object menorIgual(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        boolean result;

        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    result = (long)leftResult.getValue() <= (long)rightResult.getValue();
                    val = new Sym(Type.bool, result);
                    return new Sym(Type.bool, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion menor igual que.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object igualIgual(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        boolean result;

        if(leftResult.getType() == Type.integer) {
            switch(rightResult.getType()) {
                case integer:
                    result = (long)leftResult.getValue() == (long)rightResult.getValue();
                    val = new Sym(Type.bool, result);
                    return new Sym(Type.bool, result);
            }
        }
        else if(leftResult.getType() == Type.string) {
            if(rightResult.getType() == Type.string) {
                result = ((String)leftResult.getValue()).equals((String)rightResult.getValue());
                val = new Sym(Type.bool, result);
                return new Sym(Type.bool, result);
            }
        }
        else if(leftResult.getType() == Type.bool) {
            if(rightResult.getType() == Type.bool) {
                result = (boolean)leftResult.getValue() == (boolean) rightResult.getValue();
                val = new Sym(Type.bool, result);
                return new Sym(Type.bool, result);
            }
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion igual igual.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object and(Environment env) {
        Sym leftResult = (Sym)leftExp.execute(env);
        Sym rightResult = (Sym)rightExp.execute(env);
        boolean result;
        
        if(leftResult.getType() == Type.bool && leftResult.getType() == Type.bool) {
            result = (boolean)leftResult.getValue() && (boolean)rightResult.getValue();
            val = new Sym(Type.bool, result);
            return new Sym(Type.bool, result);
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion and.");
        env.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    public Object or(Environment environment) {
        Sym leftResult = (Sym)leftExp.execute(environment);
        Sym rightResult = (Sym)rightExp.execute(environment);
        boolean result;
        
        if(leftResult.getType() == Type.bool && leftResult.getType() == Type.bool) {
            result = (boolean)leftResult.getValue() || (boolean)rightResult.getValue();
            val = new Sym(Type.bool, result);
            return new Sym(Type.bool, result);
        }
        Error error = new Error(line, column, "Semantico", "Alguno o ambos operandos son de tipo incorrecto para la operacion or.");
        environment.getErrors().add(error);
        return new Sym(Type.error, "@error");
    }
    
    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }
    
    public Expression_type getType(Sym.Type type) {
        switch(type) {
            case integer:
                return Expression_type.ENTERO;
            case string:
                return Expression_type.STRING;
            case bool:
                return Expression_type.BOOLEAN;
        }
        return null;
    }

    public LinkedList<Expression> getParameters() {
        return parameters;
    }

    public LinkedList<Sym> getParamsResult() {
        return paramsResult;
    }

    public LinkedList<Sym> getSymResult() {
        return symResult;
    }

    public Expression getLeftExp() {
        return leftExp;
    }

    public Expression getRightExp() {
        return rightExp;
    }

    public Object getValue() {
        return value;
    }

    public Sym getVal() {
        return val;
    }

    public void setParamsResult(LinkedList<Sym> paramsResult) {
        this.paramsResult = paramsResult;
    }
    
}
