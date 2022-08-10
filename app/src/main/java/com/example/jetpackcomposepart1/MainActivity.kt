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
import androidx.compose.runtime.saveable.rememberSaveable
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
        StateManagementFun()
    }
}

/**
 * STATE- MANAGEMENT
 * */

@Composable
fun StateManagementFun() {
    val message = rememberSaveable {       //rememberSaveAble means value will not destroy on rotation
        mutableStateOf("")
    }

    Column {
        Text(text = "${message.value}")

        OutlinedTextField(value = message.value, onValueChange = {
            message.value = it    //this onValueChange will update the value the Observer and
            //save value to "message" at the same time
        })
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePart1Theme {
        CustomScaffold()
    }
}