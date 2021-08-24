package com.example.memory.mynote.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @author user
 * @date 23.08.2021
 */
@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note ")
    suspend fun getAllNotes(): List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)
}