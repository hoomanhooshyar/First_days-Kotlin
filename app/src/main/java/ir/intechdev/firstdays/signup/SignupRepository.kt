package ir.intechdev.firstdays.signup

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.model.Result
import ir.intechdev.firstdays.model.Signup
import ir.intechdev.firstdays.model.User
import ir.intechdev.firstdays.utility.Token
import ir.intechdev.firstdays.utility.Utils

class SignupRepository(context:Application) {
   private var signupApi = SignupApiService(context)
    private val token = Token(context)

    fun signup(user:Signup):LiveData<Result>{
        return signupApi.signup(user)
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