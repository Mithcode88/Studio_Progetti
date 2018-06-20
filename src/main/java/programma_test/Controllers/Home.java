package programma_test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    String hello(Model model) {
        return "home";
    }
    @ModelAttribute("nome")
    public String nome(){
        return "Daniele";
    }
}
