package coeficentProblem;

public class equations {
	public static void decompistion(int n, double[][]coefficients, int[] oldRow){
		double tempValue;
		for(int i=0;i<n;i++){
			oldRow[i] = i;
		}
		for(int j=0;j<n;j++){
			upper(j, coefficients);
			int maxRow = beginLower(j, coefficients, scaling(n, coefficients));
			if(maxRow!=j){
				for(int k=0;k<n;k++){
					tempValue=coefficients[maxRow][k];
					coefficients[maxRow][k]=coefficients[j][k];
					coefficients[j][k]=coefficients[maxRow][k];
				}
				tempValue=oldRow[maxRow];
				oldRow[maxRow]=oldRow[j];
				oldRow[j]=(int) tempValue;
				scaling(n, maxRow)=scaling(n, j);
				
			}
		}
		
		System.out.print("The solutions to the equation are: ");
		for(int i=0;i<n;i++){
			System.out.print(rightSide[i]);
		}
	}
	private static double[] scaling(int n, double[][]coefficients){
		
	}
	private static void upper(int col, double[][]coefficients){
		
	}
	private static int beginLower(int col, double[][]coefficients, double[]scalings){
		
	}
	public static double[] substitute(int n, double[]lowerUpper, int[]oldRow, double[]rightSides){
		
	}
	private static double[] forward(int n, double[][]lowerUpper, int[] oldRow, double[]rightSides){
		
	}
	private static void backward(int n, double[][]lowerUpper, double[]rightSides){
		
	}
}
