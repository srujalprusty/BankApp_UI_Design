package com.srujal.bankappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.srujal.bankappui.data.Card
import com.srujal.bankappui.ui.theme.blackEnd
import com.srujal.bankappui.ui.theme.blackStart
import com.srujal.bankappui.ui.theme.blueEnd
import com.srujal.bankappui.ui.theme.blueStart
import com.srujal.bankappui.ui.theme.greenEnd
import com.srujal.bankappui.ui.theme.greenStart
import com.srujal.bankappui.ui.theme.redEnd
import com.srujal.bankappui.ui.theme.redStart


val cards = listOf(

    Card(
        cardType = "VISA",
        cardNumber = "8951 0486 8951 0486",
        cardName = "Business Card",
        balance = 4500.00,
        color = getGrandient(blueStart , blueEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "8951 0486 8951 4543",
        cardName = "Rupay Card",
        balance = 450323.00,
        color = getGrandient(greenStart , greenEnd)
    ),
    Card(
        cardType = "Saving Card",
        cardNumber = "2322 4323 8951 0486",
        cardName = "Travel Card",
        balance = 15332.00,
        color = getGrandient(redStart , redEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "8951 0486 3223 3423",
        cardName = "Education",
        balance = 45002.00,
        color = getGrandient(blackStart , blackEnd)
    )


)

fun getGrandient(startColor:Color, endColor: Color) : Brush{
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        )
    )
}

@Preview
@Composable
fun CardSection(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}
@Composable
fun CardItem(
     index:Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }


    Box (modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = image, contentDescription = card.cardName
                ,modifier = Modifier.width(60.dp)
            )

             Spacer(modifier = Modifier.height(10.dp))

            Text(text = card.cardName, color = Color.White,
                    fontSize = 17.sp,
                fontWeight = FontWeight.Bold
                )
            Text(text = "$ ${card.balance}", color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = card.cardNumber, color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )


        }
    }
}















