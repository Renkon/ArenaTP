package ar.edu.utn.frba.dds.group5.students.model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Task {
    private String assignature;
    private String description;
    private boolean conceptual;

    public Task(String assignature, String description, boolean conceptual) {
        this.assignature = assignature;
        this.description = description;
        this.conceptual = conceptual;
    }

    @Override
    public String toString() {
        return assignature + " - " + description;
    }

    public String getAssignature() {
        return assignature;
    }

    public void setAssignature(String assignature) {
        this.assignature = assignature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isConceptual() {
        return conceptual;
    }

    public void setConceptual(boolean conceptual) {
        this.conceptual = conceptual;
    }
}
