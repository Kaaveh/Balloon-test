package ir.kaaveh.balloontest.ui.tooltip

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.kaaveh.balloontest.R

@Composable
fun TooltipButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: TooltipButtonType = TooltipButtonType.NEXT,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (type == TooltipButtonType.CLOSE) Color.Black else Color.DarkGray,
            disabledContainerColor = if (type == TooltipButtonType.CLOSE) Color.Black else Color.DarkGray,
            contentColor = Color.White,
            disabledContentColor = Color.White,
        ),
    ) {
        when (type) {
            TooltipButtonType.NEXT -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp),
                        tint = Color.White,
                    )
                    Text(
                        text = "بعدی",
                        color = Color.White,
                    )
                }
            }

            TooltipButtonType.PREVIOUS -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "قبلی",
                        color = Color.White,
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp),
                        tint = Color.White,
                    )
                }
            }

            TooltipButtonType.CLOSE -> {
                Text(
                    text = "بستن",
                    color = Color.White,
                )
            }
        }
    }
}

enum class TooltipButtonType {
    NEXT,
    PREVIOUS,
    CLOSE,
}

@Preview
@Composable
private fun TooltipButtonPrev() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TooltipButton(
                modifier = Modifier.weight(0.5F),
                onClick = {},
                type = TooltipButtonType.NEXT
            )
            Spacer(modifier = Modifier.width(16.dp))
            TooltipButton(
                modifier = Modifier.weight(0.5F),
                onClick = {},
                type = TooltipButtonType.CLOSE
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        TooltipButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            type = TooltipButtonType.PREVIOUS
        )
    }
}