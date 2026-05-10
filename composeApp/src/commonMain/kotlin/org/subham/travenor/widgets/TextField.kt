package org.subham.travenor.widgets

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TravenorTextField(
    value: String,
    onValueChange: (String) -> Unit,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f),
        unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f),
        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f),
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f)
    ),
    placeholder: @Composable ()-> Unit,
    shape: Shape = RoundedCornerShape(16.dp),
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = shape,
        colors = colors,
        placeholder = placeholder,
        readOnly = readOnly,
        singleLine = singleLine,
        maxLines = maxLines
    )
}


@Composable
fun TravenorPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f),
        unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f),
        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f),
        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.2f)
    ),
    placeholder: @Composable ()-> Unit,
    shape: Shape = RoundedCornerShape(16.dp),
    modifier: Modifier = Modifier,

) {
    var showPassword by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = shape,
        colors = colors,
        placeholder = placeholder,
        visualTransformation = if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick ={
                    showPassword = !showPassword
                }
            ){
                Icon(
                    imageVector = if(showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                    contentDescription = "Visibility of password"
                )
            }
        },
        singleLine = true
    )
}