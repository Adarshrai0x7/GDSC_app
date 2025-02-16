package com.example.calculator2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.objecthunter.exp4j.ExpressionBuilder
import com.example.calculator2.ui.theme.CALCULATOR2Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CALCULATOR2Theme(darkTheme = true) { // Enable Dark Theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorUI()
                }
            }
        }
    }
}

@Composable
fun CalculatorUI() {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input Field
        BasicTextField(
            value = textFieldValue,
            onValueChange = {
                // Update text and force the cursor to the end of the input
                textFieldValue = it.copy(selection = TextRange(it.text.length))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 24.sp,
                textAlign = TextAlign.End,
                color = Color.White
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )

        // Calculator Buttons
        val buttons = listOf(
            listOf("(", ")", "C", "AC"),
            listOf("^", "tan", "cos", "sin"),
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", ".", "=", "+")
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            for (row in buttons) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (text in row) {
                        Button(
                            onClick = {
                                when (text) {
                                    "=" -> {
                                        // Evaluate the expression
                                        textFieldValue = TextFieldValue(evaluateExpression(textFieldValue.text))
                                    }
                                    "C" -> {
                                        // Remove the last character
                                        if (textFieldValue.text.isNotEmpty() && textFieldValue.text != "Error") {
                                            val newText = textFieldValue.text.dropLast(1)
                                            textFieldValue = TextFieldValue(newText, TextRange(newText.length))
                                        }
                                    }
                                    "AC" -> {
                                        // Clear all
                                        textFieldValue = TextFieldValue("")
                                    }
                                    else -> {
                                        // Clear "Error" if it's displayed, then add text to the end
                                        val newText = if (textFieldValue.text == "Error") text else textFieldValue.text + text
                                        textFieldValue = TextFieldValue(newText, TextRange(newText.length))
                                    }
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                        ) {
                            Text(text = text, fontSize = 18.sp)
                        }

                    }
                }
            }
        }
    }
}

// Function to evaluate expressions
fun evaluateExpression(expression: String): String {
    return try {
        // Preprocess the expression to handle `^` for power calculations
        val processedExpression = preprocessExpression(expression).replace("^", "**")

        val expressionBuilder = ExpressionBuilder(processedExpression).build()
        val result = expressionBuilder.evaluate()
        if (result.isInfinite() || result.isNaN()) {
            "Error"
        } else {
            result.toString()
        }
    } catch (e: Exception) {
        "Error"
    }
}



fun preprocessExpression(expression: String): String {
    // Insert "*" between numbers and parentheses where missing
    val regex = Regex("(?<=[0-9])(?=\\()|(?<=\\))(?=[0-9])")
    return regex.replace(expression, "*")
}


// Preview Function
@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CALCULATOR2Theme {
        CalculatorUI()
    }
}