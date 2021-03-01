package ir.intechdev.firstdays.api_local

import android.app.Application
import androidx.lifecycle.LiveData
import ir.intechdev.firstdays.api_local.entities.CountryCitiesEntity
import ir.intechdev.firstdays.api_local.entities.StudyFieldsEntity
import ir.intechdev.firstdays.api_local.entities.UsersEntity

class LocalRepository(context:Application) {
    private var localDao = LocalDatabase.getLocalDatabase(context).localDao()

    fun insertProfileData(user:UsersEntity){
        localDao.insertProfileData(user)
    }

    fun getUser(token:String):LiveData<UsersEntity>{
        return localDao.getUser(token)
    }

    fun insertCountryCity(countryCity:CountryCitiesEntity){
        localDao.insertCountryCity(countryCity)
    }

    fun insertStudyField(studyField:StudyFieldsEntity){
        localDao.insertStudyField(studyField)
    }
}