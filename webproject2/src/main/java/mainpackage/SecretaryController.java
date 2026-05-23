package mainpackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {

    private final SecretariesRepository secretariesRepository;
    private final CoursesRepository coursesRepository;

    public SecretaryController(SecretariesRepository secretariesRepository , CoursesRepository coursesRepository){
        this.secretariesRepository = secretariesRepository;
        this.coursesRepository = coursesRepository;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Θα ψάξει για το αρχείο login.html στα templates
    }
    @PostMapping("/login")
    public String loginProcess(@RequestParam String username , @RequestParam String password, Model model){
        Optional<Secretaries> secretary = secretariesRepository.findByUsername(username);

        if(secretary.isPresent() && secretary.get().getPassword().equals(password)){
            return  "redirect://secretary/dashboard";

        }else {
            model.addAttribute("error","Λάθος Username ή Password ");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Τραβάει όλα τα μαθήματα μαζί με τους καθηγητές τους από τη βάση αυτόματα!
        model.addAttribute("coursesList", coursesRepository.findAll());
        return "dashboard"; // Θα ψάξει για το αρχείο dashboard.html
    }
}
