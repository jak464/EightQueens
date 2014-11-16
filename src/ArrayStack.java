
public class ArrayStack {

	private static final int ARRAY_SIZE = 8;
	private Queen[] stack;
	private int count;
	
	public ArrayStack() {
		stack = new Queen[ARRAY_SIZE];
		count = 0;
	}
	
	public Queen[] getStack() {
		return stack;
	}

	public void setStack(Queen[] stack) {
		this.stack = stack;
	}

	
	public int getCount() {
		return count;
	}
	
	public void push(int row, int column) throws StackOverFlowException {
		if (isFull()) {
			throw new StackOverFlowException("Stack Overflow");
		} else {
			Queen queenie = new Queen();
			queenie.setRow(row);
			queenie.setColumn(column);
			stack[count] = queenie;
			count++;
		}
	}
	
	public Queen pop() {
		return stack[--count];
	}
	
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public Queen stackTop() {
		return stack[count-1];
	}
	
	public boolean isFull() {
		return (count == stack.length);
	}
	
	public void clear() {
		while (!isEmpty()) {
			pop();
		}
	}
	
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




	/*public void boobtoString() {
		   for(int i = 0; i < 8; i++)
		   {
		      for(int j = 0; j < 8; j++)
		      {
		         System.out.printf("%3d ", stack[i][j]);
		      }
		      System.out.println();
		   }
		}*/

}
