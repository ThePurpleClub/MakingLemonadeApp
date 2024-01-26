package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //WelcomeScreen("Hi")
            LemonApp()
        }
    }
}

@Composable
fun LemonApp() {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }
    var randomSqueeze by remember { mutableStateOf(0) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(

                        contentDescription = stringResource(R.string.lemon_tree),
                        painter = painterResource(R.drawable.lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                                randomSqueeze = (2..4).random()
                            }// generate how many lemons you are going to squeeze
                    )
                    Text(text = stringResource(R.string.lemon_tree))
                }
            }

            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.squeeze_lemon),
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentSize()
                            .clickable {
                                randomSqueeze--
                                if (randomSqueeze == 0)
                                    currentStep = 3
                            }
                    )
                    Text(text = stringResource(R.string.squeeze_lemon))
                }
            }

            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.lemon_juice),
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                    Text(text = stringResource(R.string.lemon_juice))
                }

            }

            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(
                        modifier = Modifier.height(32.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.lemon_glass),
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                    )
                    Text(text = stringResource(R.string.lemon_glass))
                }
            }

            else -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(
                        modifier = Modifier.height(32.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                    )
                    Text(text = stringResource(R.string.lemon_tree))
                }

            }

        }

    }
}


@Composable
fun LemonTextAndImageApp(
    painterID : Int,
    contentDescriptionId: Int,
    onStartClick: () -> Unit,
    modifier: Modifier = Modifier){

    Box(Modifier.fillMaxWidth()) {
        Column(Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Button(
                onClick = onStartClick,
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Image(
                    painter = painterResource(painterID),
                    contentDescription = stringResource(contentDescriptionId),
                    modifier = Modifier
                        .width(15.dp)
                        .height(15.dp)
                        .padding(15.dp)
                )
            }
        }
    }
}

