package com.example.myapplication.chapterOne

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class ExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewExample()
        }
    }

    @Preview
    @Composable
    fun PreviewExample(){
        Column(modifier = Modifier.fillMaxSize()) {
            ColumnExample()
            RowExample()
            Row {
                TextExample()
                Spacer(modifier = Modifier.padding(10.dp))
                ButtonExample()
            }
        }
    }
















    @Composable
    fun ButtonExample() {
        val context = AmbientContext.current
        Button(onClick = {
            showMessage(
                context,
                "Hello click button")
        }) {
            Text(text = "Click me")
        }
    }

    fun showMessage(context: Context, message:String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun ImageExample() {
        Image(
            bitmap = imageFromResource(
                res = resources,
                resId = R.drawable.test_image
            ),
            ""
        )
    }

    @Composable
    fun TextExample() {
        Text(
            text = "Hello Globant"
        )
    }

    @Composable
    fun ColumnExample() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello Globant",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Hello Globant",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }

    @Composable
    fun RowExample() {
        Row(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello Globant",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Hello Globant",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}