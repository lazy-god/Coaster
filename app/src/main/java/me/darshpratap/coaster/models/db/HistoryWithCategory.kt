package me.darshpratap.coaster.models.db

import androidx.room.Embedded
import androidx.room.Relation

data class HistoryWithCategory(
        @Embedded val history: History,
        @Relation(parentColumn = "id", entityColumn = "res_id", entity = Category::class) val categoryList: List<Category>
)