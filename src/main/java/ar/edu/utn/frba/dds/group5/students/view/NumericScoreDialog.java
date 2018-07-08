package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.utils.BindableProperty;
import ar.edu.utn.frba.dds.group5.students.viewmodel.NumericScoreViewModel;
import ar.edu.utn.frba.dds.group5.students.viewmodel.ScoreViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class NumericScoreDialog extends Dialog<ScoreViewModel> {

    public NumericScoreDialog(WindowOwner owner) {
        super(owner, new NumericScoreViewModel());
    }

    @Override
    protected void createFormPanel(Panel panel) {
        new BindableProperty("Nota", "value", "Nota", NumericField.class)
                .addAndBindToPanel(panel);
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault()
                .bindEnabledToProperty("inputValid");
        new Button(actions).setCaption("Cancelar").onClick(this::cancel);
    }
}
