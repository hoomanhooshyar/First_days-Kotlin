package ir.intechdev.firstdays.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.model.Login
import ir.intechdev.firstdays.model.Result
import ir.intechdev.firstdays.utility.Token
import ir.intechdev.firstdays.utility.Utils

class LoginRepository(context:Application) {
    private val loginApiService = LoginApiService(context)
    private val token = Token(context)
    fun login(login:Login):MutableLiveData<Result>{
        return loginApiService.login(login)
    }

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

    fun setRoleId(roleId:Int){
        token.setRole(roleId)
    }
}