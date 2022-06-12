package com.wh2.sample.nequiclone.auth.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wh2.sample.nequiclone.auth.R
import com.wh2.sample.nequiclone.auth.ui.viewmodel.AuthViewModel
import com.wh2.sample.nequiclone.base.ui.composables.CustomTextField
import com.wh2.sample.nequiclone.base.ui.composables.PrimaryButton
import com.wh2.sample.nequiclone.base.ui.theme.LocalDimensions
import com.wh2.sample.nequiclone.base.ui.theme.NequiCloneTheme

@Composable
fun LoginScreen(
    onNextStepButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = viewModel()
) {

    val uiState = authViewModel.uiState.collectAsState()

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(LocalDimensions.current.screenEdgesPadding)
    ) {
        val (logoRef, footerRef) = createRefs()
        Logo(
            modifier = modifier.constrainAs(logoRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(footerRef.top)
            }
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .constrainAs(footerRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            LoginScreenForm(
                userName = uiState.value.userPhone,
                modifier = Modifier.padding(LocalDimensions.current.formFieldsVerticalPadding),
                onUserNameUpdated = authViewModel::updateUserPhone,
                onNextStepButtonClicked = onNextStepButtonClicked
            )
            LoginScreenFooter()
        }
    }
}

@Composable
private fun Logo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_login),
            modifier = Modifier.size(sizeLogoImage),
            contentDescription = stringResource(R.string.login_logo_content_description)
        )
        Text(
            text = stringResource(id = R.string.app_name).uppercase(),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun LoginScreenForm(
    userName: String,
    modifier: Modifier = Modifier,
    onUserNameUpdated: (String) -> Unit = {},
    onNextStepButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = userName,
            onValueChange = onUserNameUpdated,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(LocalDimensions.current.formSpacerSize))
        PrimaryButton(
            onClick = onNextStepButtonClicked,
            enabled = userName.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            Text(text = "Entra")
        }
    }
}

@Composable
private fun LoginScreenFooter(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ayuda")
        Text(text = "Ayuda")
        Text(text = "Ayuda")
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun LoginScreenPreviewDefault() {
    NequiCloneTheme {
        LoginScreen({})
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_7_2013
)
@Composable
private fun LoginScreenPreviewNexus7() {
    NequiCloneTheme {
        LoginScreen({})
    }
}

private val sizeLogoImage = 200.dp
