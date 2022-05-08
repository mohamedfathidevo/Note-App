package com.mohamedfathidev.noteapp.domain.usecase

import com.mohamedfathidev.noteapp.domain.model.Note
import com.mohamedfathidev.noteapp.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}