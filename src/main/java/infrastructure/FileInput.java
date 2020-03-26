package infrastructure;

import WordCounter.StopperWords;

import java.util.ArrayList;

public class FileInput implements StopperWords {
    private ArrayList<String> stopperWords;

    public FileInput() {
        ArrayList<String> words = new ArrayList<>();
        words.add("the");
        words.add("on");
        words.add("off");
        words.add("a");
        stopperWords = words;
    }

    @Override
    public ArrayList<String> getStopperWords() {
        return stopperWords;
    }

    @Override
    public void setStopperWords(ArrayList<String> stopperWords) {
        // get file input
    }

}
