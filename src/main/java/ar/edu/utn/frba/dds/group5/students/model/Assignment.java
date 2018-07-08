package ar.edu.utn.frba.dds.group5.students.model;

import org.uqbar.commons.utils.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Observable
public class Assignment<T extends Score> {
    protected Task task;
    protected List<T> scores;

    public Assignment(Task task) {
        this.task = task;
        this.scores = new ArrayList<>();
    }

    public void addScore(T score) {
        scores.add(score);
    }

    public boolean isPassedAssignment() {
        if (scores.size() == 0)
            return false;
        else
            return scores.get(scores.size() - 1).isPassingScore();
    }

    public String getScoresAsString() {
        return scores.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public String getStatus() {
        return isPassedAssignment() ? "Aprobado" : "No aprobado";
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<T> getScores() {
        return scores;
    }

    public void setScores(List<T> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return this.task.toString();
    }
}
