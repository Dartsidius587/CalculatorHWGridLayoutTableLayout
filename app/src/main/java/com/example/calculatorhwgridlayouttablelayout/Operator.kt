package com.example.calculatorhwgridlayouttablelayout

class Operator(private val operandOne: Double, private val operandTwo: Double) {

    fun add() = operandOne + operandTwo
    fun dif() = operandOne - operandTwo
    fun mult() = operandOne * operandTwo
    fun div() = operandOne / operandTwo
}