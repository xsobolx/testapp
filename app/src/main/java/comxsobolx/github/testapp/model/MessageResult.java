package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr on 06.08.16.
 */
public class MessageResult {

    @SerializedName("uid")
    @Expose
    private String uid;

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

}
