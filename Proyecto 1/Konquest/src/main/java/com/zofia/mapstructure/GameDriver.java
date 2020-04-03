package com.zofia.mapstructure;

import com.zofia.dummyclasses.Box;
import com.zofia.dummyclasses.Planet;
import com.zofia.dummyclasses.Player;
import com.zofia.dummyclasses.Attack;
import com.zofia.frontend.MessageStructure;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;

/**
 *
 * @author zofia
 */
public class GameDriver {
    private List<Player> players;
    private Box[] grid;
    private int turnCounter;
    private int turnDriver;
    private Box origin;
    private Box destination;
    private List<Attack> attacks;
    private int planets;
    private Point[][] points;
    
    public GameDriver(List<Player> players, Box[] grid, int rows, int columns) {
        this.players = players;
        this.grid = grid;
        this.turnCounter = 0;
        this.turnDriver = 0;
        this.attacks = new ArrayList<>();
        this.planets = setPlanetQuantity();
        fillPoints(rows, columns);
    }
    
    /** 
     * Obtiene los datos del jugador al que le corresponde el turno, mediante un controlador, 
     * en caso de que dicho entero sobrepase la cantidad de jugadores, se reinicia para comenzar
     * una nueva ronda de turnos entre cada uno de los jugadores.
     * @param stadistics
     * @param ships
     * @param blindMap
     * @return Player
     */
    public Player getPlayerInTurn(boolean stadistics, boolean ships, boolean blindMap) {
        Player player;
        player = players.get(turnDriver);
        turnDriver++;    
        turnCounter++;
        return player;
    }
    
    private int setPlanetQuantity() {
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            if(box.getPlanet() != null) {
                this.planets++;
            }
        }
        return planets;
    }
    
    public boolean endGame(int ending) {
        if(ending == 0) {
            for(Player player : players) {
                if(player.getStarterPlanets().size() == planets) {
                    return true;
                }
            }
            return false;
        } else {
            if(turnCounter == ending) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void registerRound(boolean stadistics, boolean ships, boolean accumulative, boolean blindMap, String player) {
        if(turnDriver > (players.size()-1)) {
            this.turnDriver = 0;
            addProduction(stadistics, ships, blindMap, player, accumulative);
            //aqui se debe hacer la suma de producciones
        } 
    } 
    
    private void addProduction(boolean stadistics, boolean ships, boolean blindMap, String player, boolean accumulative) {
        int production;
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            if(box.getPlanet() != null) {
                if(accumulative) {
                    box.getPlanet().setProduction(box.getPlanet().getProduction()+1);
                }
                production = box.getPlanet().getSpaceships() + box.getPlanet().getProduction();
                box.getPlanet().setSpaceships(production);
                box.setToolTipText(box.toString(stadistics, ships, blindMap, player));
            }
        }
    }
    
    private void fillPoints(int rows, int columns) {
        points = new Point[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Point point = new Point(i+1, j+1);
                points[i][j] = point;
            }
        }
    }
    
    public Point getCoordinates(int position, int rows, int columns) {
        Point coordinate = null;
        int aux = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                aux++;
                if(aux == position) {
                    coordinate = points[i][j];
                }
            }
        }
        return coordinate;
    }
    
    /**Calcula la distancia a traves de los puntos coordinados x,y de ambos planetas, 
     * siguiendo la base de la formula matematica de distancia entre dos puntos. 
     * @param rows
     * @param columns
     * @return int
    **/
    public int distanceBetweenPlanets(int rows, int columns) {
        Point first = null, second = null;
        int distance = 0;
        for (int i = 0; i < grid.length; i++) {
            if(grid[i] == origin) {
                first = getCoordinates(i, rows, columns);
            } else if(grid[i] == destination) {
                second = getCoordinates(i, rows, columns);
            }
        }
        distance = (int) ((second.getX()-first.getX())*(second.getX()-first.getX()));
        distance += (int) ((second.getY()-first.getY())*(second.getY()-first.getY()));
        if(distance < 1) {
            distance = distance * -1;
        }
        distance = (int) Math.sqrt(distance);
        System.out.println("Distance:" + distance);
        return distance;
    }
    
    public void verifySpaceshipInput(int spaceships) throws Exception {
        if(origin.getPlanet().getSpaceships() < spaceships) {
            throw new Exception("Ingrese una cantidad que se encuentre disponible en su planeta origen.");
        }
    }
    
    public void conqueringManagement(MessageStructure structure, JTextPane area) {
        boolean conquered;
        for (int i = 0; i < attacks.size(); i++) {
            Attack turn = attacks.get(i);
            turn.setDistance(turn.getDistance()-1);
            if(turn.getDistance() == 0) { 
                //Validacion de envio de ataque o refuerzos.
                if(turn.getOrigin().getOwner().equals(turn.getDestination().getOwner())) { //Refuerzo
                    reinforcement(turn);
                } else { //Ataque
                    int remainder = calculateKilledSpaceships(turn.getOrigin(), turn.getDestination(), turn.getSpaceships());
                    conquered = conqueredPlanet(remainder);
                    if(conquered) { //Conquistado
                        setConqueredPlanet(turn.getOrigin(), turn.getDestination(), remainder, structure, area);
                    } else { //Held
                        heldAttack(remainder, turn.getOrigin(), turn.getDestination(), structure, area);
                    }
                }
            }
        }
    }
    
    private Box[] heldAttack(int remainder, Planet origin, Planet destination, MessageStructure structure, JTextPane area) {
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            if(box.getPlanet() == destination) {
                box.getPlanet().setSpaceships(remainder);
                message(origin, destination, structure, area);
                return grid;
            }
        }
        return grid;
    }
    
    private void message(Planet origin, Planet destination, MessageStructure structure, JTextPane area) {
        for(Player player : players) {
            if(player.getName().equals(origin.getOwner())) {
                structure.appendHeldAttack(player.getColor(), destination.getName(), player.getName(), this.turnCounter, area);
            }
        }
    }
    
    private Box[] reinforcement(Attack turn) {
        for (int i = 0; i < grid.length; i++) {
            Box card = grid[i];
            if(card.getPlanet() == turn.getDestination()) {
                card.getPlanet().setSpaceships(card.getPlanet().getSpaceships() + turn.getDistance());
                attacks.remove(turn);
                return grid;
            }
        }
        return grid;
    }
    
    private Box[] setConqueredPlanet(Planet origin, Planet destination, int remainder, MessageStructure structure, JTextPane area) {
        for (int j = 0; j < players.size(); j++) {
            Player player = players.get(j);
            if(player.getName().equals(origin.getOwner())) {
                return changeCardBackground(remainder, destination, player, structure, area);
            }
        }
        return grid;
    }
    
    private Box[] changeCardBackground(int remainder, Planet destination, Player player, MessageStructure structure, JTextPane area) {
        for (int k = 0; k < grid.length; k++) {
            Box card = grid[k];
            if(card.getPlanet() == destination) {
                card.getPlanet().setOwner(player.getName());
                card.getPlanet().setSpaceships(remainder*-1);
                player.getStarterPlanets().add(card.getPlanet());
                card.setBackground(player.getColor());
                structure.appendConqueredPlanet(player.getColor(), destination.getName(), player.getName(), this.turnCounter, area);
            }
        }
        return grid;
    }
    
    private int calculateKilledSpaceships(Planet origin, Planet destination, int sent) {
        int killedShips, firstPlanet, secondPlanet;
        firstPlanet = (int) (sent - (sent*destination.getDeathRate()));
        secondPlanet = (int) (destination.getSpaceships() - (destination.getSpaceships()*origin.getDeathRate()));
        //Si es < 0 se conquisto, en caso contrario el planeta destino retuvo el ataque.
        killedShips = secondPlanet - firstPlanet;
        return killedShips;
    }
    
    private boolean conqueredPlanet(int spaceships) {
        return spaceships < 0;
    }
    
    public void turnDriver(int spaceships, boolean stadistics, boolean ships, boolean blindMap, String player, int rows, int columns) {
        attacks.add(addTurn(spaceships, distanceBetweenPlanets(rows,columns),stadistics, ships, blindMap, player));
    }

    public Attack addTurn(int spaceships, int distance, boolean stadistics, boolean ships, boolean blindMap, String player) {
        int aux = origin.getPlanet().getSpaceships() - spaceships;
        origin.getPlanet().setSpaceships(aux);
        for (int i = 0; i < grid.length; i++) {
            Box box = grid[i];
            if(box == origin) {
                box.getPlanet().setSpaceships(aux);
                box.setToolTipText(box.toString(stadistics, ships, blindMap, player));
            }
        }
        Attack turn = new Attack(origin.getPlanet(), destination.getPlanet(), spaceships, distance+1);
        return turn;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public Box getOrigin() {
        return origin;
    }

    public void setOrigin(Box origin) {
        this.origin = origin;
    }

    public Box getDestination() {
        return destination;
    }

    public void setDestination(Box destination) {
        this.destination = destination;
    }

    public void setGrid(Box[] grid) {
        this.grid = grid;
    }
    
}
