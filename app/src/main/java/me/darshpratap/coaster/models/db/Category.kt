package me.darshpratap.coaster.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
        tableName = "category",
        foreignKeys = [ForeignKey(
                entity = History::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("res_id"),
                onDelete = CASCADE
        )]
)
data class Category(
        val title: String,
        val score: Double,
        val res_id: Int?
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}