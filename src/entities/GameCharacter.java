package entities;

import javax.swing.*;
import java.awt.*;

public class GameCharacter extends JLabel {
    private ImageIcon characterIcon;
    public GameCharacter() {
        characterIcon = new ImageIcon("images/roflik.png");
        this.setIcon(characterIcon);
        this.setPreferredSize(new Dimension(110,110));
        this.setLayout(null);
        this.setVisible(true);
    }

    public ImageIcon getCharacterIcon() {
        return characterIcon;
    }

    public void setCharacterIcon(ImageIcon characterIcon) {
        this.characterIcon = characterIcon;
    }
}
