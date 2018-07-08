package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class StudentListViewModel extends StudentViewModel {
    protected List<Student> students = new ArrayList<>();

    public void addStudent(Student newStudent, String hashedPassword) {
        newStudent.setHashedPassword(hashedPassword);
        students.add(newStudent);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
