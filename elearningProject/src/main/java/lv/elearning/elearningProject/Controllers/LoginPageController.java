package lv.elearning.elearningProject.Controllers;



import lv.elearning.elearningProject.DAL.Repository;
import lv.elearning.elearningProject.Domain.AccessToken;
import lv.elearning.elearningProject.Domain.WorkerAccess;
import lv.elearning.elearningProject.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginPageController {


    @Autowired
    Repository repository;
    @Autowired
    TokenManager tokenManager;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //@ResponseBody
        public String login(ServletRequest servletRequest, ServletResponse servletResponse, Map<String, Object> model) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.getHeader("Authorization");

        String authHeader [] = request.getHeader("Authorization").split(", ");

        WorkerAccess workerAccess;
        workerAccess = repository.getWorkerAccessUser(authHeader[0], authHeader[1]);


        response.addHeader("photo",repository.getWorker(workerAccess.getWorkerId()).getPhoto());


        String url = "http://10.10.10.100:8888";

        if (workerAccess.getUsername() == null) {

            url = "http://10.10.10.100:8888";

        } else if (workerAccess.getUsername().equals(authHeader[0]) && workerAccess.getPassword().equals(authHeader[1]) && workerAccess.getRole().equals("slave")){



            AccessToken accessToken = new AccessToken();

            //tokenManager.generateToken(workerAccess);

            //accessToken.setToken(tokenManager.generateToken((WorkerAccess) request.getAttribute("user")));
            accessToken.setToken(tokenManager.generateToken(workerAccess));
            response.setHeader("Authorization", accessToken.getToken());
            response.addHeader("user", repository.getWorker(workerAccess.getWorkerId()).getFirstName());
            model.put("user", repository.getWorker(workerAccess.getWorkerId()));

            url =  "userHomePage";



        }else if(workerAccess.getPassword().equals(authHeader[1]) && workerAccess.getRole().equals("master") ){
            AccessToken accessToken = new AccessToken();

            //tokenManager.generateToken(workerAccess);

            //accessToken.setToken(tokenManager.generateToken((WorkerAccess) request.getAttribute("user")));
            accessToken.setToken(tokenManager.generateToken(workerAccess));
            response.setHeader("Authorization", accessToken.getToken());
            response.addHeader("user", repository.getWorker(workerAccess.getWorkerId()).getFirstName());
            model.put("user", repository.getWorker(workerAccess.getWorkerId()));

            url = "home";
        }

        return url;
    }


}
