package com.ducere.fitnessband.repository.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.task.currencyconverter.injection.repository.remote.api.CommonApi
import com.task.currencyconverter.injection.repository.remote.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


/**
 * Created by Sridhar Nalam on 06-09-2017.
 */
class RemoteRepository(commonApi: CommonApi) {

    private var mCommonAPI: CommonApi = commonApi

    fun getUser(userId: String): LiveData<User> {

        val userLiveData = MutableLiveData<User>()
        val userObservable = mCommonAPI.getUser(userId, 104)
        val userDisposableObserver = object : DisposableObserver<User>() {
            override fun onError(e: Throwable) {
                userLiveData.value = null;
            }

            override fun onComplete() {
            }

            override fun onNext(user: User) {
                Log.e("onNext", "User" + user.toString());
                userLiveData.value = user
            }
        }
        userObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userDisposableObserver)
        return userLiveData;
    }
}
