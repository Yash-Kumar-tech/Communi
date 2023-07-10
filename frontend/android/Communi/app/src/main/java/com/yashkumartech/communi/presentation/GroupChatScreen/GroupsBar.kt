package com.yashkumartech.communi.presentation.GroupChatScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun GroupsBar(
    selectedGroupIndex: Int = 0,
    onChangeGroup: (Int) -> Unit,
) {
    val items = listOf("Group1", "Group2", "Group3")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    return NavigationRail(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp)),
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedGroupIndex == index,
                onClick = {
                    onChangeGroup(index)
                    Log.d("Press", "$item pressed")
                }
            )
        }
    }
}
