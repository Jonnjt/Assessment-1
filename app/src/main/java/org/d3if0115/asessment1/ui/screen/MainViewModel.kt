package org.d3if0115.asessment1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0115.asessment1.database.ArenaDao
import org.d3if0115.asessment1.model.Arena

class MainViewModel(dao: ArenaDao) : ViewModel() {

    val data: StateFlow<List<Arena>> = dao.getArena().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}