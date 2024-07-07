package com.example.calculatorhwgridlayouttablelayout

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var operandOne = 0.0
    private var operandTwo = 0.0
    private var operator = ""
    private val input: MutableList<String> = mutableListOf()

    private lateinit var titleTB: Toolbar

    private lateinit var inputET: EditText

    private lateinit var resultTV: TextView

    private lateinit var divButtonBTN: Button
    private lateinit var oneButtonBTN: Button
    private lateinit var twoButtonBTN: Button
    private lateinit var threeButtonBTN: Button
    private lateinit var multButtonBTN: Button
    private lateinit var fourButtonBTN: Button
    private lateinit var fiveButtonBTN: Button
    private lateinit var sixButtonBTN: Button
    private lateinit var difButtonBTN: Button
    private lateinit var sevenButtonBTN: Button
    private lateinit var eightButtonBTN: Button
    private lateinit var nineButtonBTN: Button
    private lateinit var addButtonBTN: Button
    private lateinit var zeroButtonBTN: Button
    private lateinit var equalsButtonBTN: Button
    private lateinit var resetButtonBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {

        var stroke = ""
        var result = ""
        when (v.id) {
            R.id.oneButtonBTN -> {
                if (input.contains("=")) return
                input.add("1")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.twoButtonBTN -> {
                if (input.contains("=")) return
                input.add("2")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.threeButtonBTN -> {
                if (input.contains("=")) return
                input.add("3")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.fourButtonBTN -> {
                if (input.contains("=")) return
                input.add("4")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.fiveButtonBTN -> {
                if (input.contains("=")) return
                input.add("5")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.sixButtonBTN -> {
                if (input.contains("=")) return
                input.add("6")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.sevenButtonBTN -> {
                if (input.contains("=")) return
                input.add("7")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.eightButtonBTN -> {
                if (input.contains("=")) return
                input.add("8")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.nineButtonBTN -> {
                if (input.contains("=")) return
                input.add("9")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.zeroButtonBTN -> {
                if (input.contains("=")) return
                input.add("0")
                stroke = input.joinToString("")
                inputET.setText(stroke)
            }

            R.id.addButtonBTN -> {
                input.toString().forEach { element ->
                    when (element) {
                        '+' -> return
                        '-' -> return
                        '*' -> return
                        '/' -> return
                        '=' -> return
                    }
                }
                if (input.isEmpty()) return
                input.add("+")
                stroke = input.joinToString("")
                inputET.setText(stroke)
                operator = "+"
            }

            R.id.difButtonBTN -> {
                input.toString().forEach { element ->
                    when (element) {
                        '+' -> return
                        '-' -> return
                        '*' -> return
                        '/' -> return
                        '=' -> return
                    }
                }
                if (input.isEmpty()) return
                input.add("-")
                stroke = input.joinToString("")
                inputET.setText(stroke)
                operator = "-"
            }

            R.id.multButtonBTN -> {
                input.toString().forEach { element ->
                    when (element) {
                        '+' -> return
                        '-' -> return
                        '*' -> return
                        '/' -> return
                        '=' -> return
                    }
                }
                if (input.isEmpty()) return
                input.add("*")
                stroke = input.joinToString("")
                inputET.setText(stroke)
                operator = "*"
            }

            R.id.divButtonBTN -> {
                input.toString().forEach { element ->
                    when (element) {
                        '+' -> return
                        '-' -> return
                        '*' -> return
                        '/' -> return
                        '=' -> return
                    }
                }
                if (input.isEmpty()) return
                input.add("/")
                stroke = input.joinToString("")
                inputET.setText(stroke)
                operator = "/"
            }

            R.id.equalsButtonBTN -> {
                if (input.contains("=") || input.isEmpty()) return
                val operand = input.toString().split("+", "-", "*", "/")
                if (operand[1].none { it.isDigit() }) return
                input.add("=")
                stroke = input.joinToString("")
                inputET.setText(stroke)
                operandOne = operand[0].filter { it.isDigit() }.toDouble()
                operandTwo = operand[1].filter { it.isDigit() }.toDouble()

                result =  when (operator) {
                    "+" -> (Operator(operandOne, operandTwo).add()).toString()
                    "-" -> (Operator(operandOne, operandTwo).dif()).toString()
                    "*" -> (Operator(operandOne, operandTwo).mult()).toString()
                    "/" -> {
                        if(operandTwo == 0.0) {
                            "Ошибка! На ноль делить нельзя!"
                        }else (Operator(operandOne, operandTwo).div()).toString()
                    } else -> ""
                }
                resultTV.text = result
            }

            R.id.resetButtonBTN -> {
                input.clear()
                inputET.text.clear()
                resultTV.text = ""
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    fun init() {
        setContentView(R.layout.activity_main)
        titleTB = findViewById(R.id.titleTB)
        setSupportActionBar(titleTB)
        title = "\tКалькулятор"
        titleTB.setLogo(R.drawable.ic_calculator)
        titleTB.setTitleTextColor(Color.WHITE)

        inputET = findViewById(R.id.inputET)
        inputET.isEnabled = false

        resultTV = findViewById(R.id.resultTV)

        divButtonBTN = findViewById(R.id.divButtonBTN)
        divButtonBTN.setOnClickListener(this)
        oneButtonBTN = findViewById(R.id.oneButtonBTN)
        oneButtonBTN.setOnClickListener(this)
        twoButtonBTN = findViewById(R.id.twoButtonBTN)
        twoButtonBTN.setOnClickListener(this)
        threeButtonBTN = findViewById(R.id.threeButtonBTN)
        threeButtonBTN.setOnClickListener(this)
        fourButtonBTN = findViewById(R.id.fourButtonBTN)
        fourButtonBTN.setOnClickListener(this)
        fiveButtonBTN = findViewById(R.id.fiveButtonBTN)
        fiveButtonBTN.setOnClickListener(this)
        sixButtonBTN = findViewById(R.id.sixButtonBTN)
        sixButtonBTN.setOnClickListener(this)
        sevenButtonBTN = findViewById(R.id.sevenButtonBTN)
        sevenButtonBTN.setOnClickListener(this)
        eightButtonBTN = findViewById(R.id.eightButtonBTN)
        eightButtonBTN.setOnClickListener(this)
        nineButtonBTN = findViewById(R.id.nineButtonBTN)
        nineButtonBTN.setOnClickListener(this)
        difButtonBTN = findViewById(R.id.difButtonBTN)
        difButtonBTN.setOnClickListener(this)
        addButtonBTN = findViewById(R.id.addButtonBTN)
        addButtonBTN.setOnClickListener(this)
        zeroButtonBTN = findViewById(R.id.zeroButtonBTN)
        zeroButtonBTN.setOnClickListener(this)
        equalsButtonBTN = findViewById(R.id.equalsButtonBTN)
        equalsButtonBTN.setOnClickListener(this)
        resetButtonBTN = findViewById(R.id.resetButtonBTN)
        resetButtonBTN.setOnClickListener(this)
        multButtonBTN = findViewById(R.id.multButtonBTN)
        multButtonBTN.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.exitMenu) finish()
        return super.onOptionsItemSelected(item)
    }

}