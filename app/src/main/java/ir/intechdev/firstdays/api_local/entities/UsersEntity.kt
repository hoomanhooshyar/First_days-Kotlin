package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "users",foreignKeys = [
    ForeignKey(
        entity = CountryCitiesEntity::class,
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("countryCityId")
    ),
    ForeignKey(
        entity = StudyFieldsEntity::class,
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("studyFieldId")
    )
])
data class UsersEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val name:String,
    @ColumnInfo val family:String,
    @ColumnInfo val username:String,
    @ColumnInfo val password:String,
    @ColumnInfo val email:String,
    @ColumnInfo val phone:String?,
    @ColumnInfo val mobile:String,
    @ColumnInfo val age:Int,
    @ColumnInfo val image:String?,
    @ColumnInfo val token:String?,
    @ColumnInfo val roleId:Int,
    @ColumnInfo val gender:Int,
    @ColumnInfo val countryCityId:Int?,
    @ColumnInfo val studyFieldId:Int?,
    @ColumnInfo val status:String?,
    @ColumnInfo val credit:String?,
    @ColumnInfo val setting:String?
)