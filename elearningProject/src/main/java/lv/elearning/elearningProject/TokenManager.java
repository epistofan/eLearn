package lv.elearning.elearningProject;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import lv.elearning.elearningProject.Domain.WorkerAccess;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class TokenManager {

protected Double secretDigit = 0.2545541578;


    public String generateToken(WorkerAccess workerAccess){

        String jwtToken = "";


        //secretDigit = Math.random();

        String secret  = String.valueOf(secretDigit);

        jwtToken = Jwts.builder().setSubject("test").claim("user", workerAccess).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret).compact();

            System.out.print(secret);



        return jwtToken;
    }

        public WorkerAccess parseToken(String token){



            String secretForDecrypt = String.valueOf(secretDigit);



            final Claims claims = Jwts.parser().setSigningKey(secretForDecrypt).parseClaimsJws(token).getBody();
            WorkerAccess workerAccess = new WorkerAccess() ;
           HashMap userInfoMap = (HashMap) claims.get("user");

       workerAccess.setWorkerId((Integer) userInfoMap.get("workerId"));
       workerAccess.setUsername((String) userInfoMap.get("username"));
       workerAccess.setPassword((String) userInfoMap.get("password"));
       workerAccess.setRole((String) userInfoMap.get("role"));

        return workerAccess;
}




}
