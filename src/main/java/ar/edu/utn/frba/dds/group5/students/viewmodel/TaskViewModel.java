package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.Task;
import org.uqbar.commons.utils.Observable;

@Observable
public class TaskViewModel {

    private Task task = new Task("", "");

    public Task getTask() {
        return task;
    }

    public String getDescription() {
        return task.getDescription();
    }

    public void setDescription(String description) {
        task.setDescription(description);
    }

    public String getAssignature() {
        return task.getAssignature();
    }

    public void setAssignature(String assignature) {
        task.setAssignature(assignature);
    }

    public boolean isConceptual() {
        return task.isConceptual();
    }

    public void setConceptual(boolean conceptual) {
        task.setConceptual(conceptual);
    }


}
