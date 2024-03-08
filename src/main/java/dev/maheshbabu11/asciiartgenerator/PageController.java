package dev.maheshbabu11.asciiartgenerator;

import io.leego.banana.BananaUtils;
import io.leego.banana.Font;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PageController {

    @GetMapping("/fonts")
    public String getFonts() {
        List<String> options = Font.values().stream().map(Font::getName).toList();
        StringBuilder optionList = new StringBuilder();
        options.forEach(
                option -> {
                    String optionString = "<option value=\"" + option + "\">" + option + "</option>";
                    optionList.append(optionString);
                }
        );
        return optionList.toString();
    }

    @PostMapping("/ascii-art")
    public String asciiArt(@RequestParam("input-text") String inputText,
                           @RequestParam("font-select") String font) {
        return "<pre id=\"ascii-art\">" + BananaUtils.bananaify(inputText, Font.get(font)) + "</pre>";
    }

}
