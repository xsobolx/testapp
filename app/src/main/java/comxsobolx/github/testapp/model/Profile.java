package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandr on 05.08.16.
 */
public class Profile implements Serializable{
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("is_birthday")
    @Expose
    private Boolean isBirthday;
    @SerializedName("birth_date")
    @Expose
    private String birthDate;
    @SerializedName("is_male")
    @Expose
    private Boolean isMale;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("google_place_id")
    @Expose
    private String googlePlaceId;
    @SerializedName("search_sort_timestamp")
    @Expose
    private Double searchSortTimestamp;
    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = new ArrayList<Photo>();
    @SerializedName("real_status_check_code")
    @Expose
    private String realStatusCheckCode;

    /**
     *
     * @return
     * The uid
     */
    public String getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     * The uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The phone
     */
    public Object getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(Object phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The isBirthday
     */
    public Boolean getIsBirthday() {
        return isBirthday;
    }

    /**
     *
     * @param isBirthday
     * The is_birthday
     */
    public void setIsBirthday(Boolean isBirthday) {
        this.isBirthday = isBirthday;
    }

    /**
     *
     * @return
     * The birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     * The birth_date
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     * The isMale
     */
    public Boolean getIsMale() {
        return isMale;
    }

    /**
     *
     * @param isMale
     * The is_male
     */
    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     * The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     * The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The googlePlaceId
     */
    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    /**
     *
     * @param googlePlaceId
     * The google_place_id
     */
    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    /**
     *
     * @return
     * The searchSortTimestamp
     */
    public Double getSearchSortTimestamp() {
        return searchSortTimestamp;
    }

    /**
     *
     * @param searchSortTimestamp
     * The search_sort_timestamp
     */
    public void setSearchSortTimestamp(Double searchSortTimestamp) {
        this.searchSortTimestamp = searchSortTimestamp;
    }

    /**
     *
     * @return
     * The avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     * The avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     * The photos
     */
    public List<Photo> getPhotos() {
        return photos;
    }

    /**
     *
     * @param photos
     * The photos
     */
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    /**
     *
     * @return
     * The realStatusCheckCode
     */
    public String getRealStatusCheckCode() {
        return realStatusCheckCode;
    }

    /**
     *
     * @param realStatusCheckCode
     * The real_status_check_code
     */
    public void setRealStatusCheckCode(String realStatusCheckCode) {
        this.realStatusCheckCode = realStatusCheckCode;
    }
}
