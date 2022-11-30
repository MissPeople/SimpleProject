package com.wzp.simpleapp.ui

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wzp.simpleapp.MainActivity
import com.wzp.simpleapp.data.shf.ShareUtil
import com.wzp.simpleapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    private var isFirstUse = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
    }

    private fun initView() {
        if(isFirstUse){
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dear user")
                .setMessage("thanks your use")
                .setPositiveButton("ok") { _, _ ->
                    showProgress()
                }
                .setNegativeButton("no thanks"){_,_->
                    finish()
                }
                .show()
        }else{
            showProgress()
        }
    }
    private fun showProgress(){
        CoroutineScope(Dispatchers.Main).launch {
            for(i in 1..1000){
                binding.progressBar.progress=i
                delay(3)
            }
            ShareUtil.putMessage("aa","false",this@SplashActivity)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }
}