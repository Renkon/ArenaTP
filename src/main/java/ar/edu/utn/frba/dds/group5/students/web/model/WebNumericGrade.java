package ar.edu.utn.frba.dds.group5.students.web.model;

import com.google.api.client.util.Key;

public class WebNumericGrade extends WebGrade {
    @Key("value") private int value;

    public int getValue() {
        return value;
    }
}
