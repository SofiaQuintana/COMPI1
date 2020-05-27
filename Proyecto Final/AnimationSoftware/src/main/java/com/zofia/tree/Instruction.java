/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.tree;

import com.zofia.logic.Environment;

/**
 *
 * @author zofia
 */
public interface Instruction {
    public int getLine();
    public int getColumn();
    public Object execute(Environment environment);
}
