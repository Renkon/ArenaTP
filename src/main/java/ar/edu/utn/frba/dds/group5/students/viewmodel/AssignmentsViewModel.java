package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.*;
import org.uqbar.commons.utils.Dependencies;
import org.uqbar.commons.utils.Observable;

@Observable
public class AssignmentsViewModel {

    private Student student;
    private Assignment assignment;

    public AssignmentsViewModel(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Dependencies("assignment")
    public boolean getScoreCreatable() {
        return this.assignment != null;
    }

    @Dependencies("student.assignments")
    public void createAssignment(Task task) {
        student.addNewAssignment(task);
    }

    public void addScore(Score score) {
        assignment.addScore(score);
    }

    public boolean isAssignmentScoreConceptual() {
        return assignment.getTask().isConceptual();
    }
}
