package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.viewmodel.ErrorViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class ErrorDialog extends Dialog {

    public ErrorDialog(WindowOwner owner, String error) {
        super(owner, new ErrorViewModel(error));
    }

    @Override
    protected void createFormPanel(Panel panel) {
        new Label(panel).setText(((ErrorViewModel) this.getModelObject()).getError());
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
    }
}
