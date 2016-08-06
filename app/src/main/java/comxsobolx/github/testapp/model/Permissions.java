package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandr on 05.08.16.
 */
public class Permissions {
    @SerializedName("error_codes")
    @Expose
    private List<Object> errorCodes = new ArrayList<Object>();
    @SerializedName("has_full_access")
    @Expose
    private Boolean hasFullAccess;

    /**
     *
     * @return
     * The errorCodes
     */
    public List<Object> getErrorCodes() {
        return errorCodes;
    }

    /**
     *
     * @param errorCodes
     * The error_codes
     */
    public void setErrorCodes(List<Object> errorCodes) {
        this.errorCodes = errorCodes;
    }

    /**
     *
     * @return
     * The hasFullAccess
     */
    public Boolean getHasFullAccess() {
        return hasFullAccess;
    }

    /**
     *
     * @param hasFullAccess
     * The has_full_access
     */
    public void setHasFullAccess(Boolean hasFullAccess) {
        this.hasFullAccess = hasFullAccess;
    }
}
