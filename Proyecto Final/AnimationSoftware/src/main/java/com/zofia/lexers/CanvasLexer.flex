package com.zofia.lexers;
import java_cup.runtime.*;
import com.zofia.parsers.canvas.sym;
import com.zofia.drivers.CanvasDriver;
import com.zofia.logic.Error;

%%//Area Break

%public
%class CanvasLexer
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
Identifier = ({Letter} | "_")({Letter} | {Number} | "_")*
Name = "\"" [^*] ~"\""
Int = ({Number})({Number})*
HexCode = ("#")({HexNumber})({HexNumber})({HexNumber})({HexNumber})({HexNumber})({HexNumber})

%{
    private CanvasDriver driver;

    public CanvasLexer(java.io.Reader in, CanvasDriver driver) {
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
    "LIENZOS"                     { printToken("LIENZOS"); return symbol(sym.LIENZOS, "LIENZOS"); }
    "nombre"                      { printToken("nombre"); return symbol(sym.NOMBRE, "nombre"); }
    "tipo"                        { printToken("tipo"); return symbol(sym.TIPO, "tipo");}
    "Fondo"                       { printToken("FONDO"); return symbol(sym.FONDO, "Fondo");}
    "Red"                         { printToken("Red"); return symbol(sym.RED, "Red");}
    "Blue"                        { printToken("Blue"); return symbol(sym.BLUE, "Blue");}
    "Green"                       { printToken("Green"); return symbol(sym.GREEN, "Green");}
    "tamaño"                      { printToken("tamaño"); return symbol(sym.SIZE, "tamaño");}
    "cuadro"                      { printToken("cuadro"); return symbol(sym.CUADRO, "cuadro");}
    "dimension_x"                 { printToken("dimension_x"); return symbol(sym.DIMENSIONX, "dimension_x");}
    "dimension_y"                 { printToken("dimension_y"); return symbol(sym.DIMENSIONY, "dimension_y");}
    "HEX"                         { printToken("HEX"); return symbol(sym.HEX, "HEX");}
    "\"png"\"                     { printToken("png"); return symbol(sym.PNG, "\"png\"");}
    "\"gif"\"                     { printToken("gif"); return symbol(sym.GIF, "\"gif\"");}
    /* Signs */
    "{"                         { printToken("{"); return symbol(sym.CURLYBRACKETO, "{");}
    "}"                         { printToken("}"); return symbol(sym.CURLYBRACKETC, "}");}
    ":"                         { printToken(":"); return symbol(sym.COLON, ":");}
    ","                         { printToken(","); return symbol(sym.COMMA, ",");}
    /* Others */
    {Name}                      { printToken("Name: " + yytext()); return symbol(sym.NAME, yytext());}
    {Identifier}                { printToken("Id: " + yytext()); return symbol(sym.ID, yytext());}
    {Int}                       { printToken(yytext()); return symbol(sym.INT,  Integer.parseInt(yytext()));}
    {HexCode}                   { printToken(yytext()); return symbol(sym.HEXCODE, yytext());}
    {WhiteSpace}                { /*do nothing*/ }
    .                           { printToken("ERROR: " + yytext()); error(yytext(), yyline+1, yycolumn+1); 
                                  error(yytext(), yyline+1, yycolumn+1); }
}

    <<EOF>>                     { return symbol(sym.EOF); } 

