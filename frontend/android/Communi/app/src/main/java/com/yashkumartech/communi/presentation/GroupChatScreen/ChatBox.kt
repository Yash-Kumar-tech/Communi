package com.yashkumartech.communi.presentation.GroupChatScreen

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun ChatBox() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f),
            shape = CircleShape
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                Log.d("Press","Message sent: $text")
            },
            modifier = Modifier
                .weight(0.2f)
                .fillMaxHeight()
        ) {
            Icon(Icons.Default.Send, contentDescription = "Send Message")
        }
    }
}