package com.example.xadrezfx.entities;

import com.example.xadrezfx.ChessController;
import com.example.xadrezfx.entities.TipoDePecas.Cells;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public abstract class Piece extends ImageView {
    private Color color;
    private Position position;
    private boolean firstMove;

    private ChessController chessController;

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
    private boolean movedPiece;

    public Piece() {

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


    public ChessController getChessController() {
        return chessController;
    }

    public void setChessController(ChessController chessController) {
        this.chessController = chessController;
    }

    public Piece getPecaSelecionada() {
        return pecaSelecionada;
    }

    public void setPecaSelecionada(Piece target) {
        pecaSelecionada = (Piece) target;
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


    public boolean isMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(boolean movedPiece) {
        this.movedPiece = movedPiece;
    }

    public void removeCapturedPieces(Node target) {
        ImageView newTarget = (ImageView) target;
        pieceTarget = (Piece) target;
        if (target instanceof Cells || pecaSelecionada.getColor() == pieceTarget.getColor()) {
            return;
        } else {
            if (pieceTarget.getColor() == Color.WHITE) {
                chessController.getGrid2().add(target, x, y);
                x++;
                if (x >= 2) {
                    x = 0;
                    y++;
                    if (y >= 4) {
                        y = 0;
                    }
                }
                if (pieceTarget.getColor() == Color.BLACK) {
                    chessController.getGrid3().add(target, x1, y1);
                    x1++;
                    if (x1 >= 2) {
                        x1 = 0;
                        y1++;
                        if (y1 >= 4) {
                            y1 = 0;
                        }
                    }
                }
                newTarget.setFitHeight(50);
                newTarget.setFitWidth(50);
                newTarget.setEffect(new Glow(0));
            }
        }
    }

    public void getOldPosition(Node target) {
        oldRow = GridPane.getRowIndex(target);
        oldColumn = GridPane.getColumnIndex(target);
        if (oldRow == null) oldRow = 0;
        if (oldColumn == null) oldColumn = 0;
    }

    public void getNewPosition(Node target) {
        row = GridPane.getRowIndex(target);
        column = GridPane.getColumnIndex(target);
        if (row == null) row = 0;
        if (column == null) column = 0;
    }

    public void movePiece() {
        if (pecaSelecionada.getColor() == pieceTarget.getColor()) {
            return;
        } else {
            GridPane.setConstraints(pecaSelecionada, column, row);
            pecaSelecionada.setFirstMove(true);
        }
    }
}
