/*
Copyright 2022 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.makeitso.screens.sign_up_google

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.makeitso.R.string as AppText
import com.example.makeitso.common.composable.*
import com.example.makeitso.common.ext.basicButton
import com.example.makeitso.common.ext.fieldModifier
import com.example.makeitso.theme.MakeItSoTheme

@Composable
fun SignUpGoogleScreen(
  modifier: Modifier = Modifier,
  onSignUpClick: () -> Unit,
  onGoogleSignInClick: () -> Unit
) {
  BasicToolbar(AppText.create_account)

  Column(
    modifier = modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    BasicButton(AppText.create_account, Modifier.basicButton()) {
      onSignUpClick()
    }

    //GoogleSignInButton(Modifier.padding(top = 16.dp), onGoogleSignInClick)
  }
}
