package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.model.Student;
import ar.edu.utn.frba.dds.group5.students.model.Task;
import ar.edu.utn.frba.dds.group5.students.viewmodel.AssignmentsViewModel;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public abstract class BaseScoreWindow extends SimpleWindow<AssignmentsViewModel> {

    protected Panel taskPanel;

    public BaseScoreWindow(WindowOwner parent, Student student) {
        super(parent, new AssignmentsViewModel(student));
    }

    @Override
    protected void createFormPanel(Panel panel) {
        setTitle("Notas");

        new Label(panel).bindValueToProperty("student.completeUniversityName");
        taskPanel = new Panel(panel);
        taskPanel.setLayout(new HorizontalLayout());

        new Label(taskPanel).setText("Tarea:");
        Selector<Task> tasksSelector = new Selector<>(taskPanel);
        tasksSelector.setWidth(500);
        tasksSelector.bindItemsToProperty("student.assignments");
        tasksSelector.bindValueToProperty("assignment");
    }
}
