package com.example.jetwarmindo.ui.Screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetwarmindo.R
import com.example.jetwarmindo.ui.theme.JetWarmindoTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.foto_profile_bangkit),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                .padding(50.dp)
        )
        Text(
            text = "Muhammad Rijalul Awal",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.ExtraBold
                ),
            modifier = modifier
                .align(Alignment.CenterHorizontally),
        )
        Text(
            text = "Bangkit Mobile Development",
            color = colorResource(id = R.color.red),
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.ExtraBold
            ),
        )
        Text(
            text = "mhmmdrijal07@gmail.com",
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.ExtraBold
            ),
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ProfileScreenPreview() {
    JetWarmindoTheme {
        ProfileScreen()
    }
}