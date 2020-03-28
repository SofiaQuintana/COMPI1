/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.drivers;

import com.zofia.lexers.Node;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author zofia
 */
public class TreeDriver {
    private List<Node> nodes;
    private DefaultMutableTreeNode root;

    public TreeDriver(List<Node> nodes) {
        this.nodes = new ArrayList<>();
        this.nodes = nodes;
    }
    
    public void createTree(DefaultTreeModel treeModel) {
        //Recibo ultimo index de lista como el padre
        for (int i = (nodes.size()-1); i < nodes.size(); i--) {
            Node temporal = nodes.get(i);
            if(temporal.getType().equals("CARPETA")) {
                nodes.remove(temporal);
                root.add(createFolder(temporal, i));
            } else if(temporal.getType().equals("ARCHIVO")) {
                root.add(createFile(temporal));
                System.out.println("Archivo " + temporal);
                nodes.remove(temporal);
            }
        }
    }
    
    public DefaultMutableTreeNode createFolder(Node node, int position) {
        DefaultMutableTreeNode folder = new DefaultMutableTreeNode(node);
        for (int i = position-1; i > -1; i--) {
            if(!nodes.isEmpty()) {
                Node temporal = nodes.get(i);
                if(temporal.getType().equals("CARPETA")) {
                    folder.add(createFolder(temporal, i));
                    nodes.remove(temporal);
                } else if(i == nodes.size()) {
                    folder.add(createEmptyFolder(temporal));
                } else if(nodes.isEmpty()) {
                    break;
                } else if(temporal.getType().equals("ARCHIVO")){ 
                    System.out.println("Archivo carpeta " + temporal);
                    folder.add(createFile(temporal));
                    nodes.remove(temporal);
                }
            }
        }
        return folder;
    }
    
    public DefaultMutableTreeNode createEmptyFolder(Node node) {
        DefaultMutableTreeNode folder = new DefaultMutableTreeNode(node);
        folder.setAllowsChildren(true);
        return folder;
    }
    
    public DefaultMutableTreeNode createFile(Node node) {
        DefaultMutableTreeNode file = new DefaultMutableTreeNode(node);
        file.setAllowsChildren(false);
        return file;
    }
    
    public DefaultMutableTreeNode getRoot() {
        Node auxiliar = nodes.get(this.nodes.size()-1); //Padre
        root = new DefaultMutableTreeNode(auxiliar);
        this.nodes.remove(auxiliar);
        return this.root;
    }    
    
}
