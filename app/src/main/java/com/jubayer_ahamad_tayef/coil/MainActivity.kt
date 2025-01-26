package com.jubayer_ahamad_tayef.coil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.jubayer_ahamad_tayef.coil.ui.theme.CoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoilTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@Composable
fun CoilImage() {
    Box(modifier = Modifier.size(150.dp), contentAlignment = Alignment.Center) {
        val painter =
            rememberImagePainter(data = "https://avatars.githubusercontent.com/u/129745706?v=4",
                builder = {
                    placeholder(R.drawable.image_placeholder)
                    error(R.drawable.ic_error)
                    crossfade(1000)
                    transformations(
//                    GrayscaleTransformation(),
                        CircleCropTransformation(),
//                    BlurTransformation(LocalContext.current)
                    )
                })
        val painterState = painter.state
        Image(painter = painter, contentDescription = "My Image")
        if (painterState is ImagePainter.State.Loading) CircularProgressIndicator()
    }
}

@Preview(showSystemUi = true)
@Composable
fun CoilImagePreview() {
    CoilImage()
}