package com.wh2.sample.nequiclone.auth.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PasswordScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.wrapContentSize(align = Alignment.Center)) {
        Text(text = "Password screen")
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun Preview() {
    PasswordScreen()
}
