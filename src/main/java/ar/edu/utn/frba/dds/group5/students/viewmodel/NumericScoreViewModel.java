package ar.edu.utn.frba.dds.group5.students.viewmodel;

import ar.edu.utn.frba.dds.group5.students.model.NumericScore;
import ar.edu.utn.frba.dds.group5.students.model.Score;
import org.uqbar.commons.utils.Dependencies;
import org.uqbar.commons.utils.Observable;

@Observable
public class NumericScoreViewModel implements ScoreViewModel {

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Score getScore() {
        return new NumericScore(value);
    }

    @Override
    @Dependencies("value")
    public boolean getInputValid() {
        return value != null;
    }
}
