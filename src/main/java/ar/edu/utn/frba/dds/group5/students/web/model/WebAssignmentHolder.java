package ar.edu.utn.frba.dds.group5.students.web.model;

import com.google.api.client.util.Key;

import java.util.List;

public class WebAssignmentHolder {
    @Key("assignments") private List<WebAssignment> assignments;

    public List<WebAssignment> getAssignments() {
        return assignments;
    }
}
