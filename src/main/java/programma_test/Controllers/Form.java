package programma_test.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import programma_test.Model.ContactDetails;
import programma_test.Model.ContactForm;
import programma_test.services.ContactService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacts")
public class Form {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ContactService contactService;

    @Autowired
    public Form(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/new")
    public String contactForm(Model model) {
        model.addAttribute(new ContactForm());
        logger.debug("Form -> {}", model);
        return "form";
    }

    @PostMapping("/new")
    public String submitNewContact(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getTarget().toString());
            return "form";
        }

        contactService.save(contactForm);

        ContactDetails details = new ContactDetails();
        details.setFirstName(contactForm.getFirstName());
        details.setLastName(contactForm.getLastName());
        details.setPhone(contactForm.getPhone());
        details.setEmail(contactForm.getEmail());

        model.addAttribute("contact", details);
        return "riepilogo";
    }

    @GetMapping("/{id}")
    public String contactById(@PathVariable("id") Long id, Model model){
        ContactDetails contact = contactService.getDetailsById(id);

        if(contact == null){
            return "redirect:/";
        }

        model.addAttribute("contact", contact);
        return "riepilogo";
    }

    @GetMapping("/all")
    public String allContacts(Model model){

        model.addAttribute("contacts", contactService.getList());
        return "contact-list";
    }

}
