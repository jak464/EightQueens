
public class ChessBoard {

	private static char[][] chessboard;
	private int row;
	private int column;
	
	public ChessBoard(){
		chessboard = new char[8][8];
	}
	
	public void printChessBoard(ArrayStack arrayStack){
		addPieces(arrayStack);
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
	
	
	
	private static void addPieces(ArrayStack arr){
		int column;
		int row;
		Queen[] zack = new Queen[8];
		zack = arr.getStack();
		
		for (int i = 7; i >= 0; i--) {
			row = zack[i].getRow();
			column = zack[i].getColumn();
			chessboard[row-1][column-1] = 'Q';
		}
	}
	
}
