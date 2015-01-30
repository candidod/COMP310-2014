import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;
//* Danielle Candido

public class RPN
{
	int  num1, num2,num3, sum;
	Stack<Integer> stack = new Stack<Integer>();
	
	Stack<Integer> evaluate(String expression) {
		StringReader sr = new StringReader(expression);
		Scanner scanner = new Scanner(sr);
		
		while (scanner.hasNext()) {
			String token = scanner.next();
			// Check for +, -, /, *
			if (token.equals("+")) 
			{
				System.out.println(stack); //Addition Stack Operation			
				num1 = stack.pop();
				num2 = stack.pop();
				sum = num1 + num2;
				stack.push(sum);
				// do the appropriate thing
				// pop 2 items off stack, and place result
				// onto stack
			}
			else if (token.equals("*"))
			{
				num1 = stack.pop(); // Multiplication Stack Operation
				num2 = stack.pop();
				sum = num1 * num2;
				stack.push(sum);
				System.out.println(stack.push(sum));
			}
			else if (token.equals("-")) // Subtraction Stack Operation
			{
				num1 = stack.pop();
				num2 = stack.pop();
				sum = num1 - num2;
				stack.push(sum);
				System.out.println(stack.push(sum));
			}
			else if (token.equals("/")) // Division Stack Operation
			{
				num1 = stack.pop();
				num2 = stack.pop();
				sum = num1 / num2;
				stack.push(sum);
				System.out.println(stack.push(sum));
			}
			else
			{
				stack.push(Integer.parseInt(token)); // return integer
			}
		}
		return stack;
	}
	void clear() {
		stack.clear();
	}
}
