package chess;

public class Piece {
    private int row;
    private int column;
    private String symbol;
    protected PieceColour colour;

    public Piece(){
    }

    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbolIn){
        symbol = symbolIn;
    }

    public PieceColour getColour(){
        return colour;
    }

    public void updateCoordinates(int iIn, int jIn){
        row = iIn;
        column = jIn;
    }

    public boolean isLegitMove(int i0, int j0 ,int i1, int j1) {return false;}
}
