package ir.intechdev.firstdays.utility

import android.app.Application
import android.content.Context

class Token(var context:Application) {
    val appPrefrences = context.getSharedPreferences("token",Context.MODE_PRIVATE)
    val editor = appPrefrences.edit()

    fun getToken():String{
        val token = appPrefrences.getString("token","")
        return token!!
    }

    fun setToken(token:String){
        editor.putString("token",token)
        editor.apply()
    }

    fun getRole():Int{
        return appPrefrences.getInt("role",0)
    }

    fun setRole(role:Int){
        editor.putInt("role",role)
        editor.apply()
    }
}