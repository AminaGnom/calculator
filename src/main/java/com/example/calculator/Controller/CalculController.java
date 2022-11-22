package com.example.calculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculController {
    @GetMapping("/")
    public String greeting(Model model) {

        return "Post";
    }
    @PostMapping("/Post")
    public String PostRes(@RequestParam(value = "Value1",  required = false)
                              String a,@RequestParam(value = "Operations",  required = false)
    String b,@RequestParam(value = "Value2",  required = false)
    String c, Model model) {
        double answer;
        String Resault = "Произошла ошибка";
        try {
            if (b.equals("+")) {
                answer = Double.parseDouble(a) + Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
            if (b.equals("-")) {
                answer = Double.parseDouble(a) - Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
            if (b.equals("*")) {
                answer = Double.parseDouble(a) * Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
            if (b.equals("/") && !c.equals("0")) {
                answer = Double.parseDouble(a) / Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }

        } catch (NumberFormatException e) {
            model.addAttribute("operat", Resault);
        }
        return "Result";
    }
    @GetMapping("/Get")
    public String GetRes(@RequestParam(value = "Value1",  required = false, defaultValue = "1")
                             String a,@RequestParam(value = "Operations",  required = false, defaultValue = "2")
    String b,@RequestParam(value = "Value2",  required = false, defaultValue = "3")
    String c, Model model) {
        double answer;
        String Resault = "Вы не выбрали значения";

        try {
            if (b.equals("+")) {
                answer = Double.parseDouble(a) + Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
            if (b.equals("-")) {
                answer = Double.parseDouble(a) - Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
            if (b.equals("*")) {
                answer = Double.parseDouble(a) * Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
            if (b.equals("/") && !c.equals("0")) {
                answer = Double.parseDouble(a) / Double.parseDouble(c);
                model.addAttribute("operat", answer);
            }
        } catch (NumberFormatException e) {
            model.addAttribute("operat", Resault);
        }
        return "Get";
    }
}


