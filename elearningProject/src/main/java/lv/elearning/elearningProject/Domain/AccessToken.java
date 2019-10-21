package lv.elearning.elearningProject.Domain;

import org.springframework.stereotype.Component;

@Component
public class AccessToken {

    private String token;
    private String homeUrl;

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String url) {
        this.homeUrl = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
