package com.example.ej3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.ej3.ui.theme.EJ3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EJ3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Ej3()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ej3(){

    var contComment by remember { mutableStateOf(1) }
    var contTwits by remember { mutableStateOf(1) }
    var contLikes by remember { mutableStateOf(1) }
    var onClickIconComment by remember { mutableStateOf(false) }
    var onClickIconTwits by remember { mutableStateOf(false) }
    var onClickIconLikes by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF161D26))
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Perfil",
                    modifier = Modifier.size(50.dp))
                Column(modifier = Modifier
                    .padding(20.dp)){
                    Row(modifier = Modifier
                        .fillMaxWidth()){
                        Text(text = "Blanca", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(end = 10.dp))
                        Text(text = "@BlancaDev", fontWeight = FontWeight.Medium, color = Color.LightGray, modifier = Modifier.padding(end = 10.dp))
                        Text(text = "6h", fontWeight = FontWeight.Medium, color = Color.LightGray)
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(painter = painterResource(id = R.drawable.ic_dots), contentDescription = "options", tint = Color.White)
                    }
                    Text(text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Architecto facere magni, animi adipisci, nesciunt modi vero impedit exercitationem debitis perspiciatis error quod praesentium illum dolor nulla dolorum quis quas esse!", color = Color.White, modifier = Modifier.padding(top = 5.dp))
                    Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Imagen", modifier = Modifier.padding(top = 5.dp))
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)){
                        Icon(
                            painter = if (onClickIconComment) painterResource(id = R.drawable.ic_chat_filled) else painterResource(id = R.drawable.ic_chat),
                            contentDescription = "comentarios",
                            tint = Color.LightGray,
                            modifier = Modifier
                                .clickable {
                                    onClickIconComment = !onClickIconComment
                                    if (onClickIconComment) {
                                        contComment++
                                    } else {
                                        contComment--
                                    }
                                }
                        )
                        Text(text = contComment.toString(), color = Color.LightGray)
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "Retwits",
                            tint = if (onClickIconTwits) Color.Green else Color.LightGray,
                            modifier = Modifier
                                .clickable {
                                    onClickIconTwits = !onClickIconTwits
                                    if (onClickIconTwits) {
                                        contTwits++
                                    } else {
                                        contTwits--
                                    }
                                }
                        )
                        Text(text = contTwits.toString(), color = Color.LightGray)
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = if (onClickIconLikes) painterResource(id = R.drawable.ic_like_filled) else painterResource(id = R.drawable.ic_like),
                            contentDescription = "Likes",
                            tint = if (onClickIconLikes) Color.Red else Color.LightGray,
                            modifier = Modifier
                                .clickable {
                                    onClickIconLikes = !onClickIconLikes
                                    if (onClickIconLikes) {
                                        contLikes++
                                    } else {
                                        contLikes--
                                    }
                                }
                        )
                        Text(text = contLikes.toString(), color = Color.LightGray)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}