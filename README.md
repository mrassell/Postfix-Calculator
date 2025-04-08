# 🧮 Postfix Calculator

CS102 NYU Computer Science – Fall 2024  

---

## 📄 Overview

This project builds a calculator that evaluates mathematical expressions by converting infix notation into postfix (Reverse Polish Notation) and then evaluating it. The program handles expressions using stacks and adheres to principles of classical data structure design, specifically the **ArrayStack**.

---

## ⚙️ Project Components

### 🧩 `Converter` Class
- Accepts an infix expression as a `String`.
- Uses `ParserHelper.java` to tokenize the expression.
- Converts the infix tokens into a postfix expression using a **stack-based algorithm**.
- Follows operator precedence and parenthesis rules.
- Outputs a space-separated postfix string.

### 🔢 `PostfixCalculator` Class
- Evaluates a given postfix expression.
- Uses a stack to process operands and apply operations.
- Supports `+`, `-`, `*`, `/`, and `^` (using `Math.pow(x, y)`).
- Returns the final computed result as a `double`.

---

## 📐 Expression Rules

- Expressions are guaranteed to be well-formed.
- Supported operators: `+`, `-`, `*`, `/`, `^`
- Operands are integers; results are decimal (if needed).
- Handles nested parentheses and respects operator precedence.
- Division by zero and unary minus are not required, but optional to handle.

---

## 🛠️ Key Implementation Notes

- Must use **custom stack implementation** (`ArrayStack`) as described in the textbook.
- No use of Java built-in collections like `ArrayList`.
- Code should be modular, with clear separation between conversion and evaluation logic.
- The postfix expression should be space-delimited and readable.

---

## 🧪 Sample Test Cases

Test your calculator using expressions like:
- `3+4*5/6`  
- `(300+23)*(43-21)/(84+7)`  
- `(4+8)*(6-5)/((3-2)*(2+2))`  
- `2^3*(5+(3+2)^2)-40/2+2^2-1`

These are well-formed and test various operator combinations, parentheses, and precedence scenarios.
