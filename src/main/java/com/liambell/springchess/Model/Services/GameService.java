package com.liambell.springchess.Model.Services;

import com.liambell.springchess.Model.Enitites.Board;
import com.liambell.springchess.Model.Enitites.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    Board board;

    public Piece[][] loadInitialGameState() {
        return board.loadDefaultChessConfiguration();
    }

    public Piece[][] movePiece(int[] startPos, int[] newPos) {
        return board.movePieceToNewPosition(startPos, newPos);

    }



}
