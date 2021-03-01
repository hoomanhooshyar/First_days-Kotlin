package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visit_kinds")
data class VisitKindsEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val title:String
)