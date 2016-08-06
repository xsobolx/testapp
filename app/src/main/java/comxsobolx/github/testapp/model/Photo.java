package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr on 05.08.16.
 */
public class Photo {
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sort_timestamp")
    @Expose
    private Double sortTimestamp;
    @SerializedName("cdn_uid")
    @Expose
    private String cdnUid;

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
     * The isHidden
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     *
     * @param isHidden
     * The is_hidden
     */
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     *
     * @return
     * The album
     */
    public String getAlbum() {
        return album;
    }

    /**
     *
     * @param album
     * The album
     */
    public void setAlbum(String album) {
        this.album = album;
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
     * The sortTimestamp
     */
    public Double getSortTimestamp() {
        return sortTimestamp;
    }

    /**
     *
     * @param sortTimestamp
     * The sort_timestamp
     */
    public void setSortTimestamp(Double sortTimestamp) {
        this.sortTimestamp = sortTimestamp;
    }

    /**
     *
     * @return
     * The cdnUid
     */
    public String getCdnUid() {
        return cdnUid;
    }

    /**
     *
     * @param cdnUid
     * The cdn_uid
     */
    public void setCdnUid(String cdnUid) {
        this.cdnUid = cdnUid;
    }
}
