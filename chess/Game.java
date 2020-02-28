package chess;
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	public Game(){
		Board b = new Board();
		b.initialisePieces();
		b.printBoard();

		Console Keyboard = System.console();
		String originIn, destinationIn;
		String j_coords = "abcdefgh";//what when uper case
		CheckInput checker = new CheckInput();
		Piece p;
		while (!gameEnd){
			//write the game logic
			for(PieceColour c: PieceColour.values()){
				int i0 = 0;
				int j0 = 0;
				int i1 = 0;
				int j1 = 0;
				while(true){
					System.out.printf("\n ------ %s ------ \n", c.toString());
					originIn =Keyboard.readLine("> Enter origin:");
					if(checker.checkCoordinateValidity(originIn)){
						i0 = Integer.parseInt(String.valueOf(originIn.charAt(0)))-1;
						j0 = j_coords.indexOf(originIn.charAt(1));
						p=b.getPiece(i0,j0);
						if(!(b.hasPiece(i0,j0) && String.valueOf(c).equals(String.valueOf(p.getColour())))){
							System.out.printf("\n Please pick a piece of colour %s \n", c.toString());
							continue;
						}
					}else{
						if((originIn.toUpperCase()).equals("END")){
							gameEnd=true;
							break;
						}
						System.out.println("\n Invalid input, choose a number from 1 to 8 followed by a letter from 'a' to 'h' \n");
						continue;
					}
					destinationIn =Keyboard.readLine("> Enter destination:");
					if(checker.checkCoordinateValidity(destinationIn)){
						i1 = Integer.parseInt(String.valueOf(destinationIn.charAt(0)))-1;
						j1 = j_coords.indexOf(destinationIn.charAt(1));
					}else{
						if((originIn.toUpperCase()).equals("END")){
							gameEnd=true;
							break;
						}
						System.out.println("\n Invalid input, choose a number from 1 to 8 followed by a letter from 'a' to 'h' \n");
						continue;
					}
					if (p.isLegitMove(i0,j0,i1,j1)){
						if (b.movePiece(i0,j0,i1,j1,p)){
							gameEnd=true;
						}
						b.printBoard();
						break;
					}else{
						System.out.println("\n This is not a legitimate move, try again. \n");
						continue;
					}
				}
				if (gameEnd){
					break;
				}
			}
				//need to add to check if colour of piece is players colour

				// while (!checker.checkCoordinateValidity(originIn) || !b.hasPiece(i0,j0)){
				// 	originIn =Keyboard.readLine("> Enter origin:");
				// 	i0 = Integer.parseInt(String.valueOf(originIn.charAt(1)))-1;
				// 	j0 = j_coords.indexOf(originIn.charAt(0));
				// 	p = b.getPiece(i0,j0);
				// 	if (b.hasPiece(i0,j0) && (String.valueOf(c).equals(String.valueOf(p.getColour())))){
				// 		break;
				// 	}
				// }
				

				// destinationIn =Keyboard.readLine("> Enter destination:");
				// i1 = Integer.parseInt(String.valueOf(destinationIn.charAt(1)))-1;
				// j1 = j_coords.indexOf(destinationIn.charAt(0));
				// while (!checker.checkCoordinateValidity(destinationIn) || !b.hasPiece(i1,j1)){
				// 	destinationIn =Keyboard.readLine("> Enter destination:");
				// 	i1 = Integer.parseInt(String.valueOf(destinationIn.charAt(1)))-1;
				// 	j1 = j_coords.indexOf(destinationIn.charAt(0));
				// }
		}
	}
	
	
	public static void main (String args[]){
		Game g  = new Game();
	}
}
