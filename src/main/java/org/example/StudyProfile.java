package org.example;

public enum StudyProfile {
    ChemicalScience("Химические науки"), Economics("Экономика"), Electronics("Электроника"),
    MathematicsScience("Математические науки"), Medicine("Медицина"), MetallurgicalScience("Металлургия"),
    Philology ("Филология"), PhilosophyAndPsychology("Философия и Психология"), PhysicsScience("Физика"),
    TechnologyMachinery("Технология");

    private final String description;

    StudyProfile(String str) {
        this.description = str;
    }
}
