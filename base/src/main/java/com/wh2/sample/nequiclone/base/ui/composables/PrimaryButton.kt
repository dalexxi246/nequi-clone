package com.wh2.sample.nequiclone.base.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wh2.sample.nequiclone.base.ui.theme.NequiCloneTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        content = content,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary,
            disabledBackgroundColor = MaterialTheme.colors.secondary.copy(alpha = .60f),
            disabledContentColor = MaterialTheme.colors.onSecondary
        ),
        shape = CircleShape
    )
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonEnabledPreview() {
    NequiCloneTheme {
        PrimaryButton(onClick = { }, enabled = true) {
            Text(text = "Prueba")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonDisabledPreview() {
    NequiCloneTheme {
        PrimaryButton(onClick = { }, enabled = false) {
            Text(text = "Prueba")
        }
    }
}
