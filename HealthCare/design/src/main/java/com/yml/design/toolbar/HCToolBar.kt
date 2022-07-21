package com.yml.design.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.design.elements.Header
import com.yml.design.theme.HotPink


@Composable
fun HCToolBar(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes
    leftIcon: Int = Resource.NONE,
    @DrawableRes
    rightIcon: Int = Resource.NONE,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {}
) {
    Surface(
        modifier
            .fillMaxWidth(),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .background(HotPink)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            if (Resource.NONE != leftIcon) {
                Icon(
                    painter = painterResource(id = leftIcon),
                    contentDescription = "" //TODO CDS
                )
            }

            Header(title)

            if (Resource.NONE != rightIcon) {
                Icon(
                    painter = painterResource(id = leftIcon),
                    contentDescription = "" //TODO CDS
                )
            }
        }
    }
}

@Composable
fun HCToolBarScreen(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes
    leftIcon: Int = Resource.NONE,
    @DrawableRes
    rightIcon: Int = Resource.NONE,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {},
    content: @Composable ColumnScope.(modifier: Modifier) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        HCToolBar(title = title)
        // padding here is of the toolbar shadow
        content(modifier.padding(top = 6.dp))
    }
}

