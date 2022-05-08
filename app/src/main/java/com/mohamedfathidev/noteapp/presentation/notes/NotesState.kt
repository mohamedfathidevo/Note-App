package com.mohamedfathidev.noteapp.presentation.notes

import com.mohamedfathidev.noteapp.domain.model.Note
import com.mohamedfathidev.noteapp.domain.util.NoteOrder
import com.mohamedfathidev.noteapp.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
