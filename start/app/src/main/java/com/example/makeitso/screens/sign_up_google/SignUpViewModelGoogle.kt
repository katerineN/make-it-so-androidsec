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

import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts
import com.example.makeitso.R
import androidx.compose.runtime.mutableStateOf
import com.example.makeitso.R.string as AppText
import com.example.makeitso.SETTINGS_SCREEN
import com.example.makeitso.SIGN_UP_SCREEN
import com.example.makeitso.common.ext.isValidEmail
import com.example.makeitso.common.ext.isValidPassword
import com.example.makeitso.common.ext.passwordMatches
import com.example.makeitso.common.snackbar.SnackbarManager
import com.example.makeitso.model.service.AccountService
import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelGoogle @Inject constructor(
    private val accountService: AccountService,
    private val firebaseAuth: FirebaseAuth,
    logService: LogService
) : MakeItSoViewModel(logService) {
    var uiState = mutableStateOf(SignUpUiStateGoogle())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    // Обработчик результатов аутентификации Google
    /*private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                // Успешная аутентификация Google, используйте данные аккаунта при необходимости
                // например, account.idToken для проверки подлинности на сервере
                // Затем можете использовать Firebase Auth для создания пользователя или входа в существующего
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener { authResult ->
                        if (authResult.isSuccessful) {
                            // Успешная аутентификация через Firebase
                            // Ваш код для связывания учетной записи
                            handleSignInSuccess(account.email)
                        } else {
                            // Ошибка аутентификации через Firebase
                            SnackbarManager.showMessage(AppText.firebase_error)
                        }
                    }
            } catch (e: ApiException) {
                // Ошибка при получении данных об аккаунте Google
                SnackbarManager.showMessage(AppText.google_error)
            }
        }
    }

    private suspend fun handleSignInSuccess(email: String?) {
        // Ваш код для связывания учетной записи
        accountService.linkAccount(email, null) // Предполагается, что вы используете только Google Sign-In
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        if (!password.isValidPassword()) {
            SnackbarManager.showMessage(AppText.password_error)
            return
        }

        if (!password.passwordMatches(uiState.value.repeatPassword)) {
            SnackbarManager.showMessage(AppText.password_match_error)
            return
        }

        // Инициируем аутентификацию Google
        val googleSignInClient = getClient()
        val signInIntent = googleSignInClient.signInIntent
        signInLauncher.launch(signInIntent)
    }

    private fun getClient(): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail().build()
        return GoogleSignIn.getClient(requireContext(), gso)
    }*/
}
