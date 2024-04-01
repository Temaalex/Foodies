package com.example.foodies.funs;

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.dp
import com.example.foodies.R


@Preview
@Composable
fun CardCatalog (){
    Column (){
        Header ()
        Menu()
        Content()


    }
}
@Composable
fun Header (){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            modifier = Modifier.padding(10.dp),
            painter = painterResource(id = R.drawable.menuicon1),
            contentDescription = "MenuImg",

            )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoImg"
        )
        Image(
            modifier = Modifier.padding(10.dp),
            painter = painterResource(id = R.drawable.foundicon),
            contentDescription = "FoundImg"
        )
    }
}

@Composable
fun Menu(){
    LazyRow (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .horizontalScroll(rememberScrollState()),

    ){
        itemsIndexed(
            listOf("Роллы", "Суши", "Наборы", "Горячие блюда", "Супы", "Десерты")
        ){_, item ->
            Text(
                text = item
            )
        }
    }
}
@Composable
fun Content(){
    LazyColumn {
        //card 1,2
        //card 3,4
        //etc
    }
}