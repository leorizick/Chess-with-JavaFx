package com.example.xadrezfx;

import com.example.xadrezfx.entities.Color;
import com.example.xadrezfx.entities.Piece;
import com.example.xadrezfx.entities.Position;
import com.example.xadrezfx.entities.TipoDePecas.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChessController implements Initializable {
//    private Piece pecaSelecionada;
//    private Piece pieceTarget;
//    Integer column;
//    Integer row;
//    Integer oldRow;
//    Integer oldColumn;
//    double a = 0;
//    double b = 0;
//    int x = 0;
//    int y = 0;
//    int x1 = 0;
//    int y1 = 0;
//    private Pawn pawn;
//    private Piece piece;
//    private boolean movedPiece;
    private Piece piece;

//    private List<Position> listPos = new ArrayList<>();

    @FXML
    private GridPane grid;

    @FXML
    private GridPane grid2;

    @FXML
    private GridPane grid3;



    @FXML
    private void onPressedDetected(MouseEvent event) {
        Node target = (Node) event.getTarget();
        if (!(target instanceof GridPane)) {
            target.setEffect(new Glow(1));
        }
    }

    @FXML
    private void onUnPressDetected(MouseEvent event) {
        Node target = (Node) event.getTarget();
        if (!(target instanceof GridPane)) {
            target.setEffect(new Glow(0));
        }
    }

    @FXML
    private void onDragDetected(MouseEvent event) {
        Node target = (Node) event.getTarget();
        target.startFullDrag();
        piece.setPecaSelecionada((Piece) target);
        getOldPosition(target);

    }


    private void getOldPosition(Node target) {
        piece.setOldRow() = GridPane.getRowIndex(target);
        oldColumn = GridPane.getColumnIndex(target);
        if (oldRow == null) oldRow = 0;
        if (oldColumn == null) oldColumn = 0;
    }

    private void getNewPosition(Node target) {
        row = GridPane.getRowIndex(target);
        column = GridPane.getColumnIndex(target);
        if (row == null) row = 0;
        if (column == null) column = 0;
    }


    @FXML
    private void onDragReleased(MouseEvent event) {
        ImageView target = (ImageView) event.getTarget();
        pieceTarget = (Piece) target;
        getNewPosition(target);
        movePiece();
//        if(movedPiece) {
            removeCapturedPieces(target);
//            movedPiece = false;
//        }


        pecaSelecionada.setEffect(new Glow(0));

    }

    private void movePiece() {
        if (pecaSelecionada.getColor() == pieceTarget.getColor()) {
            return;
        }
        else{
            GridPane.setConstraints(pecaSelecionada, column, row);
            pecaSelecionada.setFirstMove(true);
        }
    }

    private void removeCapturedPieces(Node target) {
        ImageView newTarget = (ImageView) target;
        pieceTarget = (Piece) target;
        if (target instanceof Cells || pecaSelecionada.getColor() == pieceTarget.getColor()) {
            return;
        } else {
            if (pieceTarget.getColor() == Color.WHITE) {
                grid2.add(target, x, y);
                x++;
                if (x >= 2) {
                    x = 0;
                    y++;
                    if (y >= 4) {
                        y = 0;
                    }
                }
            }
            if (pieceTarget.getColor() == Color.BLACK) {
                grid3.add(target, x1, y1);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Piece> list = createPieces();
        list.forEach(p -> {
            if ((p instanceof Cells)) {
                GridPane.setValignment(p, VPos.CENTER);
                GridPane.setHalignment(p, HPos.CENTER);
                p.setFitHeight(72);
                p.setFitWidth(72);
                p.setOnMouseDragReleased(this::onDragReleased);
                grid.add(p, p.getPosition().getColumn(), p.getPosition().getRow());
            } else {
                GridPane.setValignment(p, VPos.CENTER);
                GridPane.setHalignment(p, HPos.CENTER);
                p.setFitHeight(70);
                p.setFitWidth(70);
                p.setOnDragDetected(this::onDragDetected);
                p.setOnMouseDragReleased(this::onDragReleased);
                p.setOnMousePressed(this::onPressedDetected);
                p.setOnMouseReleased(this::onUnPressDetected);
                p.setCursor(Cursor.OPEN_HAND);
                grid.add(p, p.getPosition().getColumn(), p.getPosition().getRow());
            }
        });


    }

    private List<Piece> createPieces() {
        List<Piece> list = new ArrayList<>();
        list.addAll(createCells());
        list.addAll(createPawns());
        list.addAll(createRooks());
        list.addAll(createBishops());
        list.addAll(createKnights());
        list.addAll(createKings());
        list.addAll(createQueens());

        return list;
    }


    public List<Pawn> createPawns() {
        List<Pawn> list = new ArrayList<>();
        Pawn whitePawn1 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 0), false);
        Pawn whitePawn2 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 1), false);
        Pawn whitePawn3 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 2), false);
        Pawn whitePawn4 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 3), false);
        Pawn whitePawn5 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 4), false);
        Pawn whitePawn6 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 5), false);
        Pawn whitePawn7 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 6), false);
        Pawn whitePawn8 = new Pawn("PeaoBranco.png", Color.WHITE, new Position(6, 7), false);
        Pawn blackPawn1 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 0), false);
        Pawn blackPawn2 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 1), false);
        Pawn blackPawn3 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 2), false);
        Pawn blackPawn4 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 3), false);
        Pawn blackPawn5 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 4), false);
        Pawn blackPawn6 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 5), false);
        Pawn blackPawn7 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 6), false);
        Pawn blackPawn8 = new Pawn("PeaoPreto.png", Color.BLACK, new Position(1, 7), false);
        list.add(whitePawn1);
        list.add(whitePawn2);
        list.add(whitePawn3);
        list.add(whitePawn4);
        list.add(whitePawn5);
        list.add(whitePawn6);
        list.add(whitePawn7);
        list.add(whitePawn8);
        list.add(blackPawn1);
        list.add(blackPawn2);
        list.add(blackPawn3);
        list.add(blackPawn4);
        list.add(blackPawn5);
        list.add(blackPawn6);
        list.add(blackPawn7);
        list.add(blackPawn8);
        return list;
    }

    public List<Rook> createRooks() {
        List<Rook> list = new ArrayList<>();
        Rook whiteRook1 = new Rook("TorreBranca.png", Color.WHITE, new Position(7, 0), false);
        Rook whiteRook2 = new Rook("TorreBranca.png", Color.WHITE, new Position(7, 7), false);
        Rook blackRook1 = new Rook("TorrePreta.png", Color.BLACK, new Position(0, 0), false);
        Rook blackRook2 = new Rook("TorrePreta.png", Color.BLACK, new Position(0, 7), false);
        list.add(whiteRook1);
        list.add(whiteRook2);
        list.add(blackRook1);
        list.add(blackRook2);
        return list;
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

    public List<King> createKings() {
        List<King> list = new ArrayList<>();
        King whiteKing1 = new King("ReiBranco.png", Color.WHITE, new Position(7, 4), false);
        King blackKing1 = new King("ReiPreto.png", Color.BLACK, new Position(0, 4), false);
        list.add(whiteKing1);
        list.add(blackKing1);
        return list;
    }

    public List<Queen> createQueens() {
        List<Queen> list = new ArrayList<>();
        Queen whiteQueen1 = new Queen("DamaBranca.png", Color.WHITE, new Position(7, 3), false);
        Queen blackQueen1 = new Queen("DamaPreta.png", Color.BLACK, new Position(0, 3), false);
        list.add(whiteQueen1);
        list.add(blackQueen1);
        return list;
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

