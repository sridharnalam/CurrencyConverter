package com.task.currencyconverter.application

import android.app.Application
import com.task.currencyconverter.injection.component.ApplicationComponent
import com.task.currencyconverter.injection.component.DaggerApplicationComponent
import com.task.currencyconverter.injection.module.ApplicationModule

/**
 * Created by Sridhar Nalam on 09-10-2017.
 */


class MainApplication : Application() {
    private var component: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    fun getComponent(): ApplicationComponent? = component

}