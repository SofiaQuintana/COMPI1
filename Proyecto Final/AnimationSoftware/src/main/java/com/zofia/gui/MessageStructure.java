/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.gui;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author zofia
 */
public class MessageStructure {
    
    public void appendString(Color color, String string, JTextPane area) {
        append(color, string, area);
    }
    
    public void appendError(Color color, String type, String message, int line, int column, JTextPane area) {
        String msg = type + " ~> " + message + " Error en linea: " + line + " y columna: " + column;
        append(color, msg + "\n", area);
    }

    private void append(Color color, String string, JTextPane area) {
        StyleContext context = StyleContext.getDefaultStyleContext();
        AttributeSet attribute = context.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        
        int length = area.getText().length();
        area.setCaretPosition(length);
        area.setCharacterAttributes(attribute, false);
        area.replaceSelection(string);
    }
}
