package ar.edu.utn.frba.dds.group5.students.model;

import java.util.Optional;

public class ConceptualScore implements Score {
    private Character letter;
    private Optional<Character> modifier;

    public ConceptualScore(Character letter, Optional<Character> modifier) {
        this.letter = letter;
        this.modifier = modifier;
    }

    public Character getLetter() {
        return letter;
    }

    public Optional<Character> getModifier() {
        return modifier;
    }

    @Override
    public String toString() {
        // Le agrego trim para poder borrar el espacio del optional
        // Usar el \0 me dio resultados malos
        return (letter.toString() + modifier.orElse(' ').toString()).trim();
    }

    @Override
    public boolean isPassingScore() {
        return !letter.equals('M');
    }
}
