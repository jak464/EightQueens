
public class EightQueensSolution {
	
	ArrayStack arrayStack;
	
	public EightQueensSolution(ArrayStack arrayStack){
		this.arrayStack = arrayStack;
	}

	public void solveProblem(){
		boolean isSuccess = false;
		boolean isConflict = false;
		arrayStack.push(1, 1);
		
		while(!isSuccess & !arrayStack.isEmpty()){
			//check if the most recent choice (arrayStack.stacktop()) is in the same row, same
			//column, or same diagonal arrayStack any other choice... you will need to walk the stack to accomplish this
			
			if(arrayStack.getCount() != 1){
			
				isConflict = false;
				
				//checks the stackTop against the other queens in the array by 
				//iterating through the stack to determine if there is a conflict
				for (int i = arrayStack.getCount() - 2; i >= 0; i--){
					
					//checks if same column
					if(arrayStack.stackTop().getColumn() == arrayStack.getStack()[i].getColumn()){
						isConflict = true;
						break;
					}
					
					//checks if same row
					if(arrayStack.stackTop().getRow() == arrayStack.getStack()[i].getRow()){
						isConflict = true;
						break;
					}
					
					//checks if diagonal by determining the absolute value of the rows minus the columns
					int rowDifference = arrayStack.stackTop().getRow() - arrayStack.getStack()[i].getRow();
					int columnDifference = arrayStack.stackTop().getColumn() - arrayStack.getStack()[i].getColumn();
					
					if(Math.abs(rowDifference) - Math.abs(columnDifference) == 0){
						isConflict = true;
						break;
					}
					
				}
			}
		
			if(isConflict == true){
				
				//pops off the elements until the stack is empty or top stack is not in column 8
				while(!arrayStack.isEmpty() && arrayStack.stackTop().getColumn() == 8){
					arrayStack.pop();
				}
				
				//not in column 8 and stack is not empty
				
				//increases the column of the stack top by 1
				if(!arrayStack.isEmpty()){
					arrayStack.stackTop().setColumn(arrayStack.stackTop().getColumn()+1);
				}
			}
			
			//solution is found, print the chessboard
			else if(!isConflict & arrayStack.getCount() == 8){
				isSuccess = true;
				Chessboard cb = new Chessboard();
				cb.printChessboard(arrayStack);
			}
			
			//push next element onto the stack with row: size + 1 , column: 1
			else{
				arrayStack.push(arrayStack.getCount()+1, 1);
			}
			
		}
	}	
}
