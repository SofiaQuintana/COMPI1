package com.zofia.lexers;
import java_cup.runtime.*;
import com.zofia.parsers.colors.sym;
import com.zofia.drivers.CanvasDriver;
import com.zofia.logic.Error;

%%//Area Break

%public
%class ColorsLexer
%cup
%cupdebug
%line
%column

/*Identifiers*/
Letter = [a-zA-Z]
Number = [0-9]
HexNumber = [0-9a-fA-F]
LineTerminator = \r|\n|\r\n 
WhiteSpace = {LineTerminator} | [ \t\f\b]
Identifier = ({Letter} | "_")({Letter} | {HexNumber} | "_")*
Int = ({Number})({Number})* 
HexCode = ("#")({HexNumber})({HexNumber})({HexNumber})({HexNumber})({HexNumber})({HexNumber})

%{
    private CanvasDriver driver;

    public ColorsLexer(java.io.Reader in, CanvasDriver driver) {
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
    "COLORES"                     { printToken("COLORES"); return symbol(sym.COLORES, "COLORES"); }
    "Red"                         { printToken("Red"); return symbol(sym.RED, "Red");}
    "Blue"                        { printToken("Blue"); return symbol(sym.BLUE, "Blue");}
    "Green"                       { printToken("Green"); return symbol(sym.GREEN, "Green");}
    "HEX"                         { printToken("HEX"); return symbol(sym.HEX, "HEX");}
    /* Signs */
    "{"                         { printToken("{"); return symbol(sym.CURLYBRACKETO, "{");}
    "}"                         { printToken("}"); return symbol(sym.CURLYBRACKETC, "}");}
    ":"                         { printToken(":"); return symbol(sym.COLON, ":");}
    ","                         { printToken(","); return symbol(sym.COMMA, ",");}
    /* Others */
    {Identifier}                { printToken("Id: " + yytext()); return symbol(sym.ID, yytext());}
    {Int}                       { printToken(yytext()); return symbol(sym.INT, Integer.parseInt(yytext()));}
    {HexCode}                   { printToken(yytext()); return symbol(sym.HEXCODE, yytext());}
    {WhiteSpace}                { /*do nothing*/ }
    .                           { printToken("ERROR: " + yytext()); error(yytext(), yyline+1, yycolumn+1);
                                  error(yytext(), yyline+1, yycolumn+1); }
}

    <<EOF>>                     { return symbol(sym.EOF); } 


