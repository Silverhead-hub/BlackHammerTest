package agency.blackhammer.wordanalyzer.bean;

import org.springframework.stereotype.Component;

@Component
public class MaxLetterCount {
    private  String inputWord;

    public void setInputWord(String inputWord) {
        if(!isValid(inputWord)){
            throw new IllegalArgumentException("Not valid word!");
        }
        this.inputWord = inputWord;
    }

    public String findMaxLetter() {
        char maximumLetter = 0;
        int maxRepeat = 0;
        for (int i = 0; i < inputWord.length(); i++) {
            char letter = inputWord.charAt(i);
            int countRepeat = 0;

            for (int j = 0; j < inputWord.length(); j++) {
                if (inputWord.charAt(j) == letter && Character.isLetter(inputWord.charAt(i))) {
                    countRepeat++;
                }
            }

            if (countRepeat >= maxRepeat) {
                maxRepeat = countRepeat;
                maximumLetter = inputWord.charAt(i);
            }
        }
        return maximumLetter + " " + maxRepeat;
    }

    public boolean  isValid(String inputWord) {
        if(inputWord == null || inputWord.length() == 0) {
            return false;
        }
        return inputWord.matches(".*[\\p{L}].*");
    }
}

