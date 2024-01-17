package com.aamirashraf.instagramui_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
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
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Programming Mentor",
            description = "10 years of coding experiences\n"+
            "Want me to make your app? Send me an email!\n"+
            "Android tutorials? Subscribe to my channel!",
            url ="https://youtube.com/c/PhillippLackner" ,
            followedBy = listOf("codinginflow","MaxMillian") ,
            otherCount = 17
        )
    }
}
//the best way to learn the compose is to practice more and more
//and i am ready for it and i will do my best hardwrok to gain it
//mobile development is my features
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
@Composable
fun StatSection(
    modifier: Modifier=Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        ProfileStat(numberText = "600", text = "Posts")
        ProfileStat(numberText = "99K", text = "Followers")
        ProfileStat(numberText = "72", text = "Following")
    }
}
@Composable
fun ProfileStat(
    numberText:String,
    text:String,
    modifier: Modifier=Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
            )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}
@Composable
fun ProfileDescription(
    displayName:String,
    description:String,
    url:String,
    followedBy:List<String>,
    otherCount:Int
){
    val letterSpacing=0.5.sp
    val lineHeight=20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing=letterSpacing,
            lineHeight = lineHeight

        )
        Text(text = description,
            letterSpacing=letterSpacing,
            lineHeight = lineHeight
        )
        Text(text = url,
            color = Color(0xff3d3d91),
            letterSpacing=letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()){
            //means that the followed by is not empty
            Text(text = buildAnnotatedString {
                //build annotated string is used to set style between text in compose
                //here we can push pop style in the top of stack
                val boldStyle=SpanStyle(
                    Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by")

                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if(index<followedBy.size-1){
                        append(", ")
                    }

                }
                if(otherCount>2){
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
                letterSpacing=letterSpacing,
                lineHeight=lineHeight
            )
        }

    }

}
@Composable
fun ButtonSection(
    modifier: Modifier=Modifier
){
    val minimumWidth=75.dp
    val minimumHeight=30.dp
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(minimumHeight)
        )
        ActionButton(
            text = "Message",

            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(minimumHeight)
        )
        ActionButton(
            text = "Email",
           
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(minimumHeight)
        )
        ActionButton(

            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minimumWidth)
                .height(minimumHeight)
        )
    }
}

//now lets create reusable composable for button
@Composable
fun ActionButton(
    modifier: Modifier=Modifier,
    text:String?=null,
    icon:ImageVector?=null
){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if (text!=null){
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon!=null){
            Icon(imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}
//@Composable
//fun Aamir(
//    modifier: Modifier=Modifier
//){
//    Column(
//        modifier = modifier
//            .width(400.dp)
//            .height(200.dp)
//            .background(Color.Cyan)
//    ) {
//        Text(text = "hello world",
//            modifier=Modifier
//                .padding(30.dp)
//
//                .background(Color.Red)
//                .width(100.dp)
//                .height(100.dp)
////                .padding(30.dp)
//
//
//            )
//
//        Text(text = "Android dev",
//
//        )
//    }
//}