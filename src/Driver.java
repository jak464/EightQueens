import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIT();
	}
	
	public void doIT(){
		ArrayStack as = new ArrayStack();
		int row;
		int column;
		System.out.println(as.toString());
		
		for(int i = 0; i < 8; i++) {
			row = randoGenerator();
			column = randoGenerator();
			as.push(row, column);
		}

		System.out.println(as.toString());
		
		ChessBoard cb = new ChessBoard();
		cb.printchessboard();
		cb.addPiece(as);
		cb.printchessboard();
	}
	
	public int randoGenerator(){
		Random randy = new Random();
		int randNum = randy.nextInt(8) + 1;
		return randNum;
	}
	
	public void algorithm(ArrayStack as){
		boolean isSuccess = false;
		boolean isConflict = false;
		
		while(!isSuccess & !as.isEmpty()){
			//check if the most recent choice (as.stacktop()) is in the same row, same
			//column, or same diagonal as any other choice... you will need to walk the stack to accomplish this
			
			isConflict = true;
			
			if(isConflict){
				as.clear();
			}
			else if(!isConflict & as.getCount() == 8){
				isSuccess = true;
				as.toString();
			}
			
		}
	}

}
