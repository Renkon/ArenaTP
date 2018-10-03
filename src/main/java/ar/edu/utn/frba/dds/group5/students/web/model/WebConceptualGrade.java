package ar.edu.utn.frba.dds.group5.students.web.model;

import com.google.api.client.util.Key;

public class WebConceptualGrade extends WebGrade {
    @Key("value") private String value;

    public String getValue() {
        return value;
    }
}
