package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingWindow extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton startButton;
    private JButton exitButton;

    public StartingWindow() {
        // overall initializing
        startButton = new JButton();
        exitButton = new JButton();

        // initializing main frame
        this.setUndecorated(true);
        this.setVisible(true);
        this.setSize(new Dimension(1920, 1080));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel with GridBagLayout
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraintsForStart = new GridBagConstraints();
        GridBagConstraints constraintsForExit = new GridBagConstraints();

        // initializing start button
        startButton.setPreferredSize(new Dimension(500, 200));
        startButton.setText("START");
        startButton.setFocusable(false);

        // initializing exit button
        exitButton.setPreferredSize(new Dimension(500, 200));
        exitButton.setText("EXIT");
        exitButton.setFocusable(false);

        // action listener
        startButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add the start button to the panel with alignment
        constraintsForStart.gridx = 0;
        constraintsForStart.gridy = 0;
        constraintsForStart.insets = new Insets(-300, 0, 0, 0);
        panel.add(startButton, constraintsForStart);

        // Add the exit button to the panel with alignment
        constraintsForExit.gridx = 0;
        constraintsForExit.gridy = 0;
        constraintsForExit.insets = new Insets(0, 0, -300, 0);
        panel.add(exitButton,constraintsForExit);

        // Add the panel to the frame
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            //1
            /*this.remove(panel);
            this.repaint();*/
            //2
            this.dispose();
            GameFrame game = new GameFrame();
        } else if (e.getSource() == exitButton) {
            this.dispose();
        }
    }
}
