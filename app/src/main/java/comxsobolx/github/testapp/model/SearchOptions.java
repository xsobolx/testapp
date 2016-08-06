package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr on 05.08.16.
 */
public class SearchOptions {
    @SerializedName("max_age")
    @Expose
    private Integer maxAge;
    @SerializedName("min_age")
    @Expose
    private Integer minAge;
    @SerializedName("is_male")
    @Expose
    private Boolean isMale;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    /**
     *
     * @return
     * The maxAge
     */
    public Integer getMaxAge() {
        return maxAge;
    }

    /**
     *
     * @param maxAge
     * The max_age
     */
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    /**
     *
     * @return
     * The minAge
     */
    public Integer getMinAge() {
        return minAge;
    }

    /**
     *
     * @param minAge
     * The min_age
     */
    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
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
     * The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     * The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

