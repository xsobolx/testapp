package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aleksandr on 05.08.16.
 */
public class Result implements Serializable{
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("settings")
    @Expose
    private Settings settings;
    @SerializedName("cdn_base_url")
    @Expose
    private String cdnBaseUrl;
    @SerializedName("badge")
    @Expose
    private Integer badge;
    @SerializedName("jwt_token")
    @Expose
    private String jwtToken;
    @SerializedName("permissions")
    @Expose
    private Permissions permissions;

    /**
     *
     * @return
     * The profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     * The profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     *
     * @return
     * The settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     *
     * @param settings
     * The settings
     */
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    /**
     *
     * @return
     * The cdnBaseUrl
     */
    public String getCdnBaseUrl() {
        return cdnBaseUrl;
    }

    /**
     *
     * @param cdnBaseUrl
     * The cdn_base_url
     */
    public void setCdnBaseUrl(String cdnBaseUrl) {
        this.cdnBaseUrl = cdnBaseUrl;
    }

    /**
     *
     * @return
     * The badge
     */
    public Integer getBadge() {
        return badge;
    }

    /**
     *
     * @param badge
     * The badge
     */
    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    /**
     *
     * @return
     * The jwtToken
     */
    public String getJwtToken() {
        return jwtToken;
    }

    /**
     *
     * @param jwtToken
     * The jwt_token
     */
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    /**
     *
     * @return
     * The permissions
     */
    public Permissions getPermissions() {
        return permissions;
    }

    /**
     *
     * @param permissions
     * The permissions
     */
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
}
