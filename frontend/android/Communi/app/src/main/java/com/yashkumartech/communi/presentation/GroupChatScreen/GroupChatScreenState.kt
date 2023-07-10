package com.yashkumartech.communi.presentation.GroupChatScreen

data class GroupChatScreenState(
    val uid: String = "UID",
    val userName: String = "userName",
    var currGroup: String = "GroupName",
    var currGroupIndex: Int = 0,
    var screenState: ScreenStates = ScreenStates.CHAT,
    var groups: List<String> = List(3) { index -> "Group $index" },
)

enum class ScreenStates {
    CHAT,
    CHANNELS
}
