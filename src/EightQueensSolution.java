
public class EightQueensSolution {
	
	ArrayStack arrayStack;
	
	public EightQueensSolution(ArrayStack arrayStack){
		this.arrayStack = arrayStack;
	}

	public void algorithm(){
		boolean isSuccess = false;
		boolean isConflict = false;
		arrayStack.push(1, 1);
		
		while(!isSuccess & !arrayStack.isEmpty()){
			//check if the most recent choice (arrayStack.stacktop()) is in the same row, same
			//column, or same diagonal arrayStack any other choice... you will need to walk the stack to accomplish this
			
			if(arrayStack.getCount() != 1){
			
				isConflict = false;
				
				for (int i = arrayStack.getCount() - 2; i >= 0; i--){
					
					if(arrayStack.stackTop().getColumn() == arrayStack.getStack()[i].getColumn()){
						isConflict = true;
						break;
					}
					
					if(arrayStack.stackTop().getRow() == arrayStack.getStack()[i].getRow()){
						isConflict = true;
						break;
					}
					
					int rowDifference = arrayStack.stackTop().getRow() - arrayStack.getStack()[i].getRow();
					int columnDifference = arrayStack.stackTop().getColumn() - arrayStack.getStack()[i].getColumn();
					
					if(Math.abs(rowDifference) - Math.abs(columnDifference) == 0){
						isConflict = true;
						break;
					}
					
				}
			}
		
			if(isConflict == true){
				
				while(!arrayStack.isEmpty() && arrayStack.stackTop().getColumn() == 8){
					arrayStack.pop();
				}
				
				//not in column 8 and stack is not empty
				if(!arrayStack.isEmpty()){
					arrayStack.stackTop().setColumn(arrayStack.stackTop().getColumn()+1);
				}
			}
			else if(!isConflict & arrayStack.getCount() == 8){
				isSuccess = true;
				ChessBoard cb = new ChessBoard();
				cb.printChessBoard(arrayStack);
			}
			else{
				arrayStack.push(arrayStack.getCount()+1, 1);
			}
			
		}
	}	
}
