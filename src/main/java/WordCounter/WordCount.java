package WordCounter;


public class WordCount {

    private UserInterface UI;

    public WordCount(UserInterface UI){
        this.UI = UI;
    }

    public void countWords(){
        String userInput = UI.getUserInput();
        int count = countWordsFrom(userInput);
        UI.printWordCount(count);
    }

    private int countWordsFrom(String userInput) {
        // break up userInput into words by whitespace
        // check each string is a word by regex
        // count number of words
        return 0;
    }


}
