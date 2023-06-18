package com.example.greetingcard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greetingcard.data.api.FactionApi
import com.example.greetingcard.data.model.Faction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactionViewModel @Inject constructor(
    private val api: FactionApi
) : ViewModel() {
    //Starts a co-routine so that the creation of the faction is created in a background thread.
    fun createFaction(name: String) = viewModelScope.launch {
        val faction = Faction(name)
        api.createFaction(faction)
    }
}