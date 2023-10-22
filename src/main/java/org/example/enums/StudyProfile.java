package org.example.enums;

public enum StudyProfile {
    ChemicalScience("Химические науки"), Economics("Экономика"), Electronics("Электроника"),
    MATHEMATICS("Математические науки"), MEDICINE("Медицина"), MetallurgicalScience("Металлургия"),
    LINGUISTICS ("Филология"), PhilosophyAndPsychology("Философия и Психология"), PHYSICS("Физика"),
    TechnologyMachinery("Технология");

    private final String description;

    StudyProfile(String str) {
        this.description = str;
    }
}
