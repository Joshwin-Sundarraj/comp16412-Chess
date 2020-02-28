package chess;

public class CheckInput {
	
	public  boolean checkCoordinateValidity(String input){
		return input.matches("([1-8][a-hA-H])");
	}
}
