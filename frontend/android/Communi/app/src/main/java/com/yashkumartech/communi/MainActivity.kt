package com.yashkumartech.communi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yashkumartech.communi.presentation.GroupChatScreen.GroupChatScreen
import com.yashkumartech.communi.presentation.GroupChatScreen.GroupChatScreenViewModel
import com.yashkumartech.communi.ui.theme.CommuniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommuniTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val groupChatScreenViewModel = hiltViewModel<GroupChatScreenViewModel>()
                    GroupChatScreen(
                        modifier = Modifier.padding(4.dp),
                        groupChatScreenViewModel
                    )
                }
            }
        }
    }
}
