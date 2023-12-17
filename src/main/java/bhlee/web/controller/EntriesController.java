package bhlee.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntriesController {
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("greeting", "HI");
        return "hello";
    }
}
