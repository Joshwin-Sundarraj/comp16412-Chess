package chess;

public class King extends Piece{
    public King(PieceColour colour){
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
            //possible remove distance <= 2*7*7 when input checker implemented
            if ((board[i1][j1].getPiece().colour != colour && ((delta_i!=0 && delta_j==0)^(delta_i==0 && delta_j!=0)) && (squared_distance <= 1 || squared_distance <= 2))
                ||(board[i1][j1].getPiece().colour != colour && Math.abs(delta_i)==Math.abs(delta_j) && (squared_distance <= 1 || squared_distance <= 2))){
                return true;
            }else{
                return false;
            }
        }else{
            if ((((delta_i!=0 && delta_j==0)^(delta_i==0 && delta_j!=0)) && (squared_distance <= 1 || squared_distance <= 2))
                || (Math.abs(delta_i)==Math.abs(delta_j) && (squared_distance <= 1 || squared_distance <= 2))){
                return true;
            }else{
                return false;
            }
        }
    }
}
