package comxsobolx.github.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aleksandr on 05.08.16.
 */
public class Settings {
    @SerializedName("send_by_enter")
    @Expose
    private Boolean sendByEnter;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("send_by_ctrl_enter")
    @Expose
    private Boolean sendByCtrlEnter;
    @SerializedName("searchOptions")
    @Expose
    private SearchOptions searchOptions;

    /**
     *
     * @return
     * The sendByEnter
     */
    public Boolean getSendByEnter() {
        return sendByEnter;
    }

    /**
     *
     * @param sendByEnter
     * The send_by_enter
     */
    public void setSendByEnter(Boolean sendByEnter) {
        this.sendByEnter = sendByEnter;
    }

    /**
     *
     * @return
     * The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The sendByCtrlEnter
     */
    public Boolean getSendByCtrlEnter() {
        return sendByCtrlEnter;
    }

    /**
     *
     * @param sendByCtrlEnter
     * The send_by_ctrl_enter
     */
    public void setSendByCtrlEnter(Boolean sendByCtrlEnter) {
        this.sendByCtrlEnter = sendByCtrlEnter;
    }

    /**
     *
     * @return
     * The searchOptions
     */
    public SearchOptions getSearchOptions() {
        return searchOptions;
    }

    /**
     *
     * @param searchOptions
     * The searchOptions
     */
    public void setSearchOptions(SearchOptions searchOptions) {
        this.searchOptions = searchOptions;
    }
}
