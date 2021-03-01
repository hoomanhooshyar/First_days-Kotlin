package ir.intechdev.firstdays.api_local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "questions", foreignKeys = [
        ForeignKey(
            entity = UsersEntity::class,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("userId")
        ),
        ForeignKey(
            entity = VisaKindsEntity::class,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("visaKindId")
        )
    ]
)
data class QuestionsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val text: String,
    @ColumnInfo val userId: Int,
    @ColumnInfo val visaKindId: Int,
    @ColumnInfo val qDate: String,
    @ColumnInfo val price: Int
)