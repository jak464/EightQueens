import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIT();
	}
	
	public void doIT(){
		ArrayStack as = new ArrayStack();
		algorithm(as);
//		int row;
//		int column;
//		System.out.println(as.toString());
//		
//		for(int i = 0; i < 8; i++) {
//			row = randoGenerator();
//			column = randoGenerator();
//			as.push(row, column);
//		}
//
//		System.out.println(as.toString());
//		
//		ChessBoard cb = new ChessBoard();
//		cb.printchessboard();
//		cb.addPieces(as);
//		cb.printchessboard();
	}
	
	
	public int randoGenerator(){
		Random randy = new Random();
		int randNum = randy.nextInt(8) + 1;
		return randNum;
	}
	
	public void algorithm(ArrayStack as){
		boolean isSuccess = false;
		boolean isConflict = false;
		as.push(1, 1);
		
		while(!isSuccess & !as.isEmpty()){
			//check if the most recent choice (as.stacktop()) is in the same row, same
			//column, or same diagonal as any other choice... you will need to walk the stack to accomplish this
			
			if(as.getCount() != 1){
				for (int i = as.getCount()-1; i >= 0; i--){
					
					if(as.stackTop().getColumn() == as.getStack()[i].getColumn()){
						isConflict = true;
					}
					
					if(as.stackTop().getRow() == as.getStack()[i].getRow()){
						isConflict = true;
					}
					
					int rowDifference = as.stackTop().getRow() - as.getStack()[i].getRow();
					int columnDifference = as.stackTop().getColumn() - as.getStack()[i].getColumn();
					
					if(rowDifference - columnDifference == 0){
						isConflict = true;
					}
					
				}
			}
		
			
			if(isConflict){
				while(as.stackTop().getColumn() != 8){
					as.pop();
				}
				as.stackTop().setColumn(as.stackTop().getColumn()+1);
			}
			else if(!isConflict & as.getCount() == 8){
				isSuccess = true;
				ChessBoard cb = new ChessBoard();
				ChessBoard.addPieces(as);
				cb.printchessboard();
			}
			else{
				as.push(as.getCount()+1, 1);
			}
			
		}
	}
	
	/*public void eightQueensAlgorithm(ArrayStack as){
		boolean isSuccess = false;
		boolean isConflict = false;
		as.push(1, 1);
		
		while(!isSuccess & !as.isEmpty()){
			for (int i = as.count-2; i >= 0; i--){
			
				if(stackTop().getColumn() == stack[i].getColumn()){
					isConflict = true;
				}
				
				if(stackTop().getRow() == stack[i].getRow()){
					isConflict = true;
				}
				
				int rowDifference = stackTop().getRow() - stack[i].getRow();
				int columnDifference = stackTop().getColumn() - stack[i].getColumn();
				
				if(rowDifference - columnDifference == 0){
					isConflict = true;
				}
				
			}
			
			if(isConflict){
				stack.pop();
			}
		}*/
	

}
