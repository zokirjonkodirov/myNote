package com.example.memory.mynote.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author user
 * @date 23.08.2021
 */
@Entity
data class Note(
    val title: String,
    val note: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
