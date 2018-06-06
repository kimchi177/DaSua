package com.example.thu.hayda;


public class DictionaryModel {
    private String id_word;
    private String id_image;
    private String word;
    private String ipa;
    private String mean;

    public DictionaryModel( String ipa,  String word, String mean) {
        this.ipa = ipa;
        this.word = word;
        this.mean = mean;
    }

    public String getId_word() {
        return id_word;
    }

    public void setId_word(String id_word) {
        this.id_word = id_word;
    }

    public String getId_image() {
        return id_image;
    }

    public void setId_image(String id_image) {
        this.id_image = id_image;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
