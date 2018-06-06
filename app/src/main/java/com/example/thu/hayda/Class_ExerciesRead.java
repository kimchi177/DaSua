package com.example.thu.hayda;

public class Class_ExerciesRead {
    public int ID_SumIpa;
    public int ID_Exercise;
    public String Word;

    public Class_ExerciesRead(String Word) {
        this.Word = Word;
    }

    public int getID_SumIpa() {
        return ID_SumIpa;
    }

    public void setID_SumIpa(int ID_SumIpa) {
        this.ID_SumIpa = ID_SumIpa;
    }

    public int getID_Exercise() {
        return ID_Exercise;
    }

    public void setID_Exercise(int ID_Exercise) {
        this.ID_Exercise = ID_Exercise;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        this.Word = word;
    }
}
