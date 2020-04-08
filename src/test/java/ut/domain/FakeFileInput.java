package ut.domain;

import wordcount.domain.FileInput;

import java.util.Collections;
import java.util.List;

public class FakeFileInput implements FileInput {
    List<String> words;
    String filePath;

    @Override
    public List<String> getWords() {
        if (words != null && words.size() > 0) {
            return words;
        }
        return Collections.emptyList();
    }

    public void setWords(List<String> stopWords) {
        this.words = stopWords;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}