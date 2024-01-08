package com.example.makeitso.screens.profile

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import com.example.makeitso.model.service.AccountService
import com.example.makeitso.model.service.LogService
import com.example.makeitso.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService
    ) : MakeItSoViewModel(logService) {
        var uiState = mutableStateOf(ProfileUiState())
        private set
        private val name
        get() = uiState.value.name
        private val photoUrl
        get() = uiState.value.photoUrl
        private val authMethod
        get() = uiState.value.authMethod

        fun getUserName(): String {
            var name = "Can't get user name"
            launchCatching {
                name = accountService.getName()
            }
            return name
        }

        fun getUserPhotoUrl(): Uri? {
            return accountService.getPhotoUrl()
        }

        fun getProviderId(): String {
            var provider_id = "TODO"
            launchCatching {
                provider_id = accountService.getProviderId()
                println("provider_id")
                println(provider_id)
            }
            return provider_id
        }
    }
