# GDSC_app


---

📱 Project Report: Calculator Application


---

📝 1. Introduction

The Calculator Application is a robust Android application developed using Jetpack Compose. It provides functionality for basic arithmetic, trigonometric calculations, and power operations, packaged within a modern, user-friendly interface. The app follows Material Design principles and supports dark mode for enhanced user experience.

This project demonstrates the use of declarative UI design, state management, and mathematical expression evaluation, making it a powerful and extendable tool for mathematical operations.


---

🎯 2. Objective

The primary goals of the Calculator Application are:
✅ Perform accurate mathematical computations.
✅ Provide an intuitive and responsive user interface.
✅ Demonstrate modern Android development techniques using Jetpack Compose.
✅ Ensure expandability for advanced features in future iterations.


---

🛠️ 3. Technology Stack


---

🏗️ 4. Application Structure

4.1 MainActivity

📌 Role: The entry point of the application.

Initializes the app using the CALCULATOR2Theme for consistent styling.

Loads the main UI by calling the CalculatorUI composable.

Enables Edge-to-Edge support for a seamless full-screen experience.



---

4.2 CalculatorUI Composable

📌 Role: The core user interface of the application.

🖊️ 4.2.1 Input Field

Component: BasicTextField

Features:

Displays user input and the calculated results.

Auto-aligns the cursor to the end for better usability.

Styled with large font size, right-aligned text, and white color for readability.




---

🔢 4.2.2 Calculator Buttons

Components: Button, arranged using Row and Column composables.

Layout:

Buttons are organized into a grid structure with rows for numbers, operators, and functions.

Dynamically spaced using Modifier.weight() for uniform sizing.


Actions on Button Click: | Button | Functionality                                                                 | |------------|-----------------------------------------------------------------------------------| | =        | Evaluates the expression by calling evaluateExpression().                      | | C        | Deletes the last character of the input.                                         | | AC       | Clears the entire input field.                                                   | | 0-9      | Adds the respective number to the expression.                                    | | Operators  | Adds the respective operator (+, -, *, /, ^) to the expression.        | | Trig. Func | Appends functions like sin, cos, or tan to the input.                      |



---

4.3 Expression Evaluation

📌 Role: Computes the result of mathematical expressions.

🔍 Function: evaluateExpression()

Library: Exp4j (net.objecthunter.exp4j).

Steps:

1. Preprocesses the expression using preprocessExpression() (e.g., converts 2(3) to 2*(3)).


2. Parses and evaluates the expression using ExpressionBuilder.


3. Returns the result as a string or "Error" for invalid expressions.





---

4.4 Expression Preprocessing

📌 Role: Formats the input expression to ensure compatibility with the parser.

✍️ Function: preprocessExpression()

Logic:

Inserts missing multiplication signs between numbers and parentheses.

Example: Converts 3(4) or )(5) to 3*(4) and )*(5).




---

4.5 Layout Management

📌 Role: Manages the overall UI structure using Compose’s declarative components.

Column: Arranges input fields and button rows vertically.

Row: Aligns buttons horizontally within each row.

Modifiers:

fillMaxSize(): Ensures components take up the full screen.

spacedBy(): Adds consistent spacing between rows.

weight(): Ensures equal sizing for all buttons.




---

4.6 Styling

💡 Dark Mode: Implemented using MaterialTheme.colorScheme.background.
🎨 Custom Styles:

TextField: Large font size (24.sp), white color, and right-aligned text.

Buttons: Uniform font size (18.sp) and padding for a clean appearance.



---

📚 5. Libraries Used


---

⚙️ 6. Application Workflow

1. Input Handling:

User enters a mathematical expression in the BasicTextField.

Input is dynamically updated and validated.



2. Expression Preprocessing:

Formats the expression for evaluation (e.g., adds missing multiplication signs).



3. Evaluation:

When the = button is pressed, the expression is parsed and evaluated.

Result is displayed in the input field.



4. Error Handling:

Invalid inputs (e.g., 2/0) return "Error".



5. Clearing:

C removes the last character.

AC clears the entire input.





---

🧩 7. Challenges and Improvements

🔴 Challenges:

1. Handling invalid expressions and edge cases, like mismatched parentheses.


2. Dynamic text updates without disrupting the user experience.

3. I was not able to include working of power funtion it was showing some error which I tried to
   resolve but I was unable to do that


🟢 Future Improvements:

1. Parentheses Validation: Add logic to handle mismatched or missing parentheses.


2. Advanced Functions: Extend support to logarithms, roots, and scientific notations.


3. Animations: Add visual feedback for button presses.


4. History Tracking: Maintain a history of previous calculations.




---

🏁 8. Conclusion

The Calculator Application successfully combines modern UI principles with advanced expression evaluation to deliver an accurate and user-friendly tool. It highlights the potential of Jetpack Compose in creating responsive Android applications and serves as a solid foundation for further expansion.

![WhatsApp Image 2025-02-19 at 16 49 02_8bce6be2](https://github.com/user-attachments/assets/acea204d-062a-445b-a037-0e6f5072fb6b)


![image](https://github.com/user-attachments/assets/b769cf71-c519-4d2e-b18b-3018eda12b25)

---
LINK FOR PRESENTATION 
https://docs.google.com/presentation/d/1XJtQJUTk_z_ZUVlHFtrc5zKWvdqH1UE4/edit?usp=drive_link&ouid=104581561560601617010&rtpof=true&sd=true
