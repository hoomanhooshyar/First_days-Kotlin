package ir.intechdev.firstdays.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val profileRepository = ProfileRepository(application)
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