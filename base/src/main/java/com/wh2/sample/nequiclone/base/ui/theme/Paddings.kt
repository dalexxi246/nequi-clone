package com.wh2.sample.nequiclone.base.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Paddings(
    val screenEdgesPadding: PaddingValues,
    val formFieldsVerticalPadding: PaddingValues,
    val formSpacerSize: Dp
)

val LocalDimensions =
    compositionLocalOf {
        Paddings(
            screenEdgesPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
            formFieldsVerticalPadding = PaddingValues(vertical = 8.dp),
            formSpacerSize = 8.dp
        )
    }
