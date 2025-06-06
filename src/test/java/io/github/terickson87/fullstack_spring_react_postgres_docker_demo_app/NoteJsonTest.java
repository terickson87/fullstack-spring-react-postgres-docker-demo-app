package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.Instant;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models.Note;

@JsonTest
public class NoteJsonTest {

    @Autowired
    private JacksonTester<Note> json;

    @Autowired
    private JacksonTester<List<Note>> jsonList;
    
    private List<Note> notes;

    @BeforeEach
    void setup() {
        notes = List.of(
            new Note(99L, Instant.parse("2025-06-05T10:00:00Z"), Instant.parse("2025-06-05T10:00:00Z"), "Note 1"),
            new Note(100L, Instant.parse("2025-06-05T11:00:00Z"), Instant.parse("2025-06-05T11:00:00Z"), "Note 2"),
            new Note(101L, Instant.parse("2025-06-05T12:00:00Z"), Instant.parse("2025-06-05T13:00:00Z"), "Note 3")
        );
    }

    @Test
    void noteSerializationTest() throws IOException {
        Note note = notes.get(0);
        assertThat(json.write(note)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(note)).extractingJsonPathNumberValue("@.id")
            .isEqualTo(99);
        assertThat(json.write(note)).hasJsonPathStringValue("@.createdAt");
        assertThat(json.write(note)).extractingJsonPathStringValue("@.createdAt")
            .isEqualTo("2025-06-05T10:00:00Z");
            assertThat(json.write(note)).hasJsonPathStringValue("@.updatedAt");
        assertThat(json.write(note)).extractingJsonPathStringValue("@.updatedAt")
            .isEqualTo("2025-06-05T10:00:00Z");
        assertThat(json.write(note)).hasJsonPathStringValue("@.body");
        assertThat(json.write(note)).extractingJsonPathStringValue("@.body")
            .isEqualTo("Note 1");
        assertThat(json.write(note)).isStrictlyEqualToJson("single.json");
    }

    @Test
    void noteDeserializationTest() throws IOException {
        String expected = """
                {
                    "id": 99,
                    "createdAt": "2025-06-05T10:00:00Z",
                    "updatedAt": "2025-06-05T10:00:00Z",
                    "body": "Note 1"
                }
                """;

        assertThat(json.parseObject(expected).id()).isEqualTo(99L);
        assertThat(json.parseObject(expected).createdAt()).isEqualTo(Instant.parse("2025-06-05T10:00:00Z"));
        assertThat(json.parseObject(expected).updatedAt()).isEqualTo(Instant.parse("2025-06-05T10:00:00Z"));
        assertThat(json.parseObject(expected).body()).isEqualTo("Note 1");
        assertThat(json.parse(expected))
            .isEqualTo(notes.get(0));
    }

    @Test
    void noteListSerializationTest() throws IOException {
        assertThat(jsonList.write(notes)).isStrictlyEqualToJson("list.json");
    }

    @Test
    void noteListDeserializationTest() throws IOException {
        String expected = """
            [
                    {"id": 99, "createdAt": "2025-06-05T10:00:00Z", "updatedAt": "2025-06-05T10:00:00Z", "body": "Note 1"},
                    {"id": 100, "createdAt": "2025-06-05T11:00:00Z", "updatedAt": "2025-06-05T11:00:00Z", "body": "Note 2"},
                    {"id": 101, "createdAt": "2025-06-05T12:00:00Z", "updatedAt": "2025-06-05T13:00:00Z", "body": "Note 3"}
                                                
            ]
            """;
        assertThat(jsonList.parse(expected)).isEqualTo(notes);
    }
}
