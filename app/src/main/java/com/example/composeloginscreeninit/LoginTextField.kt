package com.example.composeloginscreeninit

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.composeloginscreeninit.ui.theme.Black
import com.example.composeloginscreeninit.ui.theme.focusedTextFieldColor
import com.example.composeloginscreeninit.ui.theme.textFieldContainer
import com.example.composeloginscreeninit.ui.theme.unFocusedTextFieldColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier, label: String, trailing: String
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    var textState by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = textState,
        onValueChange = {textState = it},
        label = {
            Text(
                text = label, style = MaterialTheme.typography.labelMedium, color = uiColor
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.unFocusedTextFieldColor,
            focusedIndicatorColor = MaterialTheme.colorScheme.focusedTextFieldColor,
            containerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),
        trailingIcon = {
            TextButton(onClick = {}) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        }
    )
}




