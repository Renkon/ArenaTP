package ar.edu.utn.frba.dds.group5.students.model;

public class NumericScore implements Score {
    private int score;

    public NumericScore(int score) {
        if (score < 0 || score > 10)
            throw new RuntimeException("Nota inválida (debe estar entre 0 y 10)");
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return Integer.toString(score);
    }

    @Override
    public boolean isPassingScore() {
        return score >= 6;
    }
}
