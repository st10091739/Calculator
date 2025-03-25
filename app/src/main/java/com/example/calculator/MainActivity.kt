package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.RoundingMode
import kotlin.math.abs
import kotlin.math.sqrt

/*
Commenting

 */
class MainActivity : AppCompatActivity() {

    // Initializing variables
    private var number1 : TextView? = null
    private var number2 : TextView? = null
    private var answer : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var days : Int = 4

        var number1 = findViewById<TextView>(R.id.number1)
        number2 = findViewById(R.id.number2)
        answer = findViewById(R.id.answer)

        //Initializing buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnSq = findViewById<Button>(R.id.btnSq)
        val btnPow = findViewById<Button>(R.id.btnPow)
        val btnStat = findViewById<Button>(R.id.btnStat)

        // declaring setOnClickListener
        btnAdd.setOnClickListener()
        {
            add()
        }
        btnSub.setOnClickListener()
        {
            subtract()
        }
        btnMul.setOnClickListener()
        {
            multiply()
        }
        btnDiv.setOnClickListener()
        {
            divide()
        }
        btnSq.setOnClickListener()
        {
            squareRoot()
        }
        btnPow.setOnClickListener()
        {
            power()
        }
        btnStat.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
            startActivity(intent)
        }
    }


    private fun add()
    {
        if (inputIsNotEmpty())
        {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} + ${number2?.text.toString().trim().toBigDecimal()} = ${input1.add(input2)}"
        }
    }

    private fun subtract()
    {
        if (inputIsNotEmpty())
        {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} - ${number2?.text.toString().trim().toBigDecimal()} = ${input1.subtract(input2)}"
        }
    }

    private fun multiply() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} * ${number2?.text.toString().trim().toBigDecimal()} = ${input1.multiply(input2)}"
        }
    }

    private fun squareRoot() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()

            if (input1 < ZERO) {
                answer?.text = "Sqr(${input1}) = ${
                    sqrt(
                        input1.abs().toDouble()
                    )
                }i and \n Sqr(${input2}) = ${sqrt(input2.toDouble())}"
            }else

                if (input2 < ZERO) {
                    answer?.text =
                        "Sqr(${input1}) = ${sqrt(input1.toDouble())} and \n Sqr(${input2}) = ${
                            sqrt(input2.abs().toDouble())
                        }i"
                }else

                    if (input1 < ZERO && input2 < ZERO) {
                        answer?.text = "Sqr(${input1}) = ${
                            sqrt(
                                input1.abs().toDouble()
                            )
                        }i and \n Sqr(${input2}) = ${sqrt(input2.abs().toDouble())}i"
                    }

            answer?.text =
                "Sqr(${input1}) = ${sqrt(input1.toDouble())} and \n Sqr(${input2}) = ${
                    sqrt(input2.toDouble())
                }"
        }
    }

    













    private fun power() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} ^ ${number2?.text.toString().trim().toBigDecimal()} = ${input1.pow(input2.toInt())}"
        }
    }

    private fun isNotZero(): Boolean {
        var c = true

        if(number2?.text.toString().trim().toBigDecimal() == ZERO) {
            number2?.error = "Cannot Divide by Zero!"
            c = false
        }
        return c
    }

    private fun divide(){

        if (inputIsNotEmpty())
        {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()

            if (isNotZero())
            {
                answer?.text = "${number1?.text.toString().trim().toBigDecimal()} / ${number2?.text.toString().trim().toBigDecimal()} = ${input1.divide(input2, 2,
                    RoundingMode.HALF_UP)}"
            }
        }
    }

    private fun inputIsNotEmpty(): Boolean
    {
        var b = true
        if (number1?.text.toString().trim().isEmpty())
        {
            number1?.error = "Required"
            b = false
        }
        if (number2?.text.toString().trim().isEmpty())
        {
            number2?.error = "Required"
            b = false
        }
        return b
    }
}



