package ar.edu.utn.frba.dds.group5.students.model;

import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class Student {

    private String firstName;
    private String lastName;
    private int fileId;
    private String githubName;
    private String hashedPassword;
    private List<Assignment> assignments = new ArrayList<>();

    public Student(String firstName, String lastName, int fileId, String githubName, String hashedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fileId = fileId;
        this.githubName = githubName;
        this.hashedPassword = hashedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getGithubName() {
        return githubName;
    }

    public void setGithubName(String githubName) {
        this.githubName = githubName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public String getCompleteUniversityName() {
        return this.fileId + " - " + this.firstName + " " + this.lastName;
    }

    public void addNewAssignment(Task task) {
        if (task.isConceptual())
            assignments.add(new Assignment<ConceptualScore>(task));
        else
            assignments.add(new Assignment<NumericScore>(task));
    }

    public static Student getDummyStudent() {
        return new Student("","", 0, "", "");
    }
}
