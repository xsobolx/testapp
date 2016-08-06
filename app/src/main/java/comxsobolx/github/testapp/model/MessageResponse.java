package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr on 06.08.16.
 */
public class MessageResponse {
    @SerializedName("api_version")
    @Expose
    private String apiVersion;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private MessageResult result;

    /**
     *
     * @return
     * The apiVersion
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     *
     * @param apiVersion
     * The api_version
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     *
     * @return
     * The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @param statusCode
     * The status_code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The result
     */
    public MessageResult getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(MessageResult result) {
        this.result = result;
    }

}
