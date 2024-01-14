package com.aamirashraf.instagramui_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        TopBar(name = "Aamir Ashraf")
        Spacer(modifier = Modifier.height(10.dp))
        ProfileSection()
    }
}
@Composable
fun TopBar(
    name:String,
    modifier:Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="back arrow",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
            )
        Text(text =name,
            overflow = TextOverflow.Ellipsis ,   //means this will append 3 dot if the text overflow
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription ="bell",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
        )
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu), contentDescription ="dotMenu",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
        )
    }
}
@Composable
fun ProfileSection(
    modifier: Modifier=Modifier
){
    Column(
        modifier=modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
            ) {
            RoundImage(image = painterResource(id = R.drawable.philipp),
                modifier= Modifier
                    .size(100.dp)
                    .weight(3f)  //30%
            )
        }
    }
}
@Composable
fun RoundImage(
    image:Painter,
    modifier: Modifier=Modifier
){
    Image(painter = image, contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
        )
}