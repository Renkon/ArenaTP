package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.utils.BindableProperty;
import ar.edu.utn.frba.dds.group5.students.viewmodel.AssignmentsViewModel;
import ar.edu.utn.frba.dds.group5.students.viewmodel.PasswordViewModel;
import ar.edu.utn.frba.dds.group5.students.viewmodel.StudentViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import ar.edu.utn.frba.dds.group5.students.viewmodel.StudentListViewModel;
import org.uqbar.arena.windows.SimpleWindow;

import java.util.ArrayList;
import java.util.List;

public class StudentsWindow extends MainWindow<StudentListViewModel> {

    private List<BindableProperty> boundedProperties = new ArrayList<>();

    public StudentsWindow() {
        super(new StudentListViewModel());

        // Populamos las propiedades a bindear.
        boundedProperties.add(new BindableProperty("Legajo", "fileId", "Legajo del alumno", NumericField.class));
        boundedProperties.add(new BindableProperty("Nombre", "firstName", "Nombre del alumno", TextBox.class));
        boundedProperties.add(new BindableProperty("Apellido", "lastName", "Apellido del alumno", TextBox.class));
        boundedProperties.add(new BindableProperty("GitHub", "githubName", "GitHub del alumno", TextBox.class));

    }

    @Override
    public void createContents(Panel panel) {
        this.setTitle("Estudiantes - Gestión de Notas");

        panel.setLayout(new VerticalLayout());
        Table<Student> studentTable = new Table<>(panel, Student.class);
        studentTable.setNumberVisibleRows(10);
        studentTable.bindItemsToProperty("students");
        studentTable.bindSelectionToProperty("student");

        for (BindableProperty property : boundedProperties)
            property.addAndBindToPanelWithTable(panel, studentTable);

        new Button(panel).setCaption("Agregar alumno nuevo").onClick(this::openNewStudentDialog);
        new Button(panel).setCaption("Docente: ingresar notas").onClick(this::openAddScoreWindow)
                .bindEnabledToProperty("selected");
        new Button(panel).setCaption("Alumno: visualizar notas").onClick(this::openViewScoresWindow)
                .bindEnabledToProperty("selected");
    }



    private void openNewStudentDialog() {
        Dialog<StudentViewModel> registerDialog = new NewStudentDialog(this, boundedProperties);
        registerDialog.onAccept(() -> { // Continuation passing style
            Dialog<PasswordViewModel> passwordDialog = new PasswordDialog(this);
            passwordDialog.onAccept(() -> {
                this.getModelObject().addStudent(registerDialog.getModelObject().getStudent(),
                        passwordDialog.getModelObject().getHashedPassword());
            });
            passwordDialog.open();
        });
        registerDialog.open();
    }

    private void openAddScoreWindow() {
        SimpleWindow<AssignmentsViewModel> scoresWindow = new TeacherScoreWindow(this, this.getModelObject().getStudent());
        scoresWindow.open();
    }

    private void openViewScoresWindow() {
        Dialog<PasswordViewModel> passwordDialog = new PasswordDialog(this);
        passwordDialog.onAccept(() -> {
            if (this.getModelObject().isPasswordMatching(passwordDialog.getModelObject().getHashedPassword())) {
                SimpleWindow<AssignmentsViewModel> scoresWindow = new StudentScoreWindow(this, this.getModelObject().getStudent());
                scoresWindow.open();
            }
            else {
                Dialog errorDialog = new ErrorDialog(this, "Contraseña inválida");
                errorDialog.open();
            }
        });
        passwordDialog.open();
    }

    public static void main(String[] args) {
        new StudentsWindow().startApplication();
    }
}
