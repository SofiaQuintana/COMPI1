package com.zofia.lexers;
import java_cup.runtime.*;
import com.zofia.parsers.timers.sym;
import com.zofia.drivers.CanvasDriver;
import com.zofia.logic.Error;

%%//Area Break

%public
%class TimeLexer
%cup
%cupdebug
%line
%column

/*Identifiers*/
Letter = [a-zA-ZÑñ]
Number = [0-9]
LineTerminator = \r|\n|\r\n 
WhiteSpace = {LineTerminator} | [ \t\f\b]
Identifier = ({Letter} | "_")({Letter} | {Number} | "_")*
Int = ({Number})({Number})* 

%{  
    private CanvasDriver driver;
    
    public TimeLexer(java.io.Reader in, CanvasDriver driver) {
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
%}

%%//Area Break

/*Lexical Rules*/

<YYINITIAL> {
    /* Keywords */
    "TIEMPOS"                     { printToken("TIEMPOS"); return symbol(sym.TIEMPOS, "TIEMPOS"); }
    "inicio"                      { printToken("inicio"); return symbol(sym.INICIO, "inicio"); }
    "fin"                         { printToken("fin"); return symbol(sym.FIN, "fin");}
    "imagenes"                    { printToken("imagenes"); return symbol(sym.IMAGENES, "imagenes");}
    "id"                          { printToken("id"); return symbol(sym.ID, "id");}
    "duracion"                    { printToken("duracion"); return symbol(sym.DURACION, "duracion");}
    /* Signs */
    "{"                         { printToken("{"); return symbol(sym.CURLYBRACKETO, "{");}
    "}"                         { printToken("}"); return symbol(sym.CURLYBRACKETC, "}");}
    ":"                         { printToken(":"); return symbol(sym.COLON, ":");}
    ","                         { printToken(","); return symbol(sym.COMMA, ",");}
    "\""                        { printToken("\""); return symbol(sym.QUOTE, "\"");}
    "["                        { printToken("["); return symbol(sym.BRACKETO, "[");}
    "]"                        { printToken("]"); return symbol(sym.BRACKETC, "]");}
    /* Others */
    {Identifier}                { printToken("Id: " + yytext()); return symbol(sym.IDENTIFICADOR, yytext());}
    {Int}                       { printToken(yytext()); return symbol(sym.INT, Integer.parseInt(yytext()));}
    {WhiteSpace}                { /*do nothing*/ }
    .                           { printToken("ERROR: " + yytext()); error(yytext(), yyline+1, yycolumn+1); 
                                  error(yytext(), yyline+1, yycolumn+1); }
}

    <<EOF>>                     { return symbol(sym.EOF); } 

