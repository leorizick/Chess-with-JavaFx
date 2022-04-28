package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(){

    }


    public Bishop(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }

    public List<Bishop> createBishops() {
        List<Bishop> list = new ArrayList<>();
        Bishop whiteBishop1 = new Bishop("BispoBranca.png", Color.WHITE, new Position(7, 1), false);
        Bishop whiteBishop2 = new Bishop("BispoBranca.png", Color.WHITE, new Position(7, 6), false);
        Bishop blackBishop1 = new Bishop("BispoPreta.png", Color.BLACK, new Position(0, 1), false);
        Bishop blackBishop2 = new Bishop("BispoPreta.png", Color.BLACK, new Position(0, 6), false);
        list.add(whiteBishop1);
        list.add(whiteBishop2);
        list.add(blackBishop1);
        list.add(blackBishop2);
        return list;
    }
}
