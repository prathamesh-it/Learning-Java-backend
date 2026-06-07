package com.Notes.NotesApplication.service;

import com.Notes.NotesApplication.model.Note;
import com.Notes.NotesApplication.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //generate constructor for the final fields

public class NoteService
{
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes()
    {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id)
    {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    public Note createNote(Note note)
    {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id , Note updateNote)
    {
        Note existing = getNoteById(id);
        existing.setTitle(updateNote.getTitle());
        existing.setContent(updateNote.getContent());
        return noteRepository.save(existing);
    }

    public void deleteNote(Long id)
    {
        Note existing = getNoteById(id);
        noteRepository.delete(existing);
    }

}
