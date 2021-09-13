package edu.byu.cs.mvpexample.model;

import java.util.ArrayList;
import java.util.List;

public class WordStorage extends Subject {

    private WordStorage() {
        wordList = new ArrayList<>();
        errorState = false;
        lastWord = "";
    }

    private static WordStorage instance;

    public static WordStorage getInstance() {
        if (instance == null) {
            instance = new WordStorage();
        }
        return instance;
    }

    private String lastWord;
    private List<String> wordList;
    private boolean errorState;

    public void addWord(String word) {
        if (wordList.contains(word)) {
            errorState = true;
        } else {
            lastWord = word;
            wordList.add(word);
            errorState = false;
        }
        notifyObservers();
    }

    public String getLastWord() {
        return lastWord;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public boolean isErrorState() {
        return errorState;
    }
}
