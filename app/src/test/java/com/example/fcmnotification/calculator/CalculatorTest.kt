package com.example.fcmnotification.calculator

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.Test

@RunWith(MockitoJUnitRunner::class)
class CalculatorTest {

    @Mock
    private lateinit var mockMathOperations: MathOperations

    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        calculator = Calculator(mockMathOperations)
    }

    @Test
    fun given_valid_input_when_add_should_call_add_operator() {
        val a = 10
        val b = 20
        calculator.addTwoNumbers(a, b)
        verify(mockMathOperations).add(a, b)
    }

    @Test
    fun given_valid_input_when_subtract_should_call_subtract_operator() {
        val a = 30
        val b = 10
        calculator.subtractTwoNumbers(a, b)
        verify(mockMathOperations).subtract(a, b)
    }

    @Test
    fun given_valid_input_when_multiply_should_call_multiply_operator() {
        val a = 5
        val b = 4
        calculator.multiplyTwoNumbers(a, b)
        verify(mockMathOperations).multiply(a, b)
    }

    @Test
    fun given_valid_input_when_divide_should_call_divide_operator() {
        val a = 20
        val b = 5
        calculator.divideTwoNumbers(a, b)
        verify(mockMathOperations).divide(a, b)
    }
}