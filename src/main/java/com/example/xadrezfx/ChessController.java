package com.example.xadrezfx;

import com.example.xadrezfx.entities.Piece;
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

    private Pawn pawn = new Pawn();
    private Rook rook = new Rook();
    private Bishop bishop = new Bishop();
    private King king = new King();
    private Queen queen = new Queen();
    private Knight knight = new Knight();
    private Cells cells = new Cells();

    private Piece piece = new Piece() {
    };

//    private List<Position> listPos = new ArrayList<>();

    @FXML
    private GridPane grid;

    @FXML
    private GridPane grid2;

    @FXML
    private GridPane grid3;

    public GridPane getGrid() {
        return grid;
    }


    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public GridPane getGrid2() {
        return grid2;
    }

    public void setGrid2(GridPane grid2) {
        this.grid2 = grid2;
    }

    public GridPane getGrid3() {
        return grid3;
    }

    public void setGrid3(GridPane grid3) {
        this.grid3 = grid3;
    }

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
        Piece newPiece = (Piece) target;
        target.startFullDrag();
        piece.setPecaSelecionada((Piece) target);
        piece.getOldPosition(target);

    }

    @FXML
    private void onDragReleased(MouseEvent event) {
        ImageView target = (ImageView) event.getTarget();
        piece.setPieceTarget((Piece) target);
        piece.getNewPosition(target);
        if (piece.getPecaSelecionada() instanceof Pawn) {
            pawn.canMove(piece.getPecaSelecionada(), piece.getRow(), piece.getColumn(), piece.getOldRow(), piece.getOldColumn());
        }
//        piece.movePiece();
//        if(movedPiece) {
        piece.removeCapturedPieces(target);
//            movedPiece = false;
//        }
        piece.getPecaSelecionada().setEffect(new Glow(0));

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

    public List<Piece> createPieces() {
        List<Piece> list = new ArrayList<>();
        list.addAll(cells.createCells());
        list.addAll(pawn.createPawns());
        list.addAll(rook.createRooks());
        list.addAll(bishop.createBishops());
        list.addAll(knight.createKnights());
        list.addAll(king.createKings());
        list.addAll(queen.createQueens());

        return list;
    }


}

