/**
* <h1 > Application.java </h1 >
* <p>
* This class is designed for processing calculator functions in Java.
* It is part of Lab 1 Exercise C.
* </p>
*
* <p><b> Submission Date :</b> June 2, 2024 </p>
*
* @author Mark Guerta
* @version 1.0
*/
package com.markguerta.calculator;
import java.util.Scanner;
public class Application {
	// Calculator program
	public static void main(String[] args) {
		if (args.length > 0) {
			// Operators with 1 variable
			if (args.length == 1) {
				// Converts args to string and uses string manipulation to obtain operator and value
				String expression = args[0];
				String operator;
				int index;
				int length = expression.length();
				// Calculates factorial from CLI
				if (expression.indexOf("!") >= 0) {
					// Displays expression
					System.out.println(expression);
					index = expression.indexOf("!");
					operator = "!";
					double value = Double.parseDouble(expression.substring(0, index));
					// Prints answers
					System.out.println("\nThe answer is " + factorial((int) value));
				}
				// Rest of the methods that use one variable
				else {
					// Uses string manipulation to obtain operator and value
					index = expression.indexOf("(");
					operator = expression.substring(0, index);
					double value = Double.parseDouble(expression.substring(index + 1, length - 1));
					// Displays expression
					System.out.println(expression);
					// Prints answers based on operator
					switch(operator) {
						case "sqrt":
							System.out.println("The answer is " + sqrt(value));
							break;						
						case "log":
							System.out.println("The answer is " + log(value));
							break;
						case "log10":
							System.out.println("The answer is " + log10(value));
							break;
						case "sin":
							System.out.println("The answer is " + sin(Math.toRadians(value)));
							break;
						case "cos":
							System.out.println("The answer is " + cos(Math.toRadians(value)));
							break;
						case "tan":
							System.out.println("The answer is " + tan(Math.toRadians(value)));
							break;
					}
				}
			}
			
			else if (args.length == 3) {
				// Displays expression
				System.out.println(args[0] + args[1] + args[2]);
				double val1 = Double.parseDouble(args[0]);
				double val2 = Double.parseDouble(args[2]);
				String operator = args[1];
				// Prints answers
				switch (operator) {
					case "+":
						System.out.println("The answer is " + add(val1, val2));
						break;
					case "-":
						System.out.println("The answer is " + sub(val1, val2));
						break;
					case "x":
						System.out.println("The answer is " + mul(val1, val2));
						break;
					case "/":
						System.out.println("The answer is " + div(val1, val2));
						break;
					case "^":
						System.out.println("The answer is " + power(val1, val2));
						break;
				}
			}
		}
		
		else {
			// Provides user with instructions through prompts.
			// Scans for user input for variable x, y then math operation.
			// Converts number strings to doubles
			Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.println("Enter an operation (add, sub, mul, div, factorial power, sqrt,"
						+ "log, log10, sin, cos, tan) or type exit to end:");
				String operation = scanner.next();
				operation = operation.toLowerCase();
				if (operation.equals("exit")) {
					System.out.println("Exiting program...");
					break;
				}

				// Based on the operation choose, the requested operation is performed:
				switch (operation) {
			    	case "add":
			    		double[] zAdd = Scn(2, scanner);
			    		System.out.println("The answer is " + add(zAdd[0], zAdd[1]));
			    		break;

			    	case "sub":
			    		double[] zSub = Scn(2, scanner);
			    		System.out.println("The answer is " + sub(zSub[0], zSub[1]));
			    		break;

			    	case "mul":
			    		double[] zMul = Scn(2, scanner);
			    		System.out.println("The answer is " + mul(zMul[0], zMul[1]));
			    		break;

			    	case "div":
			    		double[] zDiv = Scn(2, scanner);
			    		if (zDiv[1] == 0)
			            System.out.println("The answer is undefined. Input a different expression.");
			    		else
			            System.out.println("\nThe answer is " + div(zDiv[0], zDiv[1]));
			    		break;

			    	case "factorial":
			    		double[] zFact = Scn(1, scanner);
			    		System.out.println("The answer is " + factorial((int) zFact[0]));
			    		break;

			    	case "power":
			    		double[] zPow = Scn(2, scanner);
			    		System.out.println("The answer is " + power(zPow[0], zPow[1]));
			    		break;

			    	case "sqrt":
			    		double[] zSqrt = Scn(1, scanner);
			    		System.out.println("The answer is " + sqrt(zSqrt[0]));
			    		break;

			    	case "log":
			    		double[] zLog = Scn(1, scanner);
			    		System.out.println("The answer is " + log(zLog[0]));
			    		break;

			    	case "log10":
			    		double[] zLog10 = Scn(1, scanner);
			    		System.out.println("The answer is " + log10(zLog10[0]));
			    		break;

			    	case "sin":
			    		double[] zSin = Scn(1, scanner);
			    		System.out.println("The answer is " + sin(Math.toRadians(zSin[0])));
			    		break;

			    	case "cos":
			    		double[] zCos = Scn(1, scanner);
			    		System.out.println("The answer is " + cos(Math.toRadians(zCos[0])));
			    		break;

			    	case "tan":
			    		double[] zTan = Scn(1, scanner);
			    		System.out.println("The answer is " + tan(Math.toRadians(zTan[0])));
			    		break;

			    	default:
			    		System.out.println("Choose a valid operator.");
			    		break;
				}
			}
			scanner.close();
		}
		
	}
	// Addition
	public static double add(double a, double b) {
		return a + b;
	}
	
	// Subtraction
	public static double sub(double c, double d) {
		return c - d;
	}
	
	// Multiplication
	public static double mul(double e, double f) {
		return e * f;
	}
	
	// Division
	// Checks for divide by zero
	public static double div(double g, double h) {
		if (h == 0)
			return 0;
		else
			return g/h;
	}
	
	// Factorial
	// Includes progress bar
	public static double factorial(int n) {
		if (n < 0) {
			System.out.println("Factorial of negaitive number is undefined.");
			return 0;
		}
			
		else {
			return factorialHelper(n, n);	
		}
	}
	
	// The issue is that whenever 1 is passed through the method, it will always only activate the if condition.
	// Since the if condition is activated, the method returns 1 which terminates the method.
	// Moving the if statement just before the next return statement ensures that the progress bar is always printed.
	// Additionally, changing the comparison operator from num <= 1 to num < 1 enables the progress bar to proceed to 100%.
	private static long factorialHelper(int originalNum, int num) {
		int progress = (int) (((originalNum - num) / ( double ) originalNum ) * 100);
		System.out.print("\rCalculating factorial: " + progress + "%");
		if (num < 1)
			return 1;
		return num * factorialHelper(originalNum, num - 1);
	}
	
	// Exponentiation
	public static double power(double base, double exponent) {
		return Math.pow(base, exponent);
	}
	
	//Square root
	public static double sqrt(double number) {
		return Math.sqrt(number);
	}
	
	// Natural logarithm
	public static double log(double number) {
		return Math.log(number);
	}
	
	// Base-10 logarithm
	public static double log10(double number) {
		return Math.log10(number);
	}
	
	// Sine function
	public static double sin(double angleRadians) {
		return Math.sin(angleRadians);
	}
	
	// Cosine function
	public static double cos(double angleRadians) {
		return Math.cos(angleRadians);
	}
	
	// Sine function
	public static double tan(double angleRadians) {
		return Math.tan(angleRadians);
	}
	
	// Scanner method for 1 or 2 variables
	public static double[] Scn(int num, Scanner scanner) {
		double z[] = new double[num];
		if (num == 1) {
			System.out.println("Enter a value: ");
			double x = scanner.nextDouble();
			z[0] = x;
			return z;
		}
		else if (num == 2) {
			// Instructions for user
			System.out.println("Enter first value: ");
			double x = scanner.nextDouble();
			System.out.println("Enter second value: ");
			double y = scanner.nextDouble();
			z[0] = x;
			z[1] = y;
			return z;
		}
		else
			return null;
	}
}
