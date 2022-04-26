package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;

import static javafx.scene.input.KeyCode.R;

public class Pawn extends Piece {

    public Pawn(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }

    public void canMove(Position position, GridPane pane, Piece target){
        if(isFirstMove() == false){

            GridPane.setConstraints(target, position.getColumn(), position.getRow());
        }

//        if (pecaSelecionada instanceof Pawn && pecaSelecionada.getColor() == Color.BLACK){
//            if (!pecaSelecionada.isFirstMove() && oldRow >= row -2) {
//                GridPane.setConstraints(pecaSelecionada, column, row);
//                pecaSelecionada.setFirstMove(true);
//                movedPiece = true;
//            }
//            if (pecaSelecionada.isFirstMove() && oldRow >= row -1) {
//                GridPane.setConstraints(pecaSelecionada, column, row);
//                pecaSelecionada.setFirstMove(true);
//                movedPiece = true;
//            }
//        }
//        if (pecaSelecionada instanceof Pawn && pecaSelecionada.getColor() == Color.WHITE) {
//            if (pecaSelecionada.isFirstMove() == false && oldRow <= row + 2) {
//                GridPane.setConstraints(pecaSelecionada, column, row);
//                pecaSelecionada.setFirstMove(true);
//                movedPiece = true;
//            }
//            if (pecaSelecionada.isFirstMove() == true && oldRow <= row + 1) {
//                GridPane.setConstraints(pecaSelecionada, column, row);
//                pecaSelecionada.setFirstMove(true);
//                movedPiece = true;
//            }
//        }
    }
}
