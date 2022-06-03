package com.wh2.sample.nequiclone.base.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.wh2.sample.nequiclone.base.R

val MontserratFontFamily: FontFamily = FontFamily(
    Font(
        R.font.montserrat_black,
        weight = FontWeight.Black,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_black_italic,
        weight = FontWeight.Black,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_extrabold,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_extrabold_italic,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_extralight,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_extralight_italic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_light,
        weight = FontWeight.Light,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_light_italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_semibold,
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_semibold_italic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
    Font(
        R.font.montserrat_thin,
        weight = FontWeight.Thin,
        style = FontStyle.Normal
    ),
    Font(
        R.font.montserrat_thin_italic,
        weight = FontWeight.Thin,
        style = FontStyle.Italic
    ),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    button = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    defaultFontFamily = MontserratFontFamily
)
