package chess;
import java.util.ArrayList;
import java.lang.Math;

public class Bishop extends Piece {
    public Bishop(PieceColour colour){
        super();
        this.colour = colour;
    }

    @Override
    public boolean isLegitMove(int i0, int j0, int i1, int j1){
        int delta_i = i1-i0;
        int delta_j = j1-j0;
        int squared_distance = (delta_i)*(delta_i)+(delta_j)*(delta_j);
        Square[][] board = Board.getBoard();
        int step_i,step_j;
        if (delta_i==0 || delta_j==0){
            step_i=0;
            step_j=0;
        }else{
            step_i=delta_i/(Math.abs(delta_i));
            step_j=delta_j/(Math.abs(delta_j));
        }
        int in = i0+step_i;
        int jn = j0+step_j;

        ArrayList <Integer[]> possible_moves = new ArrayList<Integer[]>();
        Integer[] element=null;
        if (Math.abs(delta_i)==Math.abs(delta_j) && squared_distance <= 2*7*7){
            while(true){
                if (board[in][jn].hasPiece()){
                    //possible remove distance <= 2*7*7 when input checker implemented
                    //and move Math.abs()==.., into while loop
                    if (board[in][jn].getPiece().colour == colour){
                        break;
                    }else if (board[in][jn].getPiece().colour != colour){
                        element = new Integer[] {in,jn};
                        possible_moves.add(element);
                        break;
                    }
                }else if(!board[in][jn].hasPiece()){
                    element = new Integer[] {in,jn};
                    possible_moves.add(element);
                }
                if (in==i1 && jn==j1){
                    break;
                }
                in+=step_i;
                jn+=step_j;
            }
        }
        if (possible_moves.size()>0){
            for (Integer[] item: possible_moves){
                if (item[0]==i1 && item[1]==j1){
                    return true;
                }
            }
        }
        return false;

        // if (board[i1][j1].hasPiece()){
        //     //possible remove distance <= 2*7*7 when input checker implemented
        //     if (board[i1][j1].getPiece().colour != colour && Math.abs(delta_i)==Math.abs(delta_j) && squared_distance <= 2*7*7){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }else{
        //     if (Math.abs(delta_i)==Math.abs(delta_j) && squared_distance <= 2*7*7){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }
    }

}
