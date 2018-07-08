package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.ConceptualScore;
import ar.edu.utn.frba.dds.group5.students.model.Score;
import org.uqbar.commons.utils.Dependencies;
import org.uqbar.commons.utils.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Observable
public class ConceptualScoreViewModel implements ScoreViewModel {
    private final List<Character> conceptualValues = Arrays.asList('B', 'R', 'M');
    private final List<Character> modifiers = Arrays.asList('+', '-');

    protected Character value;
    protected Character modifier;

    public List<Character> getConceptualValues() {
        return conceptualValues;
    }

    public List<Character> getModifiers() {
        return modifiers;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public Character getModifier() {
        return modifier;
    }

    public void setModifier(Character modifier) {
        this.modifier = modifier;
    }

    public Score getScore() {
        return new ConceptualScore(value, Optional.ofNullable(modifier));
    }

    @Override
    @Dependencies("value")
    public boolean getInputValid() {
        return value != null;
    }
}
