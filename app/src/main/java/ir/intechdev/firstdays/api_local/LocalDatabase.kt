package ir.intechdev.firstdays.api_local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.intechdev.firstdays.api_local.entities.*

@Database(
    entities =
    [AdvisesEntity::class,
        CountryCitiesEntity::class,
        QuestionsEntity::class,
        SchedulesEntity::class,
        SettingsEntity::class,
        StudyFieldsEntity::class,
        UsersEntity::class,
        VisaKindsEntity::class,
        VisitKindsEntity::class],
    version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun localDao():LocalDao
    companion object{
        private var instance:LocalDatabase? = null

        fun getLocalDatabase(context: Context):LocalDatabase{
            if(instance != null)
                return instance!!
            else{
                instance = Room.databaseBuilder(
                    context,
                    LocalDatabase::class.java,
                    "firstdays_database"
                ).allowMainThreadQueries().build()
                return instance!!
            }
        }
    }
}