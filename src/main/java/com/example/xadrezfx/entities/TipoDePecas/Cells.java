package com.example.xadrezfx.entities.TipoDePecas;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;

import java.util.ArrayList;
import java.util.List;


public class Cells extends Piece {

    public Cells(){

    }

    public Cells(String url, Color color, Position position, boolean firstMove) {
        super(url, color, position, firstMove);
    }



    public List<Cells> createCells() {
        List<Cells> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    Cells cell = new Cells("casaBranca.jpg", null, new Position(i, j), false);
                    cell.setOpacity(30);
                    list.add(cell);
                } else {
                    Cells cell = new Cells("casaPreta.png", null, new Position(i, j), false);
                    cell.setOpacity(30);
                    list.add(cell);
                }

            }
        }
        return list;
    }
}
