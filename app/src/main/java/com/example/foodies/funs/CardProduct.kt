package com.example.foodies.funs;

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodies.R
import com.example.foodies.ui.theme.Primary


@Preview
@Composable
fun CardProduct() {
    ImgBack()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ImgFood()
        //Требуется доработка (Перебор по аналогии с DataFood), подключить json
        NameFood("Том Ям",
            "Кокосовое молоко," +
                    " кальмары, креветки," +
                    " помидоры черри," +
                    " грибы вешанки"
        )
        //Перебор списков, подключить json
        Column{
            val langs1 = listOf("Вес", "Энерг.ценность", "Белки", "Жиры", "Углеводы")
            val langs2 = listOf("400 г", "198,8 ккал", "10 г", "8,5 г", "19,7 г")
            langs1.zip(langs2).forEach { pair ->
                DataFood(pair.component1(), pair.component2())
            }
            Divider(color = Color.Gray, thickness = 1.dp)
        }
        PriceButton ()
    }
}

@Composable
fun ImgBack(){
    //Можно и доработать (потом)
    Image(
        modifier = Modifier.padding(16.dp),
        painter = painterResource(id = R.drawable.img_1),
        contentDescription = "Back",
    )
}
@Composable
fun ImgFood(){
    Image(
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.img),
        contentDescription = "ContentImg",
    )

}
//Название и состав блюда
@Composable
fun NameFood(name:String, composition:String) {
    val style1 = FontFamily(
        Font(R.font.robotolight),
    )
    val style2 = FontFamily(
        Font(R.font.robotomedium)
    )
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 8.dp)
    ){
        //Название блюда
        Text(
            text = name,
            fontFamily = style2,
            fontSize = 34.sp,
        )
        //Состав блюда
        Text(
            text = composition,
            fontFamily = style1,
            fontSize = 16.sp,
        )
    }
}

//Вес, энерг.ценность итд.
@Composable
fun DataFood(substance:String, quantity:String) {
    Divider(color = Color.Gray, thickness = 1.dp)
    val style1 = FontFamily(
        Font(R.font.robotolight),
    )
    val style2 = FontFamily(
        Font(R.font.robotomedium)
    )
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = substance,
                fontFamily = style1,
                fontSize = 16.sp,
            )
            Text(
                text = quantity,
                fontFamily = style2,
                fontSize = 16.sp,
            )
        }
    }
}
@Composable
fun PriceButton (){
    val style1 = FontFamily(
        Font(R.font.robotolight),
    )
    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        contentAlignment  = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .height(48.dp)
                .width(343.dp)
                //.blur(5.dp)
                //.padding(15.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Primary),
            contentAlignment  = Alignment.Center
        ){
            Text(
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = style1,
                text = "В корзину за 720 ₽"
            )
        }
    }
}