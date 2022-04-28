package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(){

    }

    public Rook(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }

    public void canMove(Piece target, int row, int column, int oldRow, int oldColumn) {
        if (target.getColor() == Color.BLACK) {
            if (oldRow != row - 1 && oldColumn != column -1 ) {
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






    public List<Rook> createRooks() {
        List<Rook> list = new ArrayList<>();
        Rook whiteRook1 = new Rook("TorreBranca.png", Color.WHITE, new Position(7, 0), false);
        Rook whiteRook2 = new Rook("TorreBranca.png", Color.WHITE, new Position(7, 7), false);
        Rook blackRook1 = new Rook("TorrePreta.png", Color.BLACK, new Position(0, 0), false);
        Rook blackRook2 = new Rook("TorrePreta.png", Color.BLACK, new Position(0, 7), false);
        list.add(whiteRook1);
        list.add(whiteRook2);
        list.add(blackRook1);
        list.add(blackRook2);
        return list;
    }
}
