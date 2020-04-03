/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zofia.mapstructure;

import com.zofia.dummyclasses.Map;
import com.zofia.dummyclasses.Neutral;
import com.zofia.dummyclasses.Planet;
import com.zofia.dummyclasses.Player;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author zofia
 */
public class FileDriver {
    private FileReader reader;
    private FileWriter writer;
    private PrintWriter printer;
    private BufferedReader buffer;
    private String line;
    private String fileContent = "";
    private static final String JSON_EXTENSION = ".json";
    private static final String SAVE_EXTENSION = ".save";
    
    public String readInputFile(String path) throws FileNotFoundException, IOException{
        reader = new FileReader(new File(path));
        buffer = new BufferedReader(reader);
        while((this.line = buffer.readLine()) != null) {
            this.fileContent += (line + "\n");
        }   
        return fileContent;
    }
    
    public void cleanFileContent() {
        this.fileContent = "";
    }
    
    public void writeSaveFile(String path, Map map, Neutral neutral, List<Planet> planets, List<Player> players) throws IOException {
        this.writer = new FileWriter(new File(path + "/" + map.getId() + SAVE_EXTENSION));
        this.printer = new PrintWriter(writer);
        printer.print("<JUEGO> \n");
        printer.printf("<MAPA id= %s alAzar= %b planetasNeutrales= %d mapaCiego= %b acumular= %b finalizacion= %d> %n", 
                map.getId(), map.isRandomMap(), map.getNeutralPlanets(), map.isBlindMap(), map.isAccumulate(), map.getEnding());
        printer.printf("<SIZE filas= %d columnas= %d /> %n", map.getRows(), map.getColumns());
        printer.printf("<NEUTRALES mostrarNaves= %b mostrarEstadisticas= %b produccion= %d/> %n", 
                neutral.isShowSpaceships(), neutral.isShowstadistics(), neutral.getProduction());
        printer.print("</MAPA> \n <PLANETAS> \n");
        for (int i = 0; i < players.size(); i++) {
            List<Planet> temp = players.get(i).getStarterPlanets();
            for (int j = 0; j < temp.size(); j++) {
                Planet planet = temp.get(j);
                printer.printf("<CONQUISTADO nombre= %s naves= %d produccion= %d porcentajeMuertes= %f propietario= %s/>%n", 
                        planet.getName(), planet.getSpaceships(), planet.getProduction(), planet.getDeathRate(), planet.getOwner());
            }
        }
        for (int i = 0; i < planets.size(); i++) {
            Planet planet = planets.get(i);
            if(planet.getOwner().equals(""))
                printer.printf("<NEUTRAL nombre= %s naves= %d produccion= %d porcentajeMuertes= %f />%n", 
                    planet.getName(), planet.getSpaceships(), planet.getProduction(), planet.getDeathRate());
        }
        printer.print("</PLANETAS> \n <JUGADORES> \n");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            printer.printf("<JUGADOR nombre= %s color= %s tipo= %s/>%n", player.getName(), getColor(player), player.getType());
        }
        printer.print("</JUEGO>");
        printer.close();
    }
    
    private String getColor(Player player) {
        String text = null;
        if(player.getColor() == Color.CYAN) {
            text = "CYAN";
        } else if(player.getColor() == Color.ORANGE) {
            text = "ORANGE";
        } else if(player.getColor() == Color.GREEN) {
            text = "GREEN";
        } else if(player.getColor() == Color.GRAY) {
            text = "GRAY";
        } else if(player.getColor() == Color.MAGENTA) {
            text = "MAGENTA";
        } else if(player.getColor() == Color.PINK) {
            text = "PINK";          
        } else if(player.getColor() == Color.YELLOW) {
            text = "YELLOW";
        }
        return text;
    }
    
    
    public void writeMapFile(String path, Map map, Neutral neutral, List<Planet> planets, List<Player> players) throws IOException {
        this.writer = new FileWriter(new File(path + "/" + map.getId()+ JSON_EXTENSION));
        this.printer = new PrintWriter(writer);
        printer.printf("{  %n MAPA: {  %n id: \"%s\",  %n tamaño: {  %n filas: %d,  %n columnas: %d  %n },", map.getId(), map.getRows(), map.getColumns());
        printer.printf("%n alAzar: %b, %n planetasNeutrales: %d, %n mapaCiego: %b, %n acumular: %b,", map.isRandomMap(), map.getNeutralPlanets(), map.isBlindMap(), map.isAccumulate());
        printer.printf("%n NEUTRALES: { %n mostrarNaves: %b, %n mostrarEstadisticas: %b, %n produccion: %d %n},", neutral.isShowSpaceships(), neutral.isShowstadistics(), neutral.getProduction());
        printer.printf("%n finalizacion: %d %n }, %n PLANETAS: [ %n", map.getEnding());
        for (int i = 0; i < players.size(); i++) {
            List<Planet> temp = players.get(i).getStarterPlanets();
            List<Planet> comparator = players.get(players.size()-1).getStarterPlanets();
            for (int j = 0; j < temp.size(); j++) {
                Planet planet = temp.get(j);
                if(planet != comparator.get(comparator.size()-1))
                    printer.printf("{ %n nombre: \"%s\", %n naves: %d, %n produccion: %d, %n porcentajeMuertes: %f %n },%n", planet.getName(), planet.getSpaceships(), planet.getProduction(), planet.getDeathRate());
                else 
                    printer.printf("{ %n nombre: \"%s\", %n naves: %d, %n produccion: %d, %n porcentajeMuertes: %f %n }%n", planet.getName(), planet.getSpaceships(), planet.getProduction(), planet.getDeathRate());              
            }
        }
        
        printer.print("], \n PLANETAS_NEUTRALES: [ \n");
        for (int i = 0; i < planets.size(); i++) {
            Planet planet = planets.get(i);
            if(planet.getOwner().equals("")) {
                if(planet != planets.get((planets.size()-1)))
                    printer.printf("{ %n nombre: \"%s\", %n naves: %d, %n produccion: %d, %n porcentajeMuertes: %f %n },%n", planet.getName(), planet.getSpaceships(), planet.getProduction(), planet.getDeathRate());
                else 
                    printer.printf("{ %n nombre: \"%s\", %n naves: %d, %n produccion: %d, %n porcentajeMuertes: %f %n }%n", planet.getName(), planet.getSpaceships(), planet.getProduction(), planet.getDeathRate());
            }
        }
        printer.print("], \n JUGADORES: [ \n");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if(player != players.get(players.size()-1)) {
                printer.printf("%n { nombre: \"%s\", %n planetas: [ %n", player.getName());
                List<Planet> temp = player.getStarterPlanets();
                for (int j = 0; j < temp.size(); j++) {
                    Planet planet = temp.get(j);
                    if(planet != temp.get(temp.size()-1)) {
                        printer.printf("\"%s\",", planet.getName());
                    } else {
                        printer.printf("\"%s\" %n],", planet.getName());
                    }
                }
                printer.printf("%n tipo: %s %n },", player.getType());
            } else {
                printer.printf("%n { nombre: \"%s\", %n planetas: [ %n", player.getName());
                List<Planet> temp = player.getStarterPlanets();
                for (int j = 0; j < temp.size(); j++) {
                    Planet planet = temp.get(j);
                    if(planet != temp.get(temp.size()-1)) {
                        printer.printf("\"%s\",", planet.getName());
                    } else {
                        printer.printf("\"%s\" %n],", planet.getName());
                    }
                }
                printer.printf("%n tipo: %s %n } %n ] %n }", player.getType());
            }
        }
        printer.close();
    }
}
