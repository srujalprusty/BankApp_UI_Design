package com.srujal.bankappui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyLira
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.srujal.bankappui.data.Currency
import com.srujal.bankappui.ui.theme.greenStart


val currencies = listOf(

     Currency(name = "USD",
         buy =23.35f,
         sell = 34.33f,
         icon = Icons.Rounded.AttachMoney
         ) ,
    Currency(name = "EURO",
        buy =22.35f,
        sell = 33.33f,
        icon = Icons.Rounded.Euro
    ),
    Currency(name = "YEN",
        buy =25.35f,
        sell = 4.33f,
        icon = Icons.Rounded.CurrencyYen

    ),
    Currency(name = "INR",
        buy =33.35f,
        sell = 34.33f,
        icon = Icons.Rounded.CurrencyRupee
    ),
    Currency(name = "POUND",
        buy =23.35f,
        sell = 33.33f,
        icon = Icons.Rounded.CurrencyPound
    ),
    Currency(name = "LIRA",
        buy =23.32f,
        sell = 34.3f,
        icon = Icons.Rounded.CurrencyLira
    )
)

//@Preview
@Composable
fun CurrencySection() {

    var isVisible by remember {
        mutableStateOf(false)
    }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 5.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 3.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()

        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible = !isVisible
                            iconState = if (isVisible) {
                                Icons.Rounded.KeyboardArrowUp
                            } else {
                                Icons.Rounded.KeyboardArrowDown
                            }
                        }
                ) {
                    Icon(
                        imageVector = iconState,
                        contentDescription = "icon",
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
             //   Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Currencies", fontWeight = FontWeight.Bold, fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            )

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                modifier = Modifier.width(width),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn(

                        ) {
                            items(currencies.size) { index ->
                                CurrencyItem(
                                    index = index,
                                    width = width
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CurrencyItem(index: Int, width: Dp) {

    val currency = currencies[index]

    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
                    .background(greenStart).padding(4.dp)
            ) {
                Icon(
                    imageVector = currency.icon,
                    contentDescription = "icon",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Text(
                modifier = Modifier.width(width).padding(start = 10.dp),
                text = currency.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                //textAlign = TextAlign.End
            )
        }
        Text(
            modifier = Modifier.width(width).padding(start = 10.dp),
            text = "${currency.buy}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.width(width).padding(start = 10.dp),
            text = "${currency.sell}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}
