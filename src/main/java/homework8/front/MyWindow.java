package homework8.front;

import homework8.servise.Algorithm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static homework8.servise.Algorithm.setCheckClick;

public class MyWindow extends JFrame{
    public static JButton [][] jButtonsFirstPanel;
    public static JLabel labelWindow = new JLabel("");
    public static int coordinateTurn = - 11;

    public MyWindow() {
        setTitle(" Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 200, Algorithm.getSizeMap() * 100, Algorithm.getSizeMap() * 100);

        JPanel firstPanel = new JPanel();
        firstPanel.setBounds(0,0,Algorithm.getSizeMap() * 100,Algorithm.getSizeMap() * 100);

        jButtonsFirstPanel = new JButton[Algorithm.getSizeMap()][Algorithm.getSizeMap()];
        GridLayout layout = new GridLayout(0, Algorithm.getSizeMap());
        layout.setHgap(10);
        layout.setVgap(10);
        firstPanel.setLayout(layout);
        for (int i = 0; i < jButtonsFirstPanel.length; i++) {
            for (int j = 0; j < jButtonsFirstPanel[i].length; j++) {
                jButtonsFirstPanel[i][j] = new JButton();
               firstPanel.add(jButtonsFirstPanel[i][j]);
            }
        }
        add(labelWindow);
        add(firstPanel);

        for (int i = 0; i < Algorithm.getSizeMap(); i++) {
            for (int j = 0; j < Algorithm.getSizeMap(); j++) {
                final int tmp = 10 * i + j;
                jButtonsFirstPanel[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println("Button pressed..." + tmp/10 + " " + tmp%10);
                        coordinateTurn = tmp;

                        setCheckClick(true);
                    }
                });
            }
        }
        setVisible(true);
    }

    public static void newLabel(String x){
        JFrame frame = new JFrame();
        JPanel secondPanel = new JPanel();
        frame.setBounds(500, 200, Algorithm.getSizeMap() * 100, Algorithm.getSizeMap() * 100);
        secondPanel.setBounds(0,0,Algorithm.getSizeMap() * 100,Algorithm.getSizeMap() * 100);

        labelWindow.setVerticalAlignment(JLabel.CENTER);
        labelWindow.setHorizontalAlignment(JLabel.CENTER);
        labelWindow.setForeground(Color.BLACK);
        labelWindow.setText(x);
        frame.add(secondPanel);
        secondPanel.add(labelWindow);
        frame.setVisible(true);
    }

}