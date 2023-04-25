package ir.kaaveh.balloontest.ui.tooltip

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.kaaveh.balloontest.R

@Composable
fun Tooltip(
    title: String,
    description: String,
    counter: Int,
    allCount: Int,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onDismiss: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .border(
                border = BorderStroke(width = 1.dp, Color.Yellow),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier
                    .size(12.dp)
                    .clickable { onDismiss() },
                tint = Color.White,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "$counter/$allCount",
                color = Color.White,
            )
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier.weight(1F),
                textAlign = TextAlign.Right,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = description,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            TooltipButton(
                modifier = Modifier.weight(0.5F),
                onClick = {
                    if (counter == allCount) onDismiss() else onNext()
                },
                type = if (counter == allCount) TooltipButtonType.CLOSE else TooltipButtonType.NEXT
            )
            Spacer(modifier = Modifier.width(16.dp))
            TooltipButton(
                modifier = Modifier.weight(0.5F),
                onClick = {
                    if (counter == 1) onDismiss() else onPrevious()
                },
                type = if (counter == 1) TooltipButtonType.CLOSE else TooltipButtonType.PREVIOUS
            )
        }
    }
}

@Preview
@Composable
private fun TooltipPrev() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Tooltip(
            title = stringResource(id = R.string.tooltip_title),
            description = stringResource(id = R.string.tooltip_des),
            counter = 1,
            allCount = 3,
            onNext = {},
            onPrevious = {},
            onDismiss = {},
        )
    }
}