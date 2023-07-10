package com.yashkumartech.communi.presentation.GroupChatScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.yashkumartech.communi.util.ChatObject


@Composable
fun ChatBubble(
    chatObject: ChatObject,
    sentByUser: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(1.0f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(
                    if(sentByUser) Alignment.CenterEnd
                    else           Alignment.CenterStart
                )
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    if (sentByUser) MaterialTheme.colorScheme.primaryContainer
                    else MaterialTheme.colorScheme.background
                )
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    if(sentByUser) ""
                    else chatObject.sender,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    chatObject.dateSent,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Text(
                chatObject.content,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                chatObject.timeSent,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}