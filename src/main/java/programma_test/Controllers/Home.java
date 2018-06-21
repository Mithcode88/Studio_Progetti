package programma_test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Home {


    @ModelAttribute("nome")
    public String nome(){
        return "Daniele";
    }

    @GetMapping
    public String nickname(@RequestParam(name="nickname", defaultValue = "Default") String nickname,
                           @RequestHeader("User-Agent") String userAgent,
                           @RequestParam(name="città") String città,
                           Model model) {
        model.addAttribute("nickname", nickname);
        model.addAttribute("userAgent", userAgent);
        model.addAttribute("city", città);
        return "home";
    }
}
