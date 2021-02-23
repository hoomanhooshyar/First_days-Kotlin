package ir.intechdev.firstdays.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ir.intechdev.firstdays.model.Login
import ir.intechdev.firstdays.model.Result

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private var loginRepository = LoginRepository(application)

    fun login(login:Login):LiveData<Result>{
        return loginRepository.login(login)
    }

    fun getToken():String{
        return loginRepository.getToken()
    }

    fun setToken(token:String){
        loginRepository.setToken(token)
    }

    fun getRoleId():Int{
        return loginRepository.getRoleId()
    }

    fun setRoleId(roleId:Int){
        loginRepository.setRoleId(roleId)
    }
}