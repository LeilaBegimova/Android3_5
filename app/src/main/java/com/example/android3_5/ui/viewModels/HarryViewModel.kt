package com.example.android3_5.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_5.data.models.Data
import com.example.android3_5.data.rapositories.HarryRepository
import com.example.android3_5.utils.UiState

class HarryViewModel : ViewModel() {
    private val repository = HarryRepository()
    private val _characterLiveData = MutableLiveData<UiState<List<Data>>>()
    val characterLiveData: LiveData<UiState<List<Data>>> = _characterLiveData

    init {
        searchHarry("")
    }

    fun searchHarry(query: String) {
        repository.searchHarryPotter(query = query,
            onResponse = { data ->
                _characterLiveData.value = UiState(isLoading = false, success = data)

            },
            onFailure = { t ->
                _characterLiveData.value = UiState(isLoading = false, error = null)
            })
    }
}