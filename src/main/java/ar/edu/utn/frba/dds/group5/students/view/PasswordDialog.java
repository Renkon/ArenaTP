package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.utils.BindableProperty;
import ar.edu.utn.frba.dds.group5.students.viewmodel.PasswordViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.PasswordField;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class PasswordDialog extends Dialog<PasswordViewModel> {
    public PasswordDialog(WindowOwner owner) {
        super(owner, new PasswordViewModel());
    }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Contraseña requerida");
        new BindableProperty("Contraseña", "password",
                "Estimado alumno ingrese su contraseña", PasswordField.class).addAndBindToPanel(panel);;
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
    }
}
