package com.example.makeitso.screens.profile

import coil.compose.rememberAsyncImagePainter
import com.google.firebase.inappmessaging.model.Text

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import com.example.makeitso.R.string as AppText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import com.example.makeitso.common.composable.BasicToolbar

@Composable
fun ProfileScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    BasicToolbar(AppText.profile_name)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name = viewModel.getUserName()
        var photo_url = viewModel.getUserPhotoUrl()
        var provider_id = viewModel.getProviderId()

        Box(
            modifier = modifier
                .size(200.dp)
                .clip(shape = CircleShape)
        ) {
            if (photo_url != null) {
                Image(
                    painter = rememberAsyncImagePainter(photo_url),
                    contentDescription = "User photo",
                    contentScale = ContentScale.Crop,
                    modifier = modifier.fillMaxSize()
                )
            } else {
                Text("No photo", fontSize = 18.sp)
            }
        }

        Text("Name: $name", fontSize = 18.sp)
        Text("Authentication method: $provider_id", fontSize = 18.sp)
    }
}