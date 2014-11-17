public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();
	}
	
	//creates an array stack object and a solution object
	//calls the solve problem method to find a solution
	public void doIt(){
		ArrayStack as = new ArrayStack();
		EightQueensSolution eq = new EightQueensSolution(as);
		eq.solveProblem();
		System.out.println("\n" + as.toString());
	}

}
