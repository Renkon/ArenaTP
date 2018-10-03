package ar.edu.utn.frba.dds.group5.students.web.model;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import com.google.api.client.util.Key;

public class WebStudent {
    @Key("code") private int code;
    @Key("first_name") private String firstName;
    @Key("last_name") private String lastName;
    @Key("github_user") private String githubUser;

    public WebStudent() {

    }

    public WebStudent(int code, String firstName, String lastName, String githubUser) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.githubUser = githubUser;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGithubUser() {
        return githubUser;
    }

    public static WebStudent toPutFrom(Student student) {
        return new WebStudent(
                student.getFileId(), student.getFirstName(), student.getLastName(), student.getGithubName()
        );
    }
}
