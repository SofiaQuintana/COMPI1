/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.frontend;

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
    
    public void appendError(Color color, String message, int turn, JTextPane area) {
        appendTurn(turn, area);
        append(color, "~ " + message + "\n", area);
    }
    
    public void appendTurn(int turn, JTextPane area) {
        append(Color.WHITE, "Turno " + turn + ":\n", area);
    }
    
    public void appendHeldAttack(Color color, String planetName, String playerName, int turn, JTextPane area) {
        appendTurn(turn, area);
        append(Color.LIGHT_GRAY, "~ Planet ", area);
        append(Color.PINK, planetName, area);
        append(Color.LIGHT_GRAY, " has held against an attack from ", area);
        append(color, playerName + ".\n", area);
    }
    
    public void appendConqueredPlanet(Color color, String planetName, String playerName, int turn, JTextPane area) {
        appendTurn(turn, area);
        append(Color.LIGHT_GRAY, "~ Planet ", area);
        append(Color.PINK, planetName, area);
        append(Color.LIGHT_GRAY, " has fallen to ", area);
        append(color, playerName + ".\n", area);
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
