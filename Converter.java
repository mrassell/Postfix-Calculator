import java.util.List;

public class Converter {
    public String infix;

    Converter(String infix) {
        this.infix = infix;
    }

    public String toPostFix() {

        //convert string to char[] so we can use ParserHelper
        List<String> parsedList = ParserHelper.parse(infix.toCharArray());

        //converting back to string so we can return it
        String infixString = "";
        for (int i = 0; i < parsedList.size(); i++) {
            if (i > 0) {
                infixString += " ";
            }
            infixString += parsedList.get(i);
        }
        
        ArrayStack<String> stack = new ArrayStack<>();
        String postfix = "";

        for (String token : parsedList) {
            if (token.matches("[0-9]+")) { 
                postfix += token + " ";
            } else if (token.equals("(")) { 
                stack.push(token);
            } else if (token.equals(")")) { 
                while (!stack.isEmpty() && !stack.top().equals("(")) { // if token is ) pop until (
                    postfix += stack.pop() + " ";
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.top())) { // if token has lower precedence than top of stack, pop
                    postfix += stack.pop() + " ";
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) { // pop remaining operators
            postfix += stack.pop() + " ";
        }

        return postfix;
    }


    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1; 
        }
    }

}
