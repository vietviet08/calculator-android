package com.vietquoc.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
            is CalculatorAction.Delete -> delete()
        }
    }

    private fun delete() {
        if (state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1.dropLast(1)
            )
            return
        }
        if (state.operation != null && state.number2.isNotBlank()) {
            state = state.copy(
                operation = null
            )
            return
        }
        if (state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            return
        }
    }

    private fun calculate() {
        val number1: Double? = state.number1.toDoubleOrNull()
        val number2: Double? = state.number2.toDoubleOrNull()

        if (number1 != null && number2 != null) {
            when (state.operation) {
                is CalculatorOperation.Add -> {
                    state = state.copy(
                        number1 = (state.number1.toDouble() + state.number2.toDouble()).toString().take(15),
                        number2 = "",
                        operation = null
                    )
                }

                is CalculatorOperation.Subtract -> {
                    state = state.copy(
                        number1 = (state.number1.toDouble() - state.number2.toDouble()).toString().take(15),
                        number2 = "",
                        operation = null
                    )
                }

                is CalculatorOperation.Multiply -> {
                    state = state.copy(
                        number1 = (state.number1.toDouble() * state.number2.toDouble()).toString().take(15),
                        number2 = "",
                        operation = null
                    )
                }

                is CalculatorOperation.Divide -> {
                    state = state.copy(
                        number1 = (state.number1.toDouble() / state.number2.toDouble()).toString().take(15),
                        number2 = "",
                        operation = null
                    )
                }

                null -> return
            }
        }
    }

    private fun enterDecimal() {
        if (!state.number1.contains(".") && state.number1.isNotBlank() && state.operation == null) {
            state = state.copy(
                number1 = state.number1 + "."
            )
        } else if (!state.number2.contains(".") && state.number2.isNotBlank() && state.operation != null) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) return
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) return

        state = state.copy(
            number2 = state.number2 + number
        )
        return
    }

    companion object {
        private val MAX_NUM_LENGTH = 8
    }
}