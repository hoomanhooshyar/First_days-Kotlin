package ir.intechdev.firstdays.api_local.entities

import androidx.room.*

@Entity(
    tableName = "advises", foreignKeys = [
        ForeignKey(
            entity = CountryCitiesEntity::class,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("countryCityId")
        ),
        ForeignKey(
            entity = VisaKindsEntity::class,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("visaKindId")
        ),
        ForeignKey(
            entity = VisitKindsEntity::class,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("visitKindId")
        ),
        ForeignKey(
            entity = UsersEntity::class,
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("advisorId")
        )
    ]
)
data class AdvisesEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val duration: Int,
    @ColumnInfo val price: Int,
    @ColumnInfo val countryCityId: Int,
    @ColumnInfo val visaKindId:Int,
    @ColumnInfo val visitKindId:Int,
    @ColumnInfo val advisorId:Int,
    @ColumnInfo val setting:String

)