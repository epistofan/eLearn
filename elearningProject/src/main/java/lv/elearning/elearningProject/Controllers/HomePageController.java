package lv.elearning.elearningProject.Controllers;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {



    /*@GetMapping("/home")
    public String getHome(){


        return "home1";
    }*/

    @GetMapping("/")
    public String loginPage(){


        return "loginPage";
    }

}
