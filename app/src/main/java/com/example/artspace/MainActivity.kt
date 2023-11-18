package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}
var indice = 0
@Composable
fun ArtSpaceLayout() {
    //Variables
    var imagedpy by remember { mutableStateOf(1) }
    val imageResource = when (imagedpy) {
        1 -> R.drawable.image1
        2 -> R.drawable.image2
        3 -> R.drawable.image3
        4 -> R.drawable.image4
        5 -> R.drawable.image5
        6 -> R.drawable.image6
        7 -> R.drawable.image7
        8 -> R.drawable.image8
        else -> R.drawable.image1
    }
    var namedpy by remember { mutableStateOf(1) }
    val imageName = when (namedpy) {
        1 -> R.string.Name1
        2 -> R.string.Name2
        3 -> R.string.Name3
        4 -> R.string.Name4
        5 -> R.string.Name5
        6 -> R.string.Name6
        7 -> R.string.Name7
        8 -> R.string.Name8
        else -> R.string.Name1
    }
    var descdpy by remember { mutableStateOf(1) }
    val imageDesc = when (descdpy) {
        1 -> R.string.Descrip1
        2 -> R.string.Descrip2
        3 -> R.string.Descrip3
        4 -> R.string.Descrip4
        5 -> R.string.Descrip5
        6 -> R.string.Descrip6
        7 -> R.string.Descrip7
        8 -> R.string.Descrip8
        else -> R.string.Descrip1
    }


    Column(modifier = Modifier
        .padding(40.dp, 0.dp, 40.dp, 0.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly) {
        Box(
            modifier = Modifier
                .padding(20.dp, 40.dp, 20.dp, 20.dp)
                .align(Alignment.CenterHorizontally)
                .shadow(5.dp, RectangleShape, clip = true, Color.Black)
        ) {
            //Image + Description + Buttons in column

            Box(
                modifier = Modifier
                    .padding(30.dp)
            ) {
                //Image Box
                Box(
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = namedpy.toString()
                        )
                    }
                }

            }
        }
        //Title + Descripcion Box
        Box(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.description))
        ) {
            Column(
                modifier = Modifier
                    //.fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = stringResource(id = imageName),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Text(text = stringResource(id = imageDesc))
            }
        }

        //Buttons Box
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(0.dp, 20.dp, 0.dp, 0.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround){
                Button(onClick = {
                    imagedpy--
                    namedpy--
                    descdpy--

                }, enabled = (1<imagedpy)) {
                    Text(stringResource(R.string.Prev))
                }
                Button(onClick = {
                    imagedpy++
                    namedpy++
                    descdpy++
                }, enabled = (imagedpy<8)) {
                    Text(stringResource(R.string.Next))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}