package com.yashkumartech.communi.presentation.GroupChatScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupChatScreen(
    modifier: Modifier = Modifier,
    groupChatScreenViewModel: GroupChatScreenViewModel = hiltViewModel()
) {
    val state by groupChatScreenViewModel.state.collectAsState()
    var chats = groupChatScreenViewModel.getChats()
    var channels = groupChatScreenViewModel.getChannels()

    LaunchedEffect(key1 = state.currGroupIndex) {
        chats = groupChatScreenViewModel.getChats()
    }

    return Row(
        modifier = modifier,
    ) {
        GroupsBar(
            selectedGroupIndex = state.currGroupIndex,
            onChangeGroup = { newIndex ->
                groupChatScreenViewModel.changeGroup(newIndex)
            }
        )
        Spacer(modifier = Modifier.width(4.dp))
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = {
                        Text(state.groups[state.currGroupIndex])
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                groupChatScreenViewModel.toggleView()
                                Log.d("Press", "Changing the view")
                            }
                        ) {
                            Icon(Icons.Rounded.Menu, contentDescription = "View Channels")
                        }
                    }
                )
            },
        ) { innerPadding ->
            if(state.screenState == ScreenStates.CHAT) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .weight(0.8f),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        items(chats.size) { index ->
                            ChatBubble(
                                chats[index],
                                sentByUser = index % 2 == 0
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    ChatBox()
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(start = 16.dp, top = 8.dp)
                ) {
                    items(channels) {channel ->
                        Text(channel)
                    }
                }
            }
        }
    }
}