package chess;


//This class is partially implemented. Some methods need to have their body written, some other are fine as they are and other may need to be extended. 

public class Board {
	private static Square [][] board = new Square[8][8];

	public Board(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square(i,j);
		}		
	}	

	public static Square[][] getBoard(){
		return board;
	}
	
	public void initialisePieces(){
		//white pieces
		for(int j=0; j<8 ; j++){
			Pawn newPawn = new Pawn(PieceColour.WHITE);
			newPawn.setSymbol("\u2659");
			newPawn.updateCoordinates(6,j);
			setPiece(6,j, newPawn);
		}

		for(int j=0; j<8 ; j+=7){
			Rook newRook = new Rook(PieceColour.WHITE);
			newRook.setSymbol("\u2656");
			newRook.updateCoordinates(7,j);
			setPiece(7,j, newRook);
		}

		for(int j=1; j<7 ; j+=5){
			Knight newKnight = new Knight(PieceColour.WHITE);
			newKnight.setSymbol("\u2658");
			newKnight.updateCoordinates(7,j);
			setPiece(7,j, newKnight);
		}

		for(int j=2; j<6 ; j+=3){
			Bishop newBishop = new Bishop(PieceColour.WHITE);
			newBishop.setSymbol("\u2657");
			newBishop.updateCoordinates(7,j);
			setPiece(7,j, newBishop);
		}

		Queen whiteQueen = new Queen(PieceColour.WHITE);
		whiteQueen.setSymbol("\u2655");
		whiteQueen.updateCoordinates(7,3);
		setPiece(7,3, whiteQueen);

		King whiteKing = new King(PieceColour.WHITE);
		whiteKing.setSymbol("\u2654");
		whiteKing.updateCoordinates(7,4);
		setPiece(7,4, whiteKing);

		//black pieces
		for(int j=0; j<8 ; j++){
			Pawn newPawn = new Pawn(PieceColour.BLACK);
			newPawn.setSymbol("\u265F");
			newPawn.updateCoordinates(1,j);
			setPiece(1,j, newPawn);
		}

		for(int j=0; j<8 ; j+=7){
			Rook newRook = new Rook(PieceColour.BLACK);
			newRook.setSymbol("\u265C");
			newRook.updateCoordinates(0,j);
			setPiece(0,j, newRook);
		}

		for(int j=1; j<7 ; j+=5){
			Knight newKnight = new Knight(PieceColour.BLACK);
			newKnight.setSymbol("\u265E");
			newKnight.updateCoordinates(0,j);
			setPiece(0,j, newKnight);
		}

		for(int j=2; j<6 ; j+=3){
			Bishop newBishop = new Bishop(PieceColour.BLACK);
			newBishop.setSymbol("\u265D");
			newBishop.updateCoordinates(0,j);
			setPiece(0,j, newBishop);
		}

		Queen blackQueen = new Queen(PieceColour.BLACK);
		blackQueen.setSymbol("\u265B");
		blackQueen.updateCoordinates(0,3);
		setPiece(0,3, blackQueen);

		King blackKing = new King(PieceColour.BLACK);
		blackKing.setSymbol("\u265A");
		blackKing.updateCoordinates(0,4);
		setPiece(0,4, blackKing);
	}
	
	public void printBoard(){
		// System.out.print("\033[H\033[2J");//clear terminal, remove if necessary
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		String wsp=" ";String bar="|";
		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && board[i][j].hasPiece())
						System.out.print(row+ " "+board[i][j].getPiece().getSymbol());	
					else if ((j==0) && !board[i][j].hasPiece())
						System.out.print(row+"  " );
					else if (board[i][j].hasPiece())					
						System.out.print("|" + board[i][j].getPiece().getSymbol());					
					else					
						System.out.print("| ");		
				}				
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");
	
	}
	
	
	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		if(hasPiece(i1,j1) && (board[i1][j1].getPiece() instanceof King)
			&& (board[i0][j0].getPiece().colour != board[i1][j1].getPiece().colour)){
			System.out.printf("\n -------- %s WON THE GAME --------\n", board[i0][j0].getPiece().colour);
			return true;
		}
		setPiece(i0,j0,null);
		setPiece(i1,j1,p);
		return false;//set to true when king has been captured.
	}

	public void setPiece(int iIn, int jIn, Piece p){
		if (p!=null) {
			p.updateCoordinates(iIn,jIn);
			board[iIn][jIn].setPiece(p);
		}
		else {
			board[iIn][jIn].removePiece();
		}
	}
	
	public Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}
	
	public boolean hasPiece(int i, int j){
		if(board[i][j].hasPiece()){
			return true;
		}else{
			return false;
		}
	}

}
