package com.yml.design.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp
        )
    )
}

@Composable
fun SubHeading(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = Color.DarkGray,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp
        )
    )
}
@Composable
fun Description(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = Color.DarkGray,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        )
    )
}

@Composable
fun Link(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier,
        style = TextStyle(
            color = Color.Blue,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp
        )
    )
}

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color = Color.Yellow,
    textColor: Color = Color.White
) {
    Text(
        text = text,
        modifier
            .background(shape = RoundedCornerShape(5.dp), color = bgColor)
            .padding(4.dp),
        style = TextStyle(
            color = textColor,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        )
    )
}

