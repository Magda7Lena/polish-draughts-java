package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Board extends JPanel implements ActionListener {
    int size;
    JPanel[][] checkerBoard;
    private ArrayList<Pawn> allPawns = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        generateBoard();
    }

    private void generateBoard() {
        checkerBoard = new JPanel[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                checkerBoard[x][y] = new JPanel();

                if (x == 0 && y % 2 == 1 || x == 1 && y % 2 == 0) {
                    Pawn whitePawn = new Pawn(x, y, true);
                    checkerBoard[x][y].add(whitePawn);
                    allPawns.add(whitePawn);
                    whitePawn.setBackground(Color.yellow);
                    whitePawn.addActionListener(this);
                } else if (x == 8 && y % 2 == 1 || x == 9 && y % 2 == 0) {
                    Pawn blackPawn = new Pawn(x, y, false);
                    checkerBoard[x][y].add(blackPawn);
                    allPawns.add(blackPawn);
                    blackPawn.setBackground(Color.green);
                    blackPawn.addActionListener(this);
                }
            }
        }
        setCheckerColors();
    }

    private void setCheckerColors() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    checkerBoard[i][j].setBackground(Color.WHITE);
                } else if (i % 2 == 1 && j % 2 == 0 || i % 2 == 0 && j % 2 == 1) {
                    checkerBoard[i][j].setBackground(Color.BLACK);
                }
            }
        }

    }


    private void handleClickedPawn(Pawn clickedPawn) {
        clickedPawn.setHighlight();
        if (clickedPawn.isHighlight()) {
            clickedPawn.setBackground(Color.BLUE);
            unClickOthers(clickedPawn.getXCoordinate(), clickedPawn.getYCoordinate());
        } else if (clickedPawn.getIsYellow()) {
            clickedPawn.setBackground(Color.YELLOW);
        } else {
            clickedPawn.setBackground(Color.GREEN);
        }
    }

    private void unClickOthers(int clickedX, int clickedY) {
        for (Pawn pawn: allPawns) {
            if(pawn.getXCoordinate() != clickedX || pawn.getYCoordinate() != clickedY){
                if(pawn.getIsYellow()) {
                    pawn.setBackground(Color.YELLOW);
                } else {
                    pawn.setBackground(Color.GREEN);
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Pawn clickedPawn = ((Pawn) e.getSource());
        handleClickedPawn(clickedPawn);
    }

}
