package com.example.jetpackcomposepart1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepart1.ui.theme.JetpackComposePart1Theme
import com.example.jetpackcomposepart1.utils.User
import com.example.jetpackcomposepart1.utils.dummyData
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePart1Theme {
                //Scaffold
                CustomScaffold()

            }
        }
    }
}

@Composable
fun CustomScaffold() {
    Scaffold(
        //Top Bar
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "JetPack Compose")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) {
        initializeRecyclerView(users = dummyData())
    }
}

@Composable
fun loginScreen() {
    val userName = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Welcome To Login Screen",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName.value,
            onValueChange = {
                userName.value = it
            },
            label = { Text(text = "User Name") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "User Icon")
            }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName.value,
            onValueChange = {
                userName.value = it
            },
            label = { Text(text = "User Name") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "User Icon")
            }
        )

        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button")
        }
    }
}

@Composable
fun recyclerViewLayout(data: User) {
    Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp)) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = "Profile image",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(10.dp)
                    .size(80.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
            Text(text = data.description)
        }
    }
}

@Composable
fun initializeRecyclerView(users: List<User>) {
    LazyColumn {
        items(users) { user ->     //'users' will get data from list and pass single user to 'user'
            recyclerViewLayout(data = user)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePart1Theme {
        CustomScaffold()
    }
}