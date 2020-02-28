package chess;

public class Knight extends Piece{
    public Knight(PieceColour colour) {
        super();
        this.colour = colour;
    }

    @Override
    public boolean isLegitMove(int i0, int j0, int i1, int j1){
        int delta_i = i1-i0;
        int delta_j = j1-j0;
        int squared_distance = (delta_i)*(delta_i)+(delta_j)*(delta_j);
        Square[][] board = Board.getBoard();
        if (board[i1][j1].hasPiece()){
            if (board[i1][j1].getPiece().colour != colour && squared_distance == 5){
                return true;
            }else{
                return false;
            }
        }else{
            if (squared_distance == 5){
                return true;
            }else{
                return false;
            }
        }
    }
}
