package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import org.uqbar.commons.utils.Dependencies;
import org.uqbar.commons.utils.Observable;

@Observable
public class StudentViewModel {

    protected boolean selected = false;
    protected Student student = Student.getDummyStudent();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.selected = true;
        this.student = student;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Dependencies("student")
    public String getFirstName() {
        return student.getFirstName();
    }

    @Dependencies("student")
    public String getLastName() {
        return student.getLastName();
    }

    @Dependencies("student")
    public int getFileId() {
        return student.getFileId();
    }

    @Dependencies("student")
    public String getGithubName() {
        return student.getGithubName();
    }

    @Dependencies("student")
    public String getHashedPassword() {
        return student.getHashedPassword();
    }

    public void setFirstName(String firstName) {
        student.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        student.setLastName(lastName);
    }

    public void setFileId(int fileId) {
        student.setFileId(fileId);
    }

    public void setGithubName(String githubName) {
        student.setGithubName(githubName);
    }

    @Dependencies("hashedPassword")
    public boolean isPasswordMatching(String hashedPassword) {
        return getHashedPassword().equals(hashedPassword);
    }
}
