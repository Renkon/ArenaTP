package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.utils.BindableProperty;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public class StudentScoreWindow extends BaseScoreWindow {

    public StudentScoreWindow(WindowOwner parent, Student student) {
        super(parent, student);
    }

    @Override
    protected void createFormPanel(Panel panel) {
        super.createFormPanel(panel);
        new BindableProperty("Notas", "assignment.scoresAsString",
                "Notas de la asignación", Label.class).addAndBindToPanel(panel);
        new BindableProperty("Estado", "assignment.status",
                "Estado de la asignación", Label.class).addAndBindToPanel(panel);
    }

    @Override
    protected void addActions(Panel panel) {

    }
}
