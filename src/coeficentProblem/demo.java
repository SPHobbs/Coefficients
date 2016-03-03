package coeficentProblem;
import javax.swing.JOptionPane;
public class demo {
		
		static int n = 0;
		static double[][] dCoefficients = null;
		static double[] dRightSides = null;
		static double[] solution = null;
		static String message = null;
		static double[][] rightSide = null;
		static double[] dRightSide = null;
		
		private int setUp(){
			String x =JOptionPane.showInputDialog("How many equations and unknowns are there?");
			n=Integer.parseInt(x);
			if(n==0){
				n=3;
			}else{
				dCoefficients = new double[Math.abs(n)][Math.abs(n)];
				dRightSides = new double[Math.abs(n)];
				if(n<0){
					n=-n;
					generateEquations(n,dCoefficients,dRightSides);
				}else{
					for(int i=0;i<n;i++){
						for(int j=0;j<n;j++){
							String number = JOptionPane.showInputDialog("Enter "+j+" coefficent");
							int input = Integer.parseInt(number);
							dCoefficients[i][j]=input;
						}
						String number = JOptionPane.showInputDialog("Enter the right side value");
						int input = Integer.parseInt(number);
						dRightSides[i]=input;
					}
				}
			}
			return n;
		}
		
		private void generateEquations(int n, double[][]coefficients, double[]rightSides){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					int input=(int)(100*(Math.random()-.5));
					coefficients[i][j]=input;
				}
				int input=(int)(100*(Math.random()-.5));
				rightSides[i]=input;
			}
			
		}
		
		private static void print(String message, int n, double[][]coefficients, double[]rightSides){
			System.out.print("The coefficients of the equation are: ");
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(coefficients[i][j]+" ");
				}
			}			
			System.out.print("\nThe solutions to the equation are: ");
			for(int i=0;i<n;i++){
				System.out.print(rightSides[i]+ " ");
			}
		}
		
		private void print(String message, int n, double[]solution){
			System.out.print("\nThe solutions to the equation are: ");
			for(int i=0;i<n;i++){
				System.out.print(solution[i]);
			}
		}
		
		public double[]evaluate(int n, double[][]coefficients, double[]rightSides, double[]solution){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					rightSides[i]+=coefficients[i][j]*solution[j];
				}
			}
			return rightSides;
		}	
		
		private void print(String message, int n,double[]origRS, double[]checkRS){
			System.out.println("Right side");
			for(int i=0;i<n;i++){
				System.out.println(origRS[i]);
			}
			
			System.out.println("Check right side");
			for(int i=0;i<n;i++){
				System.out.println(checkRS[i]);
			}
		}
		
		public static void main(String[]args){			
			new demo().setUp();
			new demo().print("Test", n, dCoefficients, dRightSides);
			
			double[][] coefficients = new double[n][n];
			double[] rightSides=new double[n];
			int [] oldRow=new int [n];
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					coefficients[i][j]=dCoefficients[i][j];
					}
				rightSides[i]=dRightSides[i];
			}
			equations.decompistion(n,coefficients,oldRow);
			equations.substitute(n, coefficients, oldRow, rightSides);
			
			
			
			new demo().print(message, n, solution);
			new demo().evaluate(n, dCoefficients, dRightSides, solution);
			new demo().print(message, n, rightSide, dRightSide);
		}
}
