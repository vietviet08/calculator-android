package com.vietquoc.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vietquoc.calculator.ui.theme.CalculatorTheme
import com.vietquoc.calculator.ui.theme.LightGray
import com.vietquoc.calculator.ui.theme.MediumGray
import com.vietquoc.calculator.ui.theme.Orange
import kotlin.reflect.KFunction1

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {

                MainCalculator()
            }
        }
    }
}

@Composable
fun MainCalculator() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonSpacing: Dp = 8.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
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
                state = state,
                buttonSpacing = buttonSpacing,
                onAction = viewModel::onAction
            )
        }
    }
}

@Composable
fun CalculatorTextField(state: CalculatorState) {
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
fun CalculatorGrid(
    state: CalculatorState,
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
            color = LightGray,
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f),
        ) {
            onAction(CalculatorAction.Clear)
        }
        CalculatorButton(
            symbol = "Del",
            color = LightGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Delete)
        }
        CalculatorButton(
            symbol = "/",
            color = Orange,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
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
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(7))
        }
        CalculatorButton(
            symbol = "8",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(8))
        }
        CalculatorButton(
            symbol = "9",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(9))
        }
        CalculatorButton(
            symbol = "x",
            color = Orange,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
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
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(4))
        }
        CalculatorButton(
            symbol = "5",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(5))
        }
        CalculatorButton(
            symbol = "6",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(6))
        }
        CalculatorButton(
            symbol = "-",
            color = Orange,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
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
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(1))
        }
        CalculatorButton(
            symbol = "2",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(2))
        }
        CalculatorButton(
            symbol = "3",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Number(3))
        }
        CalculatorButton(
            symbol = "+",
            color = Orange,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
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
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f)
        ) {
            onAction(CalculatorAction.Number(0))
        }
        CalculatorButton(
            symbol = ".",
            color = MediumGray,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Decimal)
        }
        CalculatorButton(
            symbol = "=",
            color = Orange,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)
        ) {
            onAction(CalculatorAction.Calculate)
        }
    }
}
