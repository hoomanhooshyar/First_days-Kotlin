package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "schedules",foreignKeys = [
    ForeignKey(
        entity = UsersEntity::class,
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId")
    )
])
data class SchedulesEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val dayNumber:Int,
    @ColumnInfo val userId:Int,
    @ColumnInfo val hour:Int
)