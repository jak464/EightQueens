public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIT();
	}
	
	public void doIT(){
		ArrayStack as = new ArrayStack();
		EightQueensSolution eightQueens = new EightQueensSolution(as);
		eightQueens.algorithm();
	}

}
