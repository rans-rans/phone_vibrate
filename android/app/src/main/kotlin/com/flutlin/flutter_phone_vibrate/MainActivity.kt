package com.flutlin.flutter_phone_vibrate

import android.annotation.SuppressLint
import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    private lateinit var methodChannel: MethodChannel
    private lateinit var vibrator: Vibrator


    @SuppressLint("ServiceCast", "NewApi")
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "method_channel")
        val manager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibrator = manager.defaultVibrator




        methodChannel.setMethodCallHandler { call, result ->

            when (call.method) {
                "simple_vibrate" -> {
                    vibrator.cancel()
                    vibrator.vibrate(VibrationEffect.createOneShot(1500L, 250))
                }

                "wave_form" -> {
                    vibrator.cancel()
                    val timings = longArrayOf(50, 50, 50, 50, 50, 100, 350, 250)
                    val amplitude = intArrayOf(77, 79, 84, 99, 143, 255, 20, 255)
                    vibrator.vibrate(VibrationEffect.createWaveform(timings, amplitude, -1))
                }
            }
        }

    }
}
