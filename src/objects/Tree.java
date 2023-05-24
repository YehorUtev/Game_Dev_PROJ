package objects;

import javax.swing.*;
import java.awt.*;

public class Tree extends JLabel {
    private ImageIcon treeIcon = new ImageIcon("images/ChujTest.png");
    public Tree() {
        this.setPreferredSize(new Dimension(120,120));
        this.setLayout(null);
        this.setVisible(true);
        this.setIcon(treeIcon);
    }

    public ImageIcon getGrassIcon() {
        return treeIcon;
    }

    public void setGrassIcon(ImageIcon treeIcon) {
        this.treeIcon = treeIcon;
    }
}
