package ar.edu.utn.frba.dds.group5.students.web.model;

import com.google.api.client.util.Key;

import java.util.List;

public class WebAssignment {
    @Key("id") private long id;
    @Key("title") private String title;
    @Key("description") private String description;
    @Key("grades") private List<WebGrade> grades;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<WebGrade> getGrades() {
        return grades;
    }
}
