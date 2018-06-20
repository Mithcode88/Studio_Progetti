package programma_test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class Form {

    @GetMapping
    public String unSalutoConParametro() {
        return "form";
    }
    @GetMapping(params = "username")
    @ModelAttribute("username")
    public String nome(){
        return "Daniele";
    }


}
