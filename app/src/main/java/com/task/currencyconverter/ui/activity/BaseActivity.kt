package com.task.currencyconverter.ui.activity


import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.task.currencyconverter.R

open class BaseActivity : AppCompatActivity(), LifecycleRegistryOwner {

    private val mRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return mRegistry
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(BaseActivityObserver())
    }

    val isBleEnabled: Boolean
        get() {
            val mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
            return mBluetoothAdapter != null && mBluetoothAdapter.isEnabled
        }

    fun enableBluetooth() {
        val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
    }

    companion object {
        val REQUEST_ENABLE_BT = 1001
    }

    fun setAppTheme() {
        setColor(R.color.colorPrimary, R.color.colorPrimaryDark)
    }

    private fun setColor(colorPrimaryBlack: Int, colorPrimaryDarkBlack: Int) {
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(colorPrimaryBlack)))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(colorPrimaryDarkBlack)
        }
    }

}
