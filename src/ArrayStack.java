
//Array implementation of a Stack of Queen Objects

public class ArrayStack {

	private static final int ARRAY_SIZE = 8;
	private Queen[] stack;
	private int count;
	
	//initializes queen stack to size of 8 and sets count to 0
	public ArrayStack() {
		stack = new Queen[ARRAY_SIZE];
		count = 0;
	}
	
	//gets the queen arrayStack
	public Queen[] getStack() {
		return stack;
	}

	//returns the count of queen objects in the stack
	public int getCount() {
		return count;
	}
	
	//places a queen object on top of the stack if there's room
	//if the stack is full, throws a stack overflow exception
	public void push(int row, int column) throws StackOverFlowException {
		if (isFull()) {
			throw new StackOverFlowException("Stack Overflow");
		} else {
			Queen queenPiece = new Queen();
			queenPiece.setRow(row);
			queenPiece.setColumn(column);
			stack[count] = queenPiece;
			count++;
		}
	}
	
	//removes a queen object from the top of the stack
	public Queen pop() {
		return stack[--count];
	}
	
	//checks if the stack is empty
	public boolean isEmpty() {
		return (count == 0);
	}
	
	//returns the queen object on top of the stack
	public Queen stackTop() {
		return stack[count-1];
	}
	
	//checks if the stack is at capacity
	public boolean isFull() {
		return (count == stack.length);
	}
	
	//removes all items from the stack
	public void clear() {
		while (!isEmpty()) {
			pop();
		}
	}
	
	//prints the elements in the stack
	public String toString() {
		String rtn = "";
		if (count == 0) {
			rtn = "<Empty>";
		} else {
			rtn += "Stack Contains " + (count) + " Elements\n";
			for (int i = count-1; i >= 0; i--) {
				if (i == count-1) {
					rtn += "Top -> " ;
				} else {
					rtn += "       ";
				}
				rtn += "<" + stack[i] + ">   " +  "Row: " + stack[i].getRow() + " Column: " + stack[i].getColumn() +"\n";
			}
		}
		return rtn;
	}

}
