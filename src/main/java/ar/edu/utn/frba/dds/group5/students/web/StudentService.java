package ar.edu.utn.frba.dds.group5.students.web;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.web.model.WebAssignmentHolder;
import ar.edu.utn.frba.dds.group5.students.web.model.WebStudent;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.IOException;

public class StudentService {
    private static final String GET_STUDENT_URL = "http://notitas.herokuapp.com/student";
    private static final String GET_STUDENT_ASSIGNMENTS_URL = "http://notitas.herokuapp.com/student/assignments";
    private static final String PUT_STUDENT_URL = "http://notitas.herokuapp.com/student";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXN" +
            "mZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private final JsonFactory JSON_FACTORY = new JacksonFactory();

    private HttpRequestFactory requestFactory;

    public StudentService() {
        requestFactory =
                HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) {
                        request.getHeaders().setAuthorization("Bearer " + TOKEN);
                        request.setParser(new JsonObjectParser(JSON_FACTORY));
                    }
                });
    }

    public WebStudent getStudent() {
        try {
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(GET_STUDENT_URL));
            return request.execute().parseAs(WebStudent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WebStudent putStudent(Student student) {
        try {
            WebStudent webStudentInput = WebStudent.toPutFrom(student);
            HttpRequest request = requestFactory.buildPutRequest(new GenericUrl(PUT_STUDENT_URL), new JsonHttpContent(JSON_FACTORY, webStudentInput));
            WebStudent webStudentResponse = request.execute().parseAs(WebStudent.class);
            webStudentResponse.setCode(student.getFileId());
            return webStudentResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WebAssignmentHolder getAssignmentHolder() {
        try {
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(GET_STUDENT_ASSIGNMENTS_URL));
            WebAssignmentHolder holder = request.execute().parseAs(WebAssignmentHolder.class);
            return holder;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
