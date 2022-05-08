package com.mohamedfathidev.noteapp.domain.usecase

import com.mohamedfathidev.noteapp.domain.model.Note
import com.mohamedfathidev.noteapp.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}