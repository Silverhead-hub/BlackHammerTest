package agency.blackhammer.wordanalyzer.controller;

import agency.blackhammer.wordanalyzer.bean.MaxLetterCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/wordanalyzer")
public class WordAnalyzerController {
    MaxLetterCount maxLetterCount;

    @Autowired
    public void setMaxLetterCount(MaxLetterCount maxLetterCount) {
        this.maxLetterCount = maxLetterCount;
    }

    @GetMapping("/analyze")
    @ResponseBody
    public Map<String, String> analyzer (@RequestParam String word) {
        Map<String, String> map = new HashMap<>();
        try {
           maxLetterCount.setInputWord(word);
           String [] result = maxLetterCount.findMaxLetter().split(" ");
           map.put("letter" , result[0]);
           map.put("count" , result[1]);
        }
        catch (IllegalArgumentException e){
           map.put("message" , e.getMessage());
        }
        return map;
    }
}
