package ir.intechdev.firstdays.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.model.Result
import ir.intechdev.firstdays.model.Signup
import ir.intechdev.firstdays.model.User

class SignupViewModel(application: Application) : AndroidViewModel(application) {
    private val signupRepository = SignupRepository(application)

    fun signup(user: Signup):LiveData<Result>{
        return signupRepository.signup(user)
    }

    fun getToken():String{
        return signupRepository.getToken()
    }
    fun setToken(token:String){
        signupRepository.setToken(token)
    }
    fun getRolId():Int{
        return signupRepository.getRoleId()
    }
    fun setRoleId(roleId:Int){
        signupRepository.setRoleId(roleId)
    }
}