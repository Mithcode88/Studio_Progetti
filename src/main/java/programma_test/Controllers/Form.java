package programma_test.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import programma_test.Model.ContactDetails;
import programma_test.Model.ContactForm;

@Controller
@RequestMapping("/contacts")
public class Form {

    @GetMapping("/new")
    public String contactForm(Model model) {
        model.addAttribute(new ContactForm());
        return "form";
    }

    @PostMapping("/new")
    public String submitNewContact(@ModelAttribute ContactForm contactForm, Model model) {
        ContactDetails details = new ContactDetails();
        details.setFirstName(contactForm.getFirstName());
        details.setLastName(contactForm.getLastName());
        details.setPhone(contactForm.getPhone());

        model.addAttribute("contact", details);
        return "riepilogo";
    }

}
