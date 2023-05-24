package game;

import entities.GameCharacter;
import objects.Grass;
import objects.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    private Tree tree;
    private int gameCharacterRow;
    private int gameCharacterColumn;
    private boolean isAdded;
    private GameCharacter gameCharacter;
    private final int rows = 9;
    private final int columns = 16;
    private JLabel gameLabel;
    private Grass grass;
    private JPanel game;
    private JLabel[][] gameTable;

    public GameFrame() {
        // Initializing
        gameTable = new JLabel[rows][columns];
        game = new JPanel();
        gameLabel = new JLabel();
        isAdded = false;

        // Initializing game panel
        game.setBounds(0, 0, 1920, 1080);
        game.setLayout(new GridLayout(rows, columns, 0, 0));

        // Initializing gameLabel
        gameLabel.setVisible(true);
        gameLabel.setPreferredSize(new Dimension(1920, 1080));

        // Initializing main frame
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize(new Dimension(1920, 1080));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Generating map
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grass = new Grass();
                tree = new Tree();
                double randomNumber = Math.random();
                if(randomNumber < 0.15){
                    gameTable[i][j] = tree;
                    game.add(tree);
                }else{
                    grass.setLayout(new FlowLayout());
                if (i == 5 && j == 8) {
                    gameCharacterRow = i;
                    gameCharacterColumn = j;
                    isAdded = true;
                }
                if (isAdded) {
                    // Initializing game character
                    gameCharacter = new GameCharacter();
                    grass.add(gameCharacter);
                    isAdded = false;
                }
                gameTable[i][j] = grass;
                game.add(grass);
            }
            }
        }

        // Adding components
        gameLabel.add(game);
        this.addKeyListener(this);
        this.add(gameLabel);
    }

    // Main character movement
    public void moveCharacter(KeyEvent e) {
        int startingPoint = 0;
        int newCharacterRow = gameCharacterRow;
        int newCharacterColumn = gameCharacterColumn;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                newCharacterRow--;
                break;
            case KeyEvent.VK_S:
                newCharacterRow++;
                break;
            case KeyEvent.VK_A:
                newCharacterColumn--;
                break;
            case KeyEvent.VK_D:
                newCharacterColumn++;
                break;
        }

        // Check if new position is within bounds
        if (newCharacterRow >= 0 && newCharacterRow < rows && newCharacterColumn >= 0 && newCharacterColumn < columns) {
            JLabel curLabel = gameTable[gameCharacterRow][gameCharacterColumn];
            JLabel newLabel = gameTable[newCharacterRow][newCharacterColumn];

            if (newLabel instanceof Grass) {
                Grass newGrass = (Grass) newLabel;
                curLabel.remove(gameCharacter);
                curLabel.repaint();
                curLabel.revalidate();
                newGrass.add(gameCharacter);
                newGrass.repaint();
                newGrass.revalidate();
            }

            gameCharacterRow = newCharacterRow;
            gameCharacterColumn = newCharacterColumn;
        }
        if(newCharacterRow < 0){
            regenerateBoard(startingPoint);
        }
        if(newCharacterRow >= rows){
            startingPoint = 1;
            regenerateBoard(startingPoint);
        }
        if(newCharacterColumn < 0){
            startingPoint = 2;
            regenerateBoard(startingPoint);
        }
        if(newCharacterColumn >= columns){
            startingPoint = 3;
            regenerateBoard(startingPoint);
        }
    }

    // Regenerate the board and reset character position
    private void regenerateBoard(int startingPoint) {
        int gameCharacterStartRow = 0;
        int gameCharacterStartColumn = 0;
        game.removeAll();
        switch (startingPoint){
            case (0):
                gameCharacterStartRow = rows - 1;
                gameCharacterStartColumn = gameCharacterColumn;
                break;
            case (1):
                gameCharacterStartColumn = gameCharacterColumn;
                break;
            case (2):
                gameCharacterStartRow = gameCharacterRow;
                gameCharacterStartColumn = columns - 1;
                break;
            case (3):
                gameCharacterStartRow = gameCharacterRow;
                gameCharacterStartColumn = 0;
                break;
        }

        // Update the character's position
        gameCharacterRow = gameCharacterStartRow;
        gameCharacterColumn = gameCharacterStartColumn;

        // Regenerate the map
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grass = new Grass();
                tree = new Tree();
                double randomNumber = Math.random();
                if(randomNumber < 0.15){
                    gameTable[i][j] = tree;
                    game.add(tree);
                }else {
                    grass.setLayout(new FlowLayout());
                    if (i == gameCharacterStartRow && j == gameCharacterStartColumn) {
                        isAdded = true;
                    }
                    if (isAdded) {
                        // Initializing game character
                        gameCharacter = new GameCharacter();
                        grass.add(gameCharacter);
                        isAdded = false;
                    }
                    gameTable[i][j] = grass;
                    game.add(grass);
                }
            }
        }

        // Repaint and revalidate the game panel
        game.repaint();
        game.revalidate();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        moveCharacter(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
