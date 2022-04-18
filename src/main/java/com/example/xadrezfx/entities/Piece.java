package com.example.xadrezfx.entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView {
    private Color color;
    private Position position;
    private boolean firstMove;

    public Piece(){

    }

    public Piece(String url, Color color, Position position, boolean firstMove) {
        super(url);
        this.color = color;
        this.position = position;
        this.firstMove = firstMove;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
}
