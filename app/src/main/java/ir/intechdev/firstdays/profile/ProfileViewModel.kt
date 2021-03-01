package ir.intechdev.firstdays.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ir.intechdev.firstdays.model.DtoUser

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val profileRepository = ProfileRepository(application)

    fun getUserData():MutableLiveData<DtoUser>{
        return profileRepository.getUserData()
    }

    fun getToken():String{
        return profileRepository.getToken()
    }
    fun setToken(token:String){
        profileRepository.setToken(token)
    }
    fun getRoleId():Int{
        return profileRepository.getRoleId()
    }
    fun setRoleId(role:Int){
        profileRepository.setRoleId(role)
    }
}