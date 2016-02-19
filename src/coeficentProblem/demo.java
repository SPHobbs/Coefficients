package coeficentProblem;
import javax.swing.JOptionPane;
public class demo {

		private int setUp(){ 
			int n = 0;
			double [][] dCoefficients;
			double [] dRightSide;
			String x =JOptionPane.showInputDialog("How many unknowns are there?");
			n=Integer.parseInt(x);
			if(n==0){
				n=3;
			}else{
				dCoefficients = new double[Math.abs(n)][Math.abs(n)];
				dRightSide = new double[Math.abs(n)];
				if(n<0){
					n=-n;
					generateEquations(n,dCoefficients,dRightSide);
				}else{
					for(int i=0;i<n;i++){
						for(int j=0;j<n;j++){
							String number = JOptionPane.showInputDialog("Enter a number");
							int input = Integer.parseInt(number);
							dCoefficients[i][j]=input;
						}
						String number = JOptionPane.showInputDialog("Enter a number");
						int input = Integer.parseInt(number);
						dRightSide[i]=input;
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
		private static void print(String message, int n, double[][]coefficients, double[]rightSide){
			
		}
		private void print(String message, int n, double[]solution){
			
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
			
		}
		public static void main(String[]args){
			
		}
}
