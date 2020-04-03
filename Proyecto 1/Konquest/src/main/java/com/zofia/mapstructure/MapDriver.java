/*
 * Map driver es la clase encargada de generar un simple array que contiene 'Cartas planeta'
 * y cartas vacias que se muestran en el panel principal de nuestra interfaz,
 * es decir, nuestro panel de juego.
 */
package com.zofia.mapstructure;

import com.zofia.dummyclasses.Box;
import com.zofia.dummyclasses.Map;
import com.zofia.dummyclasses.Planet;
import com.zofia.dummyclasses.Player;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author zofia
 */
public class MapDriver {
    private int rows;
    private int columns;
    private int cardsQuantity;
    private int neutralPlanets;
    private List<Integer> cardIdentifiers;
    private List<Planet> planets;
    private List<Player> players;
    private List<String> names;
    private Random random;
    private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K','L'
            ,'M','N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int bound;
    private int production;

    //Constructor para mapas generados siguiendo lineamientos de archivo JSON.
    public MapDriver(Map map, List<Planet> planets, List<Player> players) {
        this.rows = map.getRows();
        this.columns = map.getColumns();
        this.cardIdentifiers = new ArrayList<>();
        setCardsQuantity(rows*columns);
        this.planets = planets;
        this.players = players;
        this.random = new Random();
        this.bound = cardsQuantity;
        setCardIdentifiers();
    }

    //Constructor para mapas generados al azar.
    public MapDriver(Map map, int production, List<Player> players) {
        this.rows = map.getRows();
        this.columns = map.getColumns();
        setCardsQuantity(rows*columns);
        this.neutralPlanets = map.getNeutralPlanets();
        this.random = new Random();
        this.bound = cardsQuantity;
        this.planets = new ArrayList<>();
        this.cardIdentifiers = new ArrayList<>();
        this.names = new ArrayList<>();
        this.players = players;
        this.production = production;
        setCardIdentifiers();
    }
    
    private void setCardIdentifiers() {
        for (int i = 0; i < cardsQuantity; i++) {
            cardIdentifiers.add(i);
        }
    }
    
    private void getAllPlanets() {
        for(Player player : players) {
            for (int i = 0; i < player.getStarterPlanets().size(); i++) {
                this.planets.add(player.getStarterPlanets().get(i));               
            }
        }
    }
    
    public List<Planet> CreatePlanetsForUIMap() {
        setNames();
        setSpaceships();
        setDeathRate();
        removeOwnedPlanets();
        return this.planets;
    }
    
    private void setNames() {
        int planetSize = (neutralPlanets+players.size()); //Cantidad total de planetas que se generaran.
        for (int i = 0; i < alphabet.length; i++) {
            names.add(String.valueOf(alphabet[i]));
        }
        if(planetSize >= names.size()) {
            String aux;
            int temp = planetSize - names.size();
            for (int j = 0; j < temp; j++) {
                aux = names.get(j) + j;
                names.add(aux);                    
            }
         } 
        for (int i = 0; i < planetSize; i++) {
            planets.add(new Planet(names.get(i), 0, 0, 0.0, false));           
        }
    }
    
    private void removeOwnedPlanets() {
        cleanPlayers();
        for (int i = 0; i < (players.size()); i++) {
            String owner = players.get(i).getName();
            planets.get(i).setOwner(owner);
            players.get(i).getStarterPlanets().add(planets.get(i));
            planets.remove(i);
        }
    }
    
    //Generar cantidad de naves al inicio, segun tipo de jugador.
    private void setSpaceships() {
        int spaceships;
        for (int i = 0; i < players.size(); i++) {
            spaceships = (int) ((Math.random() *15)+10);
            planets.get(i).setSpaceships(spaceships);
            planets.get(i).setProduction(production);
        }
        for (int i = players.size(); i < planets.size(); i++) {
            spaceships = (int) ((Math.random() * 6) + 1);
            planets.get(i).setSpaceships(spaceships);
            planets.get(i).setProduction(production);
        }
    }
    
    //Generar porcentaje de muertes entre 0 - 0.999999
    private void setDeathRate() {
        double deathRate;
        for (int i = 0; i < planets.size(); i++) {
            deathRate = (double) (Math.random() * 0.999999 + 0);
            planets.get(i).setDeathRate(deathRate);
        }
    }
    
    private void cleanPlayers() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).getStarterPlanets().clear();           
        }
    }
    
    //Generar si es neutral o planeta inicial de jugador.
    private void setStarterPlanets() {
        cleanPlayers();
        for (int i = 0; i < (players.size()); i++) {
            String owner = players.get(i).getName();
            planets.get(i).setOwner(owner);
            players.get(i).getStarterPlanets().add(planets.get(i));
        }
    }
    
    /** 
     * Se encarga de obtener una posicion al azar en donde sera generado
     * un planeta, ya sea neutral o inicial;
     * @return int
     */
    public int getRandomPosition() {
        int position;
        int number;
        position = random.nextInt(bound);
        number = cardIdentifiers.get(position);
        cardIdentifiers.remove(position);
        bound--;
        return number;
    }
    
    /**
     * Nos permite generar cartas vacias en nuestro array de cartas.
     * @return Card[]
    */
    public Box[] createCards() {
        Box[] cards = new Box[cardsQuantity];
        for (int i = 0; i < cardsQuantity; i++) {
            cards[i] = new Box(rows, columns, Color.WHITE, null);
        }
        return cards;
    }
    
    public Box[] createdMap() {
        Box[] cards = createCards();
        if(!planets.isEmpty()) {
            getAllPlanets();
            setPlanets(cards);
        } else {
            setNames();
            setSpaceships();
            setDeathRate();
            setStarterPlanets();
            setPlanets(cards);
        }
        return cards;
    }
    
    private void setPlanets(Box[] cards) {
        for (int i = 0; i < planets.size(); i++) {
            Box card = cards[getRandomPosition()];
            card.setPlanet(planets.get(i));
            card = setImage(card);
            if(!card.getPlanet().getOwner().equals("")) {
                for(Player player : players) {
                    if(player.getName().equals(card.getPlanet().getOwner())) {
                        card.setBackground(player.getColor());
                    }
                }
            }
        }
    }
    
    private Box setImage(Box card) {
        int aux = random.nextInt(9);
        if(aux == 0) {
            aux++;
        }
        card.setIcon(new ImageIcon(getClass().getResource("/" + aux + ".png")));
        return card;
    }
    
    public void setCardsQuantity(int cardsQuantity) {
        this.cardsQuantity = cardsQuantity;
    }

    public List<Player> getPlayers() {
        return players;
    }
   
}
