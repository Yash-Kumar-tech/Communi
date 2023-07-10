package com.yashkumartech.communi.presentation.GroupChatScreen

import androidx.lifecycle.ViewModel
import com.yashkumartech.communi.util.ChatObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GroupChatScreenViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(GroupChatScreenState())
    val state: StateFlow<GroupChatScreenState> = _state

    fun changeGroup(newIndex: Int) {
        _state.value = _state.value.copy(currGroupIndex = newIndex)
    }

    fun getChats(): List<ChatObject> {
        //Write the view model to get chats based on what group is selected.

        return listOf(
            ChatObject(
                sender = "Sender A",
                content = "Message ${_state.value.currGroupIndex}",
                timeSent = "08:24",
                dateSent = "08/07/2023"
            ),
            ChatObject(
                sender = "Sender B",
                content = "Chats look like this ${_state.value.currGroupIndex}",
                timeSent = "08:56",
                dateSent = "08/07/2023"
            )
        )
    }

    fun toggleView() {
        if(_state.value.screenState == ScreenStates.CHAT) {
            _state.value = _state.value.copy(screenState = ScreenStates.CHANNELS)
        } else {
            _state.value = _state.value.copy(screenState = ScreenStates.CHAT)
        }
    }

    fun getChannels(): List<String> {
        return listOf(
            "# Channel 1",
            "# Channel 2",
            "# Channel 3"
        )
    }
}