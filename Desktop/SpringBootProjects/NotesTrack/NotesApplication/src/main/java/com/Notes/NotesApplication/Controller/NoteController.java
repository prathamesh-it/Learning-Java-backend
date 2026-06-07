package com.Notes.NotesApplication.Controller;

import com.Notes.NotesApplication.model.Note;
import com.Notes.NotesApplication.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:5173") //allow requests from the React frontend
@RequiredArgsConstructor
public class NoteController
{
    private final NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes()
    {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id)
    {
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok(note);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note)
    {
        Note created = noteService.createNote(note);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id , @RequestBody Note note)
    {
        Note updated = noteService.updateNote(id , note);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id)
    {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
