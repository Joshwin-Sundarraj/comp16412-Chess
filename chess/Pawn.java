package chess;
import java.util.*;

public class Pawn extends Piece{
    public Pawn(PieceColour colour){
        super();
        this.colour = colour;
    }

    @Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1){
        ArrayList <Integer[]> possible_moves = new ArrayList<Integer[]>();
        Integer[] element=null;
        Square[][] board = Board.getBoard();
        if (colour==PieceColour.WHITE){
               if  ((j0!=0) && board[i0-1][j0-1].hasPiece()){
                   if(board[i0-1][j0-1].getPiece().colour != colour){
                       element = new Integer[] {i0-1,j0-1};
                       possible_moves.add(element);
                   }
               }
               if (!board[i0-1][j0].hasPiece()){
                   element = new Integer[] {i0-1,j0};
                   possible_moves.add(element);
               }
               if ((j0!=7) && board[i0-1][j0+1].hasPiece()){
                   if(board[i0-1][j0+1].getPiece().colour != colour){
                       element = new Integer[] {i0-1,j0+1};
                       possible_moves.add(element);
                   }
               }
               if (i0==6 && !board[i0-1][j0].hasPiece() && !board[i0-2][j0].hasPiece()){
                   element = new Integer[] {i0-2,j0};
                   possible_moves.add(element);
               }
        }else{
               if  ((j0!=0) && board[i0+1][j0-1].hasPiece()){
                   if(board[i0+1][j0-1].getPiece().colour != colour){
                       element = new Integer[] {i0+1,j0-1};
                       possible_moves.add(element);
                   }
               }
               if (!board[i0+1][j0].hasPiece()){
                   element = new Integer[] {i0+1,j0};
                   possible_moves.add(element);
               }
               if ((j0!=7) && board[i0+1][j0+1].hasPiece()){
                   if(board[i0+1][j0+1].getPiece().colour != colour){
                       element = new Integer[] {i0+1,j0+1};
                       possible_moves.add(element);
                   }
               }
               if (i0==1 && !board[i0+1][j0].hasPiece() && !board[i0+2][j0].hasPiece()){
                   element = new Integer[] {i0+2,j0};
                   possible_moves.add(element);
               }
        }
        for (Integer[] item: possible_moves){
            if (item[0]==i1 && item[1]==j1){
                return true;
            }
        }
        return false;
    }
}
