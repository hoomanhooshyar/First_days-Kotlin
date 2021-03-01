package ir.intechdev.firstdays.api_local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.intechdev.firstdays.api_local.entities.CountryCitiesEntity
import ir.intechdev.firstdays.api_local.entities.StudyFieldsEntity
import ir.intechdev.firstdays.api_local.entities.UsersEntity

@Dao
interface LocalDao {
    @Insert
    fun insertProfileData(user:UsersEntity)

    @Query("SELECT * FROM users WHERE token=:token")
    fun getUser(token:String):LiveData<UsersEntity>

    @Insert
    fun insertCountryCity(countryCity:CountryCitiesEntity)

    @Insert
    fun insertStudyField(studyField:StudyFieldsEntity)
}