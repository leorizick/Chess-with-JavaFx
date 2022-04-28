package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn() {

    }

    public Pawn(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }

    public void canMove(Piece target, int row, int column, int oldRow, int oldColumn) {
        if (target.getColor() == Color.BLACK) {
            if (!target.isFirstMove() && oldRow >= row - 2 && oldRow < row && oldColumn == column ) {
                GridPane.setConstraints(target, column, row);
                target.setFirstMove(true);
            }
            if (target.isFirstMove() && oldRow >= row - 1 && oldRow < row && oldColumn == column ) {
                GridPane.setConstraints(target, column, row);
                target.setFirstMove(true);
            }
        }
        if (target.getColor() == Color.WHITE) {
            if (!target.isFirstMove() && oldRow <= row + 2 && oldRow > row && oldColumn == column ) {
                    GridPane.setConstraints(target, column, row);
                    target.setFirstMove(true);
            }
            if (target.isFirstMove() && oldRow <= row + 1  && oldRow > row && oldColumn == column  ) {
                    GridPane.setConstraints(target, column, row);
                    target.setFirstMove(true);
            }

            }

    }
    
    public List<Pawn> createPawns() {
        List<Pawn> list = new ArrayList<>();
        Pawn whitePawn1 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 0), false);
        Pawn whitePawn2 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 1), false);
        Pawn whitePawn3 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 2), false);
        Pawn whitePawn4 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 3), false);
        Pawn whitePawn5 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 4), false);
        Pawn whitePawn6 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 5), false);
        Pawn whitePawn7 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 6), false);
        Pawn whitePawn8 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 7), false);
        Pawn blackPawn1 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 0), false);
        Pawn blackPawn2 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 1), false);
        Pawn blackPawn3 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 2), false);
        Pawn blackPawn4 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 3), false);
        Pawn blackPawn5 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 4), false);
        Pawn blackPawn6 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 5), false);
        Pawn blackPawn7 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 6), false);
        Pawn blackPawn8 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 7), false);
        list.add(whitePawn1);
        list.add(whitePawn2);
        list.add(whitePawn3);
        list.add(whitePawn4);
        list.add(whitePawn5);
        list.add(whitePawn6);
        list.add(whitePawn7);
        list.add(whitePawn8);
        list.add(blackPawn1);
        list.add(blackPawn2);
        list.add(blackPawn3);
        list.add(blackPawn4);
        list.add(blackPawn5);
        list.add(blackPawn6);
        list.add(blackPawn7);
        list.add(blackPawn8);
        return list;
    }


}
