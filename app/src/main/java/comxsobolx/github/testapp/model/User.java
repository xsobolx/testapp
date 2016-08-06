package comxsobolx.github.testapp.model;

/**
 * Created by aleksandr on 05.08.16.
 */
public class User {
    private String login;
    private String token;
    private String imageUrl;
    private byte[] imageBytes;

    public User(){}

    public User(String login, String token, String imageUrl) {
        this.login = login;
        this.token = token;

        this.imageUrl = imageUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
