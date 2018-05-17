

//MarkCalculator class contains 4 methods: computeMark, computeResult, computeAverage, minValue

public class MarkCalculator { 
	
	//first stage students have 6 modules, so the number of modules is a constant which cannot be changed
	public final static int NUMBER_OF_MODULES=6;
	
	//initialization of an array of computed module marks
	public static int[] computedModuleMarks = new int[NUMBER_OF_MODULES];
	
	// method that (given an array of student exam and coursework marks) returns an array of computed module marks
	public static int[] computeMark(int[] examMarks, int[] cwMarks){
		
		//array of coursework weightings for all 6 modules
		int[] weighting = {50,40,50,50,20,35};
		
		//for loop is used in order to calculate the resulted mark for ALL 6 modules
		for(int i=0; i<NUMBER_OF_MODULES; i++)
		{
			//computed module mark = ((coursework mark * coursework weighting) + (examination mark * (100 - coursework weighting))) / 100
			int formula=(int)Math.round(( ((double)cwMarks[i] * (double)weighting[i]) + ((double)examMarks[i] * (100 - (double)weighting[i])) )/ 100);
			
			//if the exam mark and coursework mark are greater than or equal to 35 then the returned mark is the computed module mark
			if(examMarks[i]>=35 && cwMarks[i]>=35)
			{
				computedModuleMarks[i] = formula;
			}
			//if either (or both) the exam or coursework mark is less than 35 then the returned mark is the minimum(35, computed module mark)
			//if(examMarks[i]<35 || cwMarks[i]<35)
			else 
			{
				//computed module mark = the minimum of the variable formula and 35 => use method minValue
				computedModuleMarks[i]=minValue(formula, 35);
			}
		}
		//method returns the array of computed module marks
		return computedModuleMarks;
	}
	
	// method that (given an array of student exam and coursework marks) returns a Stage Result for the student
	public static String computeResult(int[] examMarks, int[] cwMarks){
		
		//declaration
		String result="unknown";
		double stageAverage=0.0;
		
		//using method computeAverage, compute the average of all resulted module marks
		stageAverage = computeAverage(computedModuleMarks);
		
		//print the Stage Average
		System.out.println("Stage Average: "+stageAverage);
		
		//variables needed to count how many modules are recorded as Pass(pass), how many modules are recorded as Compensable Fail(cFail) and Fail(fail)
		int pass=0;
		int fail=0;
		int cFail=0;
		
		//counter of the modules that are recorded as Pass/Compensable Fail/Fail
		for(int i=0; i<NUMBER_OF_MODULES; i++)
		{
			//if the module mark is at least 40
			if(computedModuleMarks[i]>=40)
			{
				pass++;
			}
			//if the module is non-core and module mark is less than 40 but at least 35
			else if(i!=1 && computedModuleMarks[i]>=35)//core module(CSC1022) mark has the index 1 in the array of computed module marks
			{
				cFail++;
			}
			//otherwise
			else
			{
				fail++;
			}
		}
		
		//print the number of the modules that are recorded as Pass/ Compensable Fail/ Fail
		System.out.println("Passed : "+pass+"; compensable failed: "+cFail+"; failed: "+fail);
		
		//compute Stage result
		if(pass==NUMBER_OF_MODULES)// if all modules are recorded as a Pass then the Stage Result is PASS
		{
			result="Pass";
		}
		//if the Stage average is at least 40,  no module is recorded as a Fail, and there are one or two modules cFail
		//then the Stage Result is PASS BY COMPENSATION
		else if(stageAverage>=40 && fail==0 && cFail>0 && cFail<3)
		{
			result = "Pass By Compensation";
		}
		//otherwise the Stage Result is FAIL
		else 
		{
			result = "Fail"; 
		}
			
		//method returns the Stage Result
		return result;
	}
	
	//method that computes an average of the values in the given array
	public static double computeAverage(int[] marks){
		
		double result=0.0;
		int sum=0;
		//computes the sum of the values in the array
		for(int i=0; i<marks.length; i++)
		{
			sum+=marks[i];
		}
		//average = sumOfValuesOfElements/numberOfElements
		result=sum/marks.length;
		
		//method returns an average of the values in the array
		return result;
	}
	
	//method that identifies which of the two numbers has the minimum value
	public static int minValue(int num1, int num2){
		
		int result = num1;//set the fist number as the minimum value
		if(num2<result)
		{
			//if it turns out that the second number is less than the minimum value, set the minimum value as the second number 
			result = num2;
		}
		
		//method returns the minimum value of the two numbers
		return result;
	}
	
}
