package com.example.fcmnotification.calculator

class Calculator(private val mathOperations: MathOperations) {
    fun addTwoNumbers(a: Int, b: Int): Int = mathOperations.add(a, b)
    fun subtractTwoNumbers(a: Int, b: Int): Int = mathOperations.subtract(a, b)
    fun multiplyTwoNumbers(a: Int, b: Int): Int = mathOperations.multiply(a, b)
    fun divideTwoNumbers(a: Int, b: Int): Int = mathOperations.divide(a, b)
}