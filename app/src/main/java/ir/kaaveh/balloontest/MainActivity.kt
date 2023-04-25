package ir.kaaveh.balloontest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.compose.setArrowColor
import com.skydoves.balloon.compose.setOverlayColor
import com.skydoves.balloon.overlay.BalloonOverlayRect
import ir.kaaveh.balloontest.ui.theme.BalloonTestTheme
import ir.kaaveh.balloontest.ui.tooltip.Tooltip

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BalloonTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @Composable
    fun Greeting() {

        val builder = rememberBalloonBuilder {
            setArrowSize(8)
            setArrowPositionRules(ArrowPositionRules.ALIGN_BALLOON)
            setArrowPosition(0.5f)
            setHeight(BalloonSizeSpec.WRAP)
//            setWidth(BalloonSizeSpec.WRAP)
//            setWidthRatio(0.5f)
//            setWidth(200)
//            setMinWidth(3)
//            setMaxWidth(4)
            setWidthRatio(0.5f)

            setArrowColor(Color.Yellow)
            setMargin(12)
            setCornerRadius(8f)
            setOverlayPadding(8F)
            setBalloonAnimation(BalloonAnimation.FADE)
            setIsVisibleOverlay(true)
            setOverlayColor(Color.Black.copy(alpha = 0.7F))
            setOverlayShape(BalloonOverlayRect)
            setDismissWhenTouchOutside(false)
            setDismissWhenOverlayClicked(false)
            setDismissWhenClicked(false)
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(16.dp)
        ) {
            Balloon(
                modifier = Modifier
                    .weight(1F),
                builder = builder,
                balloonContent = {
                    Tooltip(
                        title = stringResource(id = R.string.tooltip_title),
                        description = stringResource(id = R.string.tooltip_des),
                        counter = viewModel.tooltipState.value,
                        allCount = viewModel.tooltipSize,
                        onNext = { viewModel.onTooltipNext() },
                        onPrevious = { viewModel.onTooltipPrevious() },
                        onDismiss = { viewModel.onTooltipDismissed() },
                    )
                }
            ) { balloonWindow ->
                LaunchedEffect(key1 = viewModel.tooltipState.value) {
                    if (viewModel.tooltipState.value == 1) {
                        builder.setArrowOrientation(ArrowOrientation.END)
                        balloonWindow.showAlignRight()
                    } else
                        balloonWindow.dismiss()
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .background(Color.Red)
                ) {}
            }
            Balloon(
                modifier = Modifier
                    .weight(2F),
                builder = builder,
                balloonContent = {
                    Tooltip(
                        title = stringResource(id = R.string.tooltip_title),
                        description = stringResource(id = R.string.tooltip_des),
                        counter = viewModel.tooltipState.value,
                        allCount = viewModel.tooltipSize,
                        onNext = { viewModel.onTooltipNext() },
                        onPrevious = { viewModel.onTooltipPrevious() },
                        onDismiss = { viewModel.onTooltipDismissed() },
                    )
                }
            ) { balloonWindow ->
                LaunchedEffect(key1 = viewModel.tooltipState.value) {
                    if (viewModel.tooltipState.value == 2) {
                        builder.setArrowOrientation(ArrowOrientation.START)
                        balloonWindow.showAlignLeft()
                    } else
                        balloonWindow.dismiss()
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .background(Color.Yellow)
                ) {}
            }
        }
    }
}