package com.example.myapplication.chapterOne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, FragmentOne())
            .commit()*/

        /* setContent {
            //previewSomething()
            //columnsAndRows()
            //firstExample()
        }*/
    }


    @Composable
    fun previewSomething() {
        ScrollableColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF2F2F2))
        ) {
            Image(
                bitmap = imageFromResource(
                    res = resources,
                    resId = R.drawable.test_image
                ),
                ""
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Hello Wold",
                    style = TextStyle(
                        fontSize = TextUnit.Companion.Sp(26)
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    "This is a text for a simple app",
                    style = TextStyle(
                        fontSize = TextUnit.Companion.Sp(10),
                        color = Color.Magenta
                    )
                )
                Button(onClick = { }) {
                    Text(text = "Click me")
                }
            }
        }
    }

    @Composable
    fun columnsAndRows() {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello 1",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello 2",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

    }

    @Preview
    @Composable
    fun firstExample() {
        ScrollableColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF2F2F2))
        ) {
            Image(
                bitmap = imageFromResource(
                    res = resources,
                    resId = R.drawable.test_image
                ),
                ""
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "This is a title",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(26)
                        )
                    )
                    Text(
                        "$123",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(20)
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    "This is a text for a simple app",
                    style = TextStyle(
                        fontSize = TextUnit.Companion.Sp(10),
                        color = Color.Magenta
                    )
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Button(
                    onClick = { },
                    Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Click me")
                }
            }
        }
    }
}
