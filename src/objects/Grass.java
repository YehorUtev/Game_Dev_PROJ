package objects;

import javax.swing.*;
import java.awt.*;

public class Grass extends JLabel {
    private ImageIcon grassIcon = new ImageIcon("images/grass.png");
    public Grass() {
        this.setPreferredSize(new Dimension(120,120));
        this.setLayout(null);
        this.setVisible(true);
        this.setIcon(grassIcon);
    }

    public ImageIcon getGrassIcon() {
        return grassIcon;
    }

    public void setGrassIcon(ImageIcon grassIcon) {
        this.grassIcon = grassIcon;
    }
}
