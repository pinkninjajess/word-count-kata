package wordcount.domain;

import java.util.List;

public interface FileInput {
    List<String> getWords();

    void setFilePath(String filePath);
}
