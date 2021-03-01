package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "visa_kinds", foreignKeys = [
    ForeignKey(
        entity = CountryCitiesEntity::class,
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("countryCityId")
    )
])
class VisaKindsEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val countryCityId:Int,
    @ColumnInfo val text:String,
    @ColumnInfo val setting:String

)