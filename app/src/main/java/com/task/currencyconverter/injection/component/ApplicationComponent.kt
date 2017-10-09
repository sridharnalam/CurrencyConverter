package com.task.currencyconverter.injection.component

import com.ducere.fitnessband.viewmodel.UserResponseViewModel
import com.task.currencyconverter.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun injectTo(userResponseViewModel: UserResponseViewModel)
}