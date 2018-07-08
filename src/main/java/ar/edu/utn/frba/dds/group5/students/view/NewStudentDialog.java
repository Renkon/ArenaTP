package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.utils.BindableProperty;
import ar.edu.utn.frba.dds.group5.students.viewmodel.StudentViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import java.util.ArrayList;
import java.util.List;

public class NewStudentDialog extends Dialog<StudentViewModel> {

    private List<BindableProperty> properties;

    public NewStudentDialog(WindowOwner owner, List<BindableProperty> properties) {
        super(owner, new StudentViewModel());
        this.properties = new ArrayList<>(properties);
    }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Creación de nuevo alumno");

        for (BindableProperty property : properties)
            property.addAndBindToPanel(panel);
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
        new Button(actions).setCaption("Cancelar").onClick(this::cancel);
    }
}
