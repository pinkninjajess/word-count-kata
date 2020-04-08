package wordcount.infrastructure;

import org.apache.commons.io.IOUtils;
import wordcount.domain.FileInput;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StopWordsFileInput implements FileInput {
    private ArrayList<String> stopWords;
    private static final Logger LOGGER = Logger.getLogger(StopWordsFileInput.class.getName());
    private String filePath;

    @Override
    public List<String> getWords() {
        try {
            Class<StopWordsFileInput> stopWordsFileInputClass = StopWordsFileInput.class;
            InputStream inputStream = stopWordsFileInputClass.getResourceAsStream(filePath);
            return IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Loading of stop words from file failed");
            return Collections.emptyList();
        }
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }
}
