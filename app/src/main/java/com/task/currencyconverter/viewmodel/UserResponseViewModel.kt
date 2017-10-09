package com.ducere.fitnessband.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.ducere.fitnessband.repository.remote.RemoteRepository
import com.task.currencyconverter.application.MainApplication
import com.task.currencyconverter.injection.repository.remote.model.User
import javax.inject.Inject

class UserResponseViewModel(application: Application) : AndroidViewModel(application) {

    val userResponseObservable: LiveData<User>

    @Inject
    lateinit var mRemoteRepository: RemoteRepository

    init {
        (application as MainApplication).getComponent()?.injectTo(this)
        userResponseObservable = mRemoteRepository.getUser("WMfw074xSCOTeVUB39PE")

    }
}