package ut.domain;

import domain.StopWords;

import java.util.Collections;
import java.util.List;

public class FakeStopWordsFileInput implements StopWords {
    @Override
    public List<String> getStopWords() {
        return Collections.emptyList();
    }
}