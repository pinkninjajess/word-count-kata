package wordcount.infrastructure;

import org.apache.commons.io.IOUtils;
import wordcount.domain.FileInput;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordsFileInput implements FileInput {
    private static final Logger LOGGER = Logger.getLogger(WordsFileInput.class.getName());
    private String filePath;

    @Override
    public List<String> getWords() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);
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
