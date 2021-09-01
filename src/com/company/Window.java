package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    JPanel boardPanel, optionsPanel;
    JButton restartButton;

    Board board = new Board(10);


    public Window() {

        setSize(450, 520);
        setTitle("Polish draughts");
//        setLocation(1200, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        boardPanel = new JPanel(new GridLayout(10, 10));
        boardPanel.setPreferredSize(new Dimension(420, 420));

        for(int i = 0; i< 10; i ++){
            for (int j = 0; j < 10; j++){
                boardPanel.add(board.checkerBoard[i][j]);
            }
        }

        add(boardPanel);
        optionsPanel = new JPanel();
        restartButton = new JButton("RESTART");
        restartButton.addActionListener(this);
        optionsPanel.add(restartButton);
        add(optionsPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == restartButton){

        }

    }
}
