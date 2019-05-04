package com.ozantopuz.powerfulAndroid.core.helper

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.ozantopuz.powerfulAndroid.R

object ProgressBarHelper {

    private lateinit var loadingDialogBuilder: AlertDialog.Builder
    private lateinit var loadingAlertDialog: AlertDialog

    @SuppressLint("InflateParams")
    fun AppCompatActivity.showLoading() {
        try {
            runOnUiThread {
                try {
                    val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_progress_bar, null)
                    loadingDialogBuilder = AlertDialog.Builder(this)
                    loadingDialogBuilder.setView(dialogView)
                    loadingDialogBuilder.setCancelable(false)
                    loadingAlertDialog = loadingDialogBuilder.create()
                    loadingAlertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    if (!this.isFinishing) loadingAlertDialog.show()
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun AppCompatActivity.hideLoading() {
        try {
            runOnUiThread {
                try {
                    if (loadingAlertDialog.isShowing) loadingAlertDialog.dismiss()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}