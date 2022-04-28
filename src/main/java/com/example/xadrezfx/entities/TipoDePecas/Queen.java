package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(){

    }

    public Queen(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }





    public List<Queen> createQueens() {
        List<Queen> list = new ArrayList<>();
        Queen whiteQueen1 = new Queen("DamaBranca.png", Color.WHITE, new Position(7, 3), false);
        Queen blackQueen1 = new Queen("DamaPreta.png", Color.BLACK, new Position(0, 3), false);
        list.add(whiteQueen1);
        list.add(blackQueen1);
        return list;
    }
}
