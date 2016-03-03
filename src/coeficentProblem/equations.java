package coeficentProblem;

public class equations {
	public static void decompistion(int n, double[][]coefficients, int[] oldRow){
		double tempValue;
		double scaling[] = scaling(n,coefficients);
		for(int i=0;i<n;i++){
			oldRow[i] = i;
		}
		for(int j=0;j<n;j++){
			upper(n,j, coefficients);
			int maxRow = beginLower(n,j, coefficients, scaling);
			if(maxRow!=j){
				for(int k=0;k<n;k++){
					tempValue=coefficients[maxRow][k];
					coefficients[maxRow][k]=coefficients[j][k];
					coefficients[j][k]=coefficients[maxRow][k];
				}
				tempValue=oldRow[maxRow];
				oldRow[maxRow]=oldRow[j];
				oldRow[j]=(int) tempValue;
				scaling[maxRow]=scaling[j];
				
			}
			if(j!=(n-1)){
				for(int i=(j+1);i<n;i++){
					coefficients[i][j]/=coefficients[j][j];
				}
			}
		}
	}
	private static double[] scaling(int n, double[][]coefficients){
		double[] scalings = new double[n];
		for(int i = 0;i<n;i++){
			double max=0;
			for(int j = 0;j<n;j++){
				if(Math.abs(coefficients[i][j])>max){
					max=Math.abs(coefficients[i][j]);
				}
			}
			if(max==0){
				System.out.println("Error: All of the coefficients in a row are zero");
			}
			scalings[i]=1/max;
		}
		return scalings;
	}
	private static void upper(int n, int col, double[][]coefficients){
		for(int i=0;i<n;i++){
			double sum = coefficients[i][col];
			for(int k=0;k<n;k++){
				sum-=coefficients[i][k]*coefficients[k][col];
			}
			coefficients[i][col]=sum;
		}
	}
	private static int beginLower(int n,int col, double[][]coefficients, double[]scalings){
		int rowMax=col;
		double max = 0;
		for(int i=col;i<n;i++){
			double sum=coefficients[i][col];
			for(int k=0;k<col;k++){
				sum-=coefficients[i][k]*coefficients[k][col];
			}
			coefficients[i][col]=sum;
			if(scalings[i]*Math.abs(sum)>=max){
				max=scalings[i]*Math.abs(sum);
				rowMax=(int) max;
			}
		}
		return rowMax;
	}
	public static double[] substitute(int n, double[][]lowerUpper, int[]oldRow, double[]rightSides){
		rightSides=forward(n,lowerUpper,oldRow,rightSides);
		backward(n,lowerUpper,rightSides);
		return rightSides;
	}
	private static double[] forward(int n, double[][]lowerUpper, int[] oldRow, double[]rightSides){
		int firstNonZeroRow=-1;
		double[] solution=new double[n];
		for(int i=0;i<n;i++){
			double sum = rightSides[oldRow[i]];
			if(firstNonZeroRow>-1){
				for(int j=firstNonZeroRow;j<i;j++){
					
				}
			}else if(sum!=0){
				firstNonZeroRow=i;
			}
			solution[i]=sum;
		}
		return solution;
	}
	private static void backward(int n, double[][]lowerUpper, double[]rightSides){
		for(int i=n-1;i>=0;i++){
			double sum = rightSides[i];
			for(int j=i+1;j<i;j++){
				sum-=lowerUpper[i][j]*rightSides[j];
			}
			rightSides[i]=sum/lowerUpper[i][i];
		}
	}
}
