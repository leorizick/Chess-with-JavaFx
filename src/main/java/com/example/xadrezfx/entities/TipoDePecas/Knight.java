package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(){

    }

    public Knight(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }





    public List<Knight> createKnights() {
        List<Knight> list = new ArrayList<>();
        Knight whiteKnight1 = new Knight("CavaloBranca.png", Color.WHITE, new Position(7, 2), false);
        Knight whiteKnight2 = new Knight("CavaloBranca.png", Color.WHITE, new Position(7, 5), false);
        Knight blackKnight1 = new Knight("CavaloPreta.png", Color.BLACK, new Position(0, 2), false);
        Knight blackKnight2 = new Knight("CavaloPreta.png", Color.BLACK, new Position(0, 5), false);
        list.add(whiteKnight1);
        list.add(whiteKnight2);
        list.add(blackKnight1);
        list.add(blackKnight2);
        return list;
    }
}
