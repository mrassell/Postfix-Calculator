import java.util.List;

public class PostfixCalculator {
    // check if the string is an operator
    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^"));
    }

    public static double evaluate(String postfix) {
        List<String> tokenizedString = ParserHelper.parse(postfix.toCharArray());
        ArrayStack<String> stack = new ArrayStack<>();

        for (String s : tokenizedString) {
            if (!(isOperator(s))) {
                stack.push(s); // push numbers to stack because they are operands
            }

            else if (isOperator(s)) {
                String operator = s; 
                double second = Double.parseDouble(stack.pop()); // pop the top two numbers, prepared for operation
                double first = Double.parseDouble(stack.pop()); 

                if (operator.equals("^")) {
                    double result = Math.pow(first, second);
                    stack.push(Double.toString(result));

                } else if (operator.equals("*")) {
                    double result = first * second;
                    stack.push(Double.toString(result));

                } else if (operator.equals("/")) {
                    // edge case
                    if (second == 0) {
                        System.out.println("Can't divide by 0.");
                    } else {
                        double result = first / second;
                        stack.push(Double.toString(result));
                    }
                } else if (operator.equals("+")) {
                    double result = first + second;
                    stack.push(Double.toString(result));

                } else if (operator.contentEquals("-")) {
                    double result = first - second;
                    stack.push(Double.toString(result));
                }

            }
        }
        return Double.parseDouble(stack.pop()); // return the final result
    }
}