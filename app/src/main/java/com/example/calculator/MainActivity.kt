package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var enteredText: EditText?= null
    private var equation: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnClear: Button = findViewById(R.id.btnClear)

        enteredText = findViewById(R.id.enterNumber)
        equation = findViewById(R.id.equationText)


        btnAdd.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                DoOperation("+")
            }
        })

        btnSubtract.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                DoOperation("-")
            }
        })

        btnMultiply.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                DoOperation("*")
            }
        })

        btnDivide.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                DoOperation("/")
            }
        })

        btnClear.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Clear()
            }
        })
    }

    private fun DoOperation(operator: String) {
        var newNumber = enteredText?.text.toString()

        if (newNumber == "") {
            return //add message later
        }
        else if (equation?.text.toString() == null || equation?.text.toString() == "") {
            equation?.text = newNumber
        }
        else {
            if (operator == "+") {
                Add(newNumber)
            }
            else if (operator == "-") {
                Subtract(newNumber)
            }
            else if (operator == "*") {
                Multiple(newNumber)
            }
            else if (operator == "/") {
                Divide(newNumber)
            }
        }

        enteredText?.text?.clear()
    }

    private fun Add(valueToAdd: String) {
        var previousValue = equation?.text.toString().toDouble()
        var newPart = valueToAdd.toDouble()

        equation?.text = (previousValue + newPart).toString()
    }

    private fun Subtract(valueToSubtract: String) {
        var previousValue = equation?.text.toString().toDouble()
        var newPart = valueToSubtract.toDouble()

        equation?.text = (previousValue - newPart).toString()
    }

    private fun Multiple(valueToMultiply: String) {
        var previousValue = equation?.text.toString().toDouble()
        var newPart = valueToMultiply.toDouble()

        equation?.text = (previousValue * newPart).toString()
    }

    private fun Divide(valueToDivide: String) {
        var previousValue = equation?.text.toString().toDouble()
        var newPart = valueToDivide.toDouble()

        equation?.text = (previousValue / newPart).toString()
    }

    private fun Clear() {
        equation?.text = ""
    }
}
