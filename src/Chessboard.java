
public class Chessboard {

	private static char[][] chessboard;
	private int row;
	private int column;
	
	//initializes a 2d char array to represent the chessboard
	public Chessboard(){
		chessboard = new char[8][8];
	}
	
	public void printChessboard(ArrayStack arrayStack){
		//adds the pieces to the chessboard
		addPieces(arrayStack);
		
		//prints an 8x8 chessboard with line dividers
		  for (row = 0; row < chessboard.length; row++)
		    {
		        System.out.println("");
		        System.out.println(" +--+--+--+--+--+--+--+--+");
		        System.out.print(row+1);
		        for(column = 0; column < chessboard[row].length; column++)
		        {
		        	
		        	if(chessboard[row][column] != 0)
		        	{
		        	    System.out.print("| " + chessboard[row][column]);
		        	}
		        	else{
		        		System.out.print("|  ");
		        	}
		        	
		        	if(column == 7) {
		        		System.out.print("|");
		        	}
		        }
		    }
		    System.out.println("");
		    System.out.println(" +--+--+--+--+--+--+--+--+");
		    System.out.println("   1  2  3  4  5  6  7  8");
	}
	
	
	//iterates through the array stack to find the queens 
	//to add to the chessboard display
	private static void addPieces(ArrayStack arrayStack){
		int column;
		int row;
		
		Queen[] queen = new Queen[8];
		queen = arrayStack.getStack();
		
		for (int i = 7; i >= 0; i--) {
			row = queen[i].getRow();
			column = queen[i].getColumn();
			chessboard[row-1][column-1] = 'Q';
		}
	}
	
}
