@file:OptIn(ExperimentalFoundationApi::class, ExperimentalUnitApi::class)

package com.wh2.sample.nequiclone.auth.ui.screens.password

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wh2.sample.nequiclone.auth.R
import com.wh2.sample.nequiclone.base.ui.theme.LocalDimensions
import com.wh2.sample.nequiclone.base.ui.theme.NequiCloneTheme

@Composable
fun PasswordScreen(
    password: String,
    updatePassword: (String) -> Unit,
    authenticate: () -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {

    val addPasswordChar = { char: String ->
        updatePassword(password.plus(char))
    }

    val deletePasswordChar = {
        if (password.isNotEmpty()) {
            updatePassword(password.dropLast(1))
        }
    }

    LaunchedEffect(password) {
        if (password.length == 4) {
            authenticate()
        }
    }

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(LocalDimensions.current.screenEdgesPadding)
    ) {
        val (upperComponentsRef, lowerComponentsRef) = createRefs()
        UpperComponents(
            password = password,
            onBackPressed = onBackPressed,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(upperComponentsRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        LowerComponents(
            onDigitKeyPressed = addPasswordChar,
            onDeleteKeyPressed = deletePasswordChar,
            onFingerprintKeyPressed = {},
            modifier = Modifier.constrainAs(lowerComponentsRef) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun UpperComponents(
    password: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        IconButton(onClick = onBackPressed) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = stringResource(R.string.content_description_navigation_back)
            )
        }
        Text(
            text = stringResource(id = R.string.password_write_label),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        PasswordTextFieldsRow(
            password = password,
            modifier = modifier.wrapContentSize()
        )
        Text(
            text = stringResource(id = R.string.password_explanation_label),
            modifier = modifier.wrapContentSize()
        )
    }
}

@Composable
fun PasswordTextFieldsRow(
    password: String,
    modifier: Modifier = Modifier
) {
    val passwordSplit = password.toList()
    Row(modifier = modifier) {
        (0..3).forEach {
            if (passwordSplit.getOrNull(it) != null) {
                PasswordTextField(text = passwordSplit[it].toString())
            } else {
                PasswordTextField(text = "")
            }
        }
    }
}

@Composable
fun PasswordTextField(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(modifier.size(80.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_password_field_background),
            contentDescription = "password_field"
        )
        Text(
            text = text,
            color = MaterialTheme.colors.onSecondary,
            fontSize = TextUnit(36F, TextUnitType.Sp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun LowerComponents(
    onDigitKeyPressed: (value: String) -> Unit,
    onDeleteKeyPressed: () -> Unit,
    onFingerprintKeyPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        NumericKeyboardGrid(
            onDigitKeyPressed = onDigitKeyPressed,
            onDeleteKeyPressed = onDeleteKeyPressed,
            onFingerprintKeyPressed = onFingerprintKeyPressed,
        )
        Text(
            text = stringResource(R.string.password_forgot_password_label),
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun NumericKeyboardGrid(
    modifier: Modifier = Modifier,
    onDigitKeyPressed: (value: String) -> Unit,
    onDeleteKeyPressed: () -> Unit,
    onFingerprintKeyPressed: () -> Unit
) {
    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = modifier) {
        (1..9).forEach { digit ->
            item {
                NumericKey(
                    digit,
                    modifier = Modifier.numericKeyHeight()
                ) { onDigitKeyPressed("$digit") }
            }
        }
        item {
            IconKey(
                R.drawable.ic_fingerprint,
                "auth_with_fingerprint",
                modifier = Modifier.numericKeyHeight(),
                onKeyPressed = onFingerprintKeyPressed
            )
        }
        item {
            NumericKey(
                0,
                modifier = Modifier.numericKeyHeight()
            ) { onDigitKeyPressed("0") }
        }
        item {
            IconKey(
                R.drawable.ic_backspace,
                "password_backspace",
                modifier = Modifier.numericKeyHeight(),
                onKeyPressed = onDeleteKeyPressed
            )
        }
    }
}

private fun Modifier.numericKeyHeight(): Modifier {
    return height(48.dp)
}

@Composable
private fun NumericKey(
    digit: Int,
    modifier: Modifier = Modifier,
    onDigitKeyPressed: (value: String) -> Unit
) {
    Text(
        text = "$digit",
        modifier = modifier
            .clickable { onDigitKeyPressed("$digit") },
        fontSize = TextUnit(36F, TextUnitType.Sp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h3
    )
}

@Composable
private fun IconKey(
    @DrawableRes drawableResource: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onKeyPressed: () -> Unit
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = drawableResource),
            contentDescription = contentDescription,
            modifier = modifier
                .size(36.dp)
                .clickable(onClick = onKeyPressed)
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun Preview() {
    NequiCloneTheme {
        PasswordScreen(
            password = "123",
            authenticate = {},
            onBackPressed = {},
            updatePassword = {}
        )
    }
}
