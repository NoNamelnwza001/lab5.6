package com.example.lab06;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class NoteMapper {

    static Gson gson = new Gson();

    // OOP -> Entity
    public static NoteEntity toEntity(Note note1) {
        if (note1 instanceof TextNote) {
            Object note = null;
            return new NoteEntity(note1.title, "text", ((TextNote) note1).getTextContent(), note1.createdDate, null);
        } /*else if (note instanceof ChecklistNote) {
            String jsonItems = gson.toJson(((ChecklistNote) note).getItems());
            return new NoteEntity(note.title, "checklist", jsonItems, null, note.createdDate);
        }*/
        return null;
    }

    // Entity -> OOP
    public static Note fromEntity(NoteEntity entity) {
        if (entity.type.equals("text")) {
            TextNote textNote1 = new TextNote();
            textNote1.title = entity.title ;
//textNote1.textContent="Coding OOP class and object";
            textNote1.setTextContent(entity.content);
            textNote1.createdDate = String.valueOf(entity.createdDate);



        }/* else if (entity.type.equals("checklist")) {
            List<String> items = gson.fromJson(entity.checklistItemsJson, new TypeToken<List<String>>(){}.getType());
            return new ChecklistNote(entity.title, entity.createdDate, items);
        }*/
        return null;
    }
}
