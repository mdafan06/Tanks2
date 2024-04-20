package Tanks;

import org.checkerframework.checker.units.qual.A;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.*;

public class App extends PApplet {

    public static final int CELLSIZE = 32; //8;
    public static final int CELLHEIGHT = 32;

    public static final int CELLAVG = 32;
    public static final int TOPBAR = 0;
    public static int WIDTH = 864; //CELLSIZE*BOARD_WIDTH;
    public static int HEIGHT = 640; //BOARD_HEIGHT*CELLSIZE+TOPBAR;
    public static final int BOARD_WIDTH = WIDTH/CELLSIZE;
    public static final int BOARD_HEIGHT = 20;

    public static final int INITIAL_PARACHUTES = 1;

    public static final int FPS = 30;

    public String configPath;

    public static Random random = new Random();

    private JSONObject config;

    private Terrain terrain;
	
	// Feel free to add any additional methods or attributes you want. Please put classes in different files.

    public App() {
        this.configPath = "config.json";
    }

    /**
     * Initialise the setting of the window size.
     */
	@Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player and map elements.
     */
	@Override
    public void setup() {
        frameRate(FPS);
		//See PApplet javadoc:
		//loadJSONObject(configPath)
		//loadImage(this.getClass().getResource(filename).getPath().toLowerCase(Locale.ROOT).replace("%20", " "));
        config = loadJSONObject(configPath);

        // First level
        JSONObject firstlevel = config.getJSONArray("levels").getJSONObject(0);
        String levelFile = firstlevel.getString("layout");
        String backgroundImagePath = firstlevel.getString("background");
        System.out.println(backgroundImagePath);
        int foregroundColor = parseColor(firstlevel.getString("foreground-colour"));
        

        println("level file: " + levelFile);
        println("Background image: " + backgroundImagePath);
        println("Foreground: " + foregroundColor);

        terrain = new Terrain(this, levelFile, backgroundImagePath, foregroundColor);
    }

    /**
     * Receive key pressed signal from the keyboard.
     */
	@Override
    public void keyPressed(KeyEvent event){
        
    }

    /**
     * Receive key released signal from the keyboard.
     */
	@Override
    public void keyReleased(){
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //TODO - powerups, like repair and extra fuel and teleport


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Draw all elements in the game by current frame.
     */
	@Override
    public void draw() {
        

        //----------------------------------
        //display HUD:
        //----------------------------------
        //TODO

        //----------------------------------
        //display scoreboard:
        //----------------------------------
        //TODO
        
		//----------------------------------
        //----------------------------------

        //TODO: Check user action
        background(255);

        terrain.render(this);
    }

    private int parseColor(String colorString) {
        //System.out.println("\n");
        //System.out.println(colorString);
        String[] rgb = colorString.split(",");
        System.out.println(Arrays.toString(rgb));
        if (rgb.length == 3) {
            int r = Integer.parseInt(rgb[0].trim());
            //System.out.println(r);
            int g = Integer.parseInt(rgb[1].trim());
            //System.out.println(g);
            int b = Integer.parseInt(rgb[2].trim());
            //System.out.println(b);

            //return color(r,g,b);
            int result = color(r,g,b);
            System.out.println("Result: " + result);
            return result;
            
        } else {
            return color(255,255,255);
        }
    }


    public static void main(String[] args) {
        PApplet.main("Tanks.App");
    }

}
