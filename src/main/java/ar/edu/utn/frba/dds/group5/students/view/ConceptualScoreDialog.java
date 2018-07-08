package ar.edu.utn.frba.dds.group5.students.view;

import ar.edu.utn.frba.dds.group5.students.viewmodel.ConceptualScoreViewModel;
import ar.edu.utn.frba.dds.group5.students.viewmodel.ScoreViewModel;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class ConceptualScoreDialog extends Dialog<ScoreViewModel> {

    public ConceptualScoreDialog(WindowOwner owner) {
        super(owner, new ConceptualScoreViewModel());
    }

    @Override
    protected void createFormPanel(Panel panel) {
        Panel valuePanel = new Panel(panel);
        valuePanel.setLayout(new HorizontalLayout());

        Selector<Character> valueSelector = new Selector<>(valuePanel);
        valueSelector.setWidth(300);
        valueSelector.bindItemsToProperty("conceptualValues");
        valueSelector.bindValueToProperty("value");

        Selector<Character> modifierSelector = new Selector<>(valuePanel);
        modifierSelector.setWidth(300);
        modifierSelector.bindItemsToProperty("modifiers");
        modifierSelector.bindValueToProperty("modifier");
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault()
                .bindEnabledToProperty("inputValid");
        new Button(actions).setCaption("Cancelar").onClick(this::cancel);
    }
}
