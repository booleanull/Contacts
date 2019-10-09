package com.booleanull.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class MyViewModel : ViewModel() {

    private val supervisorJob = SupervisorJob()

    val uiScope = CoroutineScope(Dispatchers.IO + supervisorJob)

    override fun onCleared() {
        super.onCleared()
        supervisorJob.cancel()
    }
}