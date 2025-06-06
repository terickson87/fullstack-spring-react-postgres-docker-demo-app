package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models;

import java.sql.Timestamp;

public class NoteMapper {
    public static Note toDomain(DbNote dbNote) {
        return new Note(
            dbNote.id(),
            dbNote.createdAt().toInstant(),
            dbNote.updatedAt().toInstant(),
            dbNote.body()
        );
    }

    public static DbNote toDb(Note note) {
        return new DbNote(
            note.id(),
            Timestamp.from(note.createdAt()),
            Timestamp.from(note.updatedAt()),
            note.body()
        );
    }
}
