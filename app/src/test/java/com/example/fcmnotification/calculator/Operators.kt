package com.example.fcmnotification.calculator

object Operators : MathOperations {
    override fun add(m: Int, n: Int): Int = m + n
    override fun subtract(n: Int, m: Int): Int = n - m
    override fun multiply(c: Int, a: Int): Int = c * a
    override fun divide(l: Int, d: Int): Int = l / d
}