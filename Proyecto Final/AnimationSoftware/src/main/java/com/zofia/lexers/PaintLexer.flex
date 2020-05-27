package com.zofia.lexers;
import java_cup.runtime.*;
import com.zofia.parsers.paint.sym;
import com.zofia.drivers.CanvasDriver;
import com.zofia.logic.Error;

%%//Area Break

%public
%class PaintLexer
%cup
%cupdebug
%line
%column

/*Identifiers*/
Letter = [a-zA-ZÑñ]
Number = [0-9]

InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n 
WhiteSpace = {LineTerminator} | [ \t\f\b]

Identifier = ({Letter} | "_")({Letter} | {Number} | "_")*
string = "\"" [^*] ~"\""
Int = ({Number})+
Rank = ({Number})+("..")({Number})+
TraditionalCommentary = "/*" [^*] ~"*/"
BasicCommentary = "//" {InputCharacter}* {LineTerminator}?
Commentary = {TraditionalCommentary} | {BasicCommentary}

%{  
    private CanvasDriver driver;
    
    public PaintLexer(java.io.Reader in, CanvasDriver driver) {
        this.zzReader = in;
        this.driver = driver;
    }

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void printToken(String token){
        System.out.println(token);
    }

    private void error(String value, int line, int column) {
        Error error = new Error(line, column, "Lexico", "Elemento lexico desconocido: '" + yytext() + "'");
        driver.getErrors().add(error);
    }
    
    private void invalid_symbol(String message) {
        System.out.println(message);
    }
%}

%%//Area Break

/*Lexical Rules*/

<YYINITIAL> {
    /* Keywords */
    "VARS"                      { printToken("VARS"); return symbol(sym.VARS, "VARS"); }
    "int"                       { printToken("int"); return symbol(sym.INT, "int"); }
    "String"                    { printToken("String"); return symbol(sym.STRING, "String");}
    "boolean"                   { printToken("boolean"); return symbol(sym.BOOLEAN, "boolean");}
    "INSTRUCCIONES"             { printToken("INSTRUCCIONES"); return symbol(sym.INSTRUCCIONES, "INSTRUCCIONES");}
    "PINTAR"                    { printToken("PINTAR"); return symbol(sym.PINTAR, "PINTAR");}
    "true"                      { printToken("true"); return symbol(sym.TRUE, "true"); }
    "false"                     { printToken("false"); return symbol(sym.FALSE, "false"); }
    "AND"                       { printToken("AND"); return symbol(sym.AND, "AND"); }
    "OR"                        { printToken("OR"); return symbol(sym.OR, "OR"); }
    "while"                     { printToken("while"); return symbol(sym.WHILE, "while"); }
    "if"                        { printToken("if"); return symbol(sym.IF, "if"); }
    "else"                      { printToken("else"); return symbol(sym.ELSE, "else"); }

    /* Signs */
    "{"                         { printToken("{"); return symbol(sym.CURLYBRACKETO, "{");}
    "}"                         { printToken("}"); return symbol(sym.CURLYBRACKETC, "}");}
    "["                         { printToken("["); return symbol(sym.BRACKETO, "[");}
    "]"                         { printToken("]"); return symbol(sym.BRACKETC, "]");}
    "("                         { printToken("("); return symbol(sym.PARENTHESISO, "(");}
    ")"                         { printToken(")"); return symbol(sym.PARENTHESISC, ")");}
    ","                         { printToken(","); return symbol(sym.COMMA, ",");}
    ";"                         { printToken(";"); return symbol(sym.SEMICOLON, ";");}    
    "."                         { printToken("."); return symbol(sym.DOT, ".");}
    "="                         { printToken("="); return symbol(sym.EQUAL, "=");}
    "=="                        { printToken("=="); return symbol(sym.SAME, "==");}
    "<"                         { printToken("<"); return symbol(sym.LESSTHAN, "<");}
    ">"                         { printToken(">"); return symbol(sym.GREATERTHAN, ">");}
    "<="                        { printToken("<="); return symbol(sym.LESSEQUAL, "<=");}
    "=>"                        { printToken("=>"); return symbol(sym.GREATEREQUAL, ">=");}
    "<>"                        { printToken("<>"); return symbol(sym.BETWEEN, "<>");}
    "+"                         { printToken("+"); return symbol(sym.PLUS, "+");}
    "-"                         { printToken("-"); return symbol(sym.MINUS, "-");}
    "*"                         { printToken("*"); return symbol(sym.STAR, "*");}
    "/"                         { printToken("/"); return symbol(sym.DIAGONAL, "/");}

    /* Others */
    {Identifier}                { printToken("Id: " + yytext()); return symbol(sym.ID, yytext());}
    {string}                    { printToken("cadena: " + yytext()); return symbol(sym.STRING_, yytext());}
    {Rank}                      { printToken("rank: " + yytext()); return symbol(sym.RANK, yytext());}
    {Commentary}                { printToken("Comment: " + yytext()); /*Do nothing*/ }
    {Int}                       { printToken(yytext()); return symbol(sym.INTEGER, Integer.parseInt(yytext()));}
    {WhiteSpace}                { /*do nothing*/ }
    .                           { printToken("ERROR: " + yytext()); 
                                  error(yytext(), yyline+1, yycolumn+1); }
}
    [^] {invalid_symbol("Simbolo invalido <"+ yytext()+">");}
    <<EOF>>                     { return symbol(sym.EOF); } 

