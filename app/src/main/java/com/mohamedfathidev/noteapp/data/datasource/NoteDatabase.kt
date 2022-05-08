package com.mohamedfathidev.noteapp.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohamedfathidev.noteapp.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao
}