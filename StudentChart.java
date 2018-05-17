//import MarkCalculator;

//StudentChart class contains 2 methods: draw and printSummary

public class StudentChart {
	
	//variables that represent a width and a height of a bar
	final static int BAR_WIDTH=20;//constant - never changes
	static int barHeight=0;
	
	//new objects of Bar class used to annotate the chart ( x and y axes)
	static Bar axisX= new Bar();
	static Bar axisY= new Bar();
	
	int[] computedModuleMarks;//copy of the parameter in constructor
	
	//constructor
	public StudentChart(int[] computedModuleMarks){
		
		this.computedModuleMarks = computedModuleMarks;
		//call draw  method
		draw();
	}
	
	//method that draws thin bars based on the values in the array computedModuleMarks
	public static void draw(){ 
		
		// X axis
		axisX.changeColour(Colour.BLACK);
		axisX.changeSize(230, 2);
		axisX.moveVertical(160);
		axisX.makeVisible();
		
		// Y axis
		axisY.changeColour(Colour.BLACK);
		axisY.changeSize(2, 160);
		axisY.makeVisible();
	
		//one bar for every module
		for(int i=0; i<MarkCalculator.NUMBER_OF_MODULES; i++)
		{
			//new object of Bar class - computed module mark in the graphical representation
			Bar bar= new Bar();
			//change the size of the bar according to the value of the computed mark
			barHeight = MarkCalculator.computedModuleMarks[i];
			bar.changeSize(BAR_WIDTH, barHeight); 
			
			//the bar should be coloured according to the value of the computed mark
			if(barHeight>=70)//first class marks (70 or over)
			{
				//change the bar colour to MAGENTA
				bar.changeColour(Colour.MAGENTA);
			}
			//pass marks
			else if(barHeight>=40)
			{
				//change the bar colour to GREEN
				bar.changeColour(Colour.GREEN);
			}
			//compensating marks
			else if(barHeight>=35)
			{
				//change the bar colour to YELLOW
				bar.changeColour(Colour.YELLOW);
				//if the mark for core module (has an index 1 in the array of computed module marks) <40 but>=35 => the module is failed. So should be coloured red
				if(i==1)
				{
					bar.changeColour(Colour.RED);
				}
			}
			//failing marks
			else 
			{
				//change the bar colour to RED
				bar.changeColour(Colour.RED);
			}
			
			bar.makeVisible();
			bar.moveVertical(160-barHeight);
			//change position of the bar. Otherwise the next drawn bar will overlap the previous one
			bar.moveHorizontal(2+2*i*BAR_WIDTH);
			
			//call printSummary method in order to print a table of the returned module marks corresponding to the chart
			printSummary(i,barHeight); 
		}
		 
	}
	
	//method that prints a table of the returned module marks corresponding to the chart
	public static void printSummary(int moduleIndex, int barH){
			System.out.println("CSC102"+(moduleIndex+1)+"      "+barH);
	}
	
}
