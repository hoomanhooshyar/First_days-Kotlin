package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_fields")
data class StudyFieldsEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val title:String,
    @ColumnInfo val type:String
)