package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.utils.BindableProperty;
import ar.edu.utn.frba.dds.group5.students.viewmodel.TaskViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class NewTaskDialog extends Dialog<TaskViewModel> {

    public NewTaskDialog(WindowOwner owner) {
        super(owner, new TaskViewModel());
    }

    @Override
    protected void createFormPanel(Panel panel) {
        new BindableProperty("Materia", "assignature",
                "Nombre de la materia", TextBox.class).addAndBindToPanel(panel);
        new BindableProperty("Descripción", "description",
                "Descripción de la tarea", TextBox.class).addAndBindToPanel(panel);
        new BindableProperty("Nota conceptual/numérica", "conceptual",
                "¿Es nota conceptual?", CheckBox.class).addAndBindToPanel(panel);
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
        new Button(actions).setCaption("Cancelar").onClick(this::cancel);
    }
}
