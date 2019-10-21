package lv.elearning.elearningProject.Controllers;




import lv.elearning.elearningProject.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserPageController {

@Autowired
TokenManager tokenManager;
/*

    @GetMapping("/user")
    public String getHome(ServletRequest servletRequest, ServletResponse servletResponse, Map<String, Object> model){

            HttpServletRequest request = (HttpServletRequest) servletRequest;

        //HttpServletResponse response = (HttpServletResponse) servletResponse;
        //response.addHeader("Authorization", "token");

        AccessToken accessToken = new AccessToken();
        WorkerAccess loginUser = (WorkerAccess) servletRequest.getAttribute("user");

        accessToken.setToken(tokenManager.generateToken((WorkerAccess) request.getAttribute("user")));

        model.put("token", accessToken);


        return "userHomePage";
    }
*/



}
