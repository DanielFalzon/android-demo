package com.example.greetingcard.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greetingcard.data.api.FactionApi
import com.example.greetingcard.data.model.Faction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FactionViewModel @Inject constructor(
    private val api: FactionApi
) : ViewModel() {
    private val _factions = MutableStateFlow<List<Faction>>(listOf())
    private var dataLoaded = false

    //Stateflow is immutable which is why this is exposed to the Frontend layer
    val factions: StateFlow<List<Faction>> get() = _factions

    init {
        Log.e("CALL", "From FactionViewModel.init")
        getFactions()
    }

    private fun getFactions(forceRefresh: Boolean = false) = viewModelScope.launch {
        if(!dataLoaded || forceRefresh){
            Log.e("CALL", "From FactionViewModel.getFactions")
            _factions.value = api.getFactions()
            dataLoaded = true
        }
    }

    //Starts a co-routine so that the creation of the faction is created in a background thread.
    fun createFaction(name: String) = viewModelScope.launch {
        val faction = Faction(name)
        _factions.value = api.createFaction(faction)
    }
}