package com.wzp.simpleapp.data.shf

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object ShareUtil {
    private var sharedPreference:SharedPreferences?=null
    private fun getSharedPreference(context: Context):SharedPreferences{
        if(sharedPreference==null){
            sharedPreference = context.getSharedPreferences("userInfo",Context.MODE_PRIVATE)
        }
        return sharedPreference!!
    }
    fun putMessage(key:String,value:String,context: Context){
        var editor:SharedPreferences.Editor = getSharedPreference(context).edit()
        editor.putString(key,value)
        editor.commit()
    }
    fun getMessage(key: String,context: Context):String?{
        var sharedPreferences = getSharedPreference(context)
        return sharedPreference?.getString(key,null)
    }

    fun <T> putInfo(key: String,value: Any,context: Context){
        var editor:SharedPreferences.Editor = getSharedPreference(context).edit()
        if(value is Boolean){
            Log.e("TAG", "putInfo: $value is Boolean" )
        }
    }
}