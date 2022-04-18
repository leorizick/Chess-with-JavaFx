package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

import static javafx.scene.input.KeyCode.R;

public class Pawn extends Piece {

    public Pawn(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }
}
