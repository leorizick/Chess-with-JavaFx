package com.example.xadrezfx.entities;

import com.example.xadrezfx.entities.TipoDePecas.Pawn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece extends ImageView {
    private Color color;
    private Position position;
    private boolean firstMove;

    //variaveis para migrar chessController
    private Piece pecaSelecionada;
    private Piece pieceTarget;
    Integer column;
    Integer row;
    Integer oldRow;
    Integer oldColumn;
    double a = 0;
    double b = 0;
    int x = 0;
    int y = 0;
    int x1 = 0;
    int y1 = 0;
    private Pawn pawn;
    private Piece piece;
    private boolean movedPiece;
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

//    Getters and setters Migração ChessController


    public Piece getPecaSelecionada() {
        return pecaSelecionada;
    }

    public void setPecaSelecionada(Piece pecaSelecionada) {
        this.pecaSelecionada = pecaSelecionada;
    }

    public Piece getPieceTarget() {
        return pieceTarget;
    }

    public void setPieceTarget(Piece pieceTarget) {
        this.pieceTarget = pieceTarget;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getOldRow() {
        return oldRow;
    }

    public void setOldRow(Integer oldRow) {
        this.oldRow = oldRow;
    }

    public Integer getOldColumn() {
        return oldColumn;
    }

    public void setOldColumn(Integer oldColumn) {
        this.oldColumn = oldColumn;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public int getX0() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY0() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(boolean movedPiece) {
        this.movedPiece = movedPiece;
    }
}
