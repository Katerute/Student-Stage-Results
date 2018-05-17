//Summary class contains the main and studentSummary methods 

//import a Scanner Class in order to allow the user to input the information(exam and coursework marks) from the keyboard
import java.util.Scanner;

public class Summary{
	
	//initialization of an array of exam marks
	public static int[] examMarks = new int[MarkCalculator.NUMBER_OF_MODULES];
	//initialization of an array of coursework marks
	public static int[] cwMarks = new int[MarkCalculator.NUMBER_OF_MODULES];
	String stageResult=" ";
	
	//the MAIN method
	public static void main(String[] args) {
		
		//call studentSummary, computeMark
		studentSummary();
		MarkCalculator.computeMark(examMarks, cwMarks);
		
		//print the Stage Result using computeResult method from MarkCalculator class
		System.out.println("Stage Result: "+MarkCalculator.computeResult(examMarks, cwMarks));
		
		//create new StudentChart object to produce a thin bar chart based on the values in the array computedModuleMarks
		StudentChart chart = new StudentChart(MarkCalculator.computedModuleMarks);
	}

	//method that allows the user to input exam and coursework marks
	public static void studentSummary(){
		
		//new Scanner class object to read in the information from the keyboard
		Scanner keyboard = new Scanner(System.in);
			
		//the input of coursework and examination marks for every module
		for(int i=0; i<MarkCalculator.NUMBER_OF_MODULES; i++)
		{
			//print the explanation for the user (what to input)
			System.out.println("Enter the coursework mark(0-100) and examination mark(0-100) for the CSC102"+(i+1)+" module: ");
			System.out.flush();//flushes the stream
			//read in a coursework and examination mark for the asked  module
			cwMarks[i]= keyboard.nextInt();
			examMarks[i]=keyboard.nextInt();
		}
		//close the scanner
		keyboard.close();
	}
}
