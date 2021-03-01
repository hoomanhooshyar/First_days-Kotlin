package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country_cities")
data class CountryCitiesEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val parentId:Int,
    @ColumnInfo val title:String
)