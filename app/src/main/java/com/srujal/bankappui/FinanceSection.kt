package com.srujal.bankappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.srujal.bankappui.data.Finance
import com.srujal.bankappui.ui.theme.blueStart
import com.srujal.bankappui.ui.theme.greenStart


val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My \nBusiness",
        background = greenStart
    ),
    Finance(
        icon = Icons.Rounded.AccountBalanceWallet,
        name = "My \nWallet",
        background = blueStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "Bank \nTransaction",
        background = greenStart
    ),
    Finance(
        icon = Icons.Rounded.AccountBalance,
        name = "Finance \nAnalysis",
        background = blueStart
    ),
)

@Preview
@Composable
fun FinanceSection(){
    Column {
        Text(text = "Finance", fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
            )

        LazyRow(){
            items(financeList.size){
                FinanceItem(it)
            }
        }
    }
}


@Composable
fun FinanceItem(index: Int){

   val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if(index == financeList.size - 1){
        lastPaddingEnd = 16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp , end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon, contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}

