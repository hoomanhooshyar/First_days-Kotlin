package ir.intechdev.firstdays.profile

import android.app.Application
import ir.intechdev.firstdays.utility.Token
import ir.intechdev.firstdays.utility.Utils

class ProfileRepository(context:Application) {
    private val token = Token(context)

    fun getToken():String{
        Utils.myToken = token.getToken()
        return token.getToken()
    }
    fun setToken(myToken:String){
        Utils.myToken = myToken
        token.setToken(myToken)
    }
    fun getRoleId():Int{
        return token.getRole()
    }
    fun setRoleId(role:Int){
        token.setRole(role)
    }
}