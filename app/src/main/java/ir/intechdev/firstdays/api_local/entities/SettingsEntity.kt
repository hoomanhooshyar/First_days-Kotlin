package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class SettingsEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val title:String,
    @ColumnInfo val value:String,
    @ColumnInfo val key:String
)