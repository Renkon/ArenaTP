package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.viewmodel.ScoreViewModel;
import ar.edu.utn.frba.dds.group5.students.viewmodel.TaskViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class TeacherScoreWindow extends BaseScoreWindow {

    public TeacherScoreWindow(WindowOwner parent, Student student) {
        super(parent, student);
    }

    @Override
    protected void createFormPanel(Panel panel) {
        super.createFormPanel(panel);
        new Button(taskPanel).setCaption("Crear nueva tarea").onClick(this::showNewTaskDialog);
    }

    private void showNewTaskDialog() {
        Dialog<TaskViewModel> newTaskWindow = new NewTaskDialog(this);
        newTaskWindow.onAccept(() -> {
            this.getModelObject().createAssignment(newTaskWindow.getModelObject().getTask());
        });
        newTaskWindow.open();
    }

    private void openNumericScoreDialog() {
        Dialog<ScoreViewModel> scoreDialog;
        if (this.getModelObject().isAssignmentScoreConceptual())
            scoreDialog = new ConceptualScoreDialog(this);
        else
            scoreDialog = new NumericScoreDialog(this);
        scoreDialog.onAccept(() -> {
            this.getModelObject().addScore(scoreDialog.getModelObject().getScore());
        });
        scoreDialog.open();
    }

    @Override
    protected void addActions(Panel panel) {
        new Button(panel).setCaption("Agregar nota").onClick(this::openNumericScoreDialog)
                .bindEnabledToProperty("scoreCreatable");
    }
}
