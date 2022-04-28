package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(){

    }

    public King(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }


    public List<King> createKings() {
        List<King> list = new ArrayList<>();
        King whiteKing1 = new King("ReiBranco.png", Color.WHITE, new Position(7, 4), false);
        King blackKing1 = new King("ReiPreto.png", Color.BLACK, new Position(0, 4), false);
        list.add(whiteKing1);
        list.add(blackKing1);
        return list;
    }
}
