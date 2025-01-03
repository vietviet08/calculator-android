package com.vietquoc.calculator.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vietquoc.calculator.store.CalculatorAction
import com.vietquoc.calculator.ui.compose.CalculatorButton
import com.vietquoc.calculator.store.CalculatorOperation
import com.vietquoc.calculator.store.CalculatorState
import com.vietquoc.calculator.vm.CalculatorViewModel
import com.vietquoc.calculator.ui.theme.Green
import com.vietquoc.calculator.ui.theme.LightGray
import com.vietquoc.calculator.ui.theme.MediumGray
import com.vietquoc.calculator.ui.theme.Red
import kotlin.reflect.KFunction1


@Composable
fun CalculatorScreen() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonSpacing: Dp = 8.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorTextField(
                state = state
            )

            CalculatorGrid(
                buttonSpacing = buttonSpacing,
                onAction = viewModel::onAction
            )
        }
    }
}

@Composable
private fun CalculatorTextField(state: CalculatorState) {
    Text(
        text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        fontSize = 80.sp,
        fontWeight = FontWeight.Light,
        maxLines = 2,
        lineHeight = 80.sp,
        textAlign = TextAlign.End
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun CalculatorGrid(
    buttonSpacing: Dp,
    onAction: KFunction1<CalculatorAction, Unit>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "AC",
            backgroundColor = LightGray,
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f),
            textColor = Red
        ) {
            onAction(CalculatorAction.Clear)
        }
        CalculatorButton(
            symbol = "Del",
            backgroundColor = LightGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            textColor = Red
        ) {
            onAction(CalculatorAction.Delete)
        }
        CalculatorButton(
            symbol = "/",
            backgroundColor = LightGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            textColor = Green,
            textStyle = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 60.sp
            )

        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "7",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(7))
        }
        CalculatorButton(
            symbol = "8",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(8))
        }
        CalculatorButton(
            symbol = "9",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(9))
        }
        CalculatorButton(
            symbol = "x",
            backgroundColor = LightGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            textColor = Green,
            textStyle = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 60.sp
            )
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "4",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(4))
        }
        CalculatorButton(
            symbol = "5",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(5))
        }
        CalculatorButton(
            symbol = "6",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(6))
        }
        CalculatorButton(
            symbol = "-",
            backgroundColor = LightGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            textColor = Green,
            textStyle = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 60.sp
            )
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "1",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(1))
        }
        CalculatorButton(
            symbol = "2",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(2))
        }
        CalculatorButton(
            symbol = "3",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(3))
        }
        CalculatorButton(
            symbol = "+",
            backgroundColor = LightGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            textColor = Green,
            textStyle = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 60.sp
            )
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            symbol = "0",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f)
        ) {
            onAction(CalculatorAction.Number(0))
        }
        CalculatorButton(
            symbol = ".",
            backgroundColor = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Decimal)
        }
        CalculatorButton(
            symbol = "=",
            backgroundColor = Green,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            textStyle = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 60.sp
            )
        ) {
            onAction(CalculatorAction.Calculate)
        }
    }
}
