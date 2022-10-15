package com.lucassantos.myweather.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.lucassantos.myweather.R
import com.lucassantos.myweather.databinding.ActivitySplashBinding
import com.lucassantos.myweather.extensions.readSettingsInDataStore
import com.lucassantos.myweather.extensions.saveSettingsInDataStore
import com.lucassantos.myweather.utils.Constants
import com.lucassantos.myweather.utils.Utils
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        animateTextNameApp()
        verifyIfIsFirstRunApp()
        goMainActivityDelayed()
    }

    /**
     * Play animation on the textNameApp.
     */
    private fun animateTextNameApp() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade)
        mBinding.textNameApp.startAnimation(animation)
    }

    /**
     * Verify if is first running application.
     */
    private fun verifyIfIsFirstRunApp() {
        lifecycleScope.launch {
            val languageData = readSettingsInDataStore(Constants.PREFERENCES.LANGUAGE_DATA).first()
            if (languageData == Constants.PREFERENCES.NO_PREFERENCES) {
                saveSettingsDefaultInDataStore()
            }
        }
    }

    /**
     * Saving the data language and API return temperature unit.
     */
    private fun saveSettingsDefaultInDataStore() {
        saveSettingsInDataStore(
            Constants.PREFERENCES.LANGUAGE_DATA,
            Utils.getListDataLanguage().first()
        )
        saveSettingsInDataStore(
            Constants.PREFERENCES.TEMPERATURE_UNIT,
            Utils.getListTemperatureUnitAPI().first()
        )
    }

    /**
     * Starting MainActivity with 1.2 seconds delayed.
     */
    private fun goMainActivityDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java)).also { finish() }
        }, 1200)
    }
}