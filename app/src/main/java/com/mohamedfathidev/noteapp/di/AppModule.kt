package com.mohamedfathidev.noteapp.di

import android.app.Application
import androidx.room.Room
import com.mohamedfathidev.noteapp.data.datasource.NoteDatabase
import com.mohamedfathidev.noteapp.data.repository.NoteRepositoryImpl
import com.mohamedfathidev.noteapp.data.util.Constant.DATABASE_NAME
import com.mohamedfathidev.noteapp.domain.repository.NoteRepository
import com.mohamedfathidev.noteapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteRoomDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(noteDatabase.noteDao)
    }

    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNote = GetNote(repository = repository),
            deleteNote = DeleteNote(repository = repository),
            addNote = AddNote(repository = repository),
            getNotes = GetNotes(repository = repository)
        )
    }
}