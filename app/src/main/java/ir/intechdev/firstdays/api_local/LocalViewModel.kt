package ir.intechdev.firstdays.api_local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ir.intechdev.firstdays.api_local.entities.CountryCitiesEntity
import ir.intechdev.firstdays.api_local.entities.StudyFieldsEntity
import ir.intechdev.firstdays.api_local.entities.UsersEntity

class LocalViewModel(application: Application) : AndroidViewModel(application) {
    private var localRepository = LocalRepository(application)

    fun insertProfileData(user:UsersEntity){
        localRepository.insertProfileData(user)
    }

    fun getUser(token:String):LiveData<UsersEntity>{
        return localRepository.getUser(token)
    }

    fun insertCountryCity(countryCity: CountryCitiesEntity){
        localRepository.insertCountryCity(countryCity)
    }

    fun insertStudyField(studyField: StudyFieldsEntity){
        localRepository.insertStudyField(studyField)
    }
}