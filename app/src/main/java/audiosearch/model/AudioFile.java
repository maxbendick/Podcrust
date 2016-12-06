
package audiosearch.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "filename",
    "duration",
    "current_status",
    "url",
    "mp3",
    "ogg",
    "listenlen",
    "url_title"
})
public class AudioFile {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("current_status")
    private String currentStatus;
    @JsonProperty("url")
    private List<String> url = new ArrayList<String>();
    @JsonProperty("mp3")
    private String mp3;
    @JsonProperty("ogg")
    private String ogg;
    @JsonProperty("listenlen")
    private String listenlen;
    @JsonProperty("url_title")
    private String urlTitle;

    /**
     *
     * @return
     *     The urlTitle
     */
    @JsonProperty("url_title")
    public String getUrlTitle() { return urlTitle; }


    /**
     *
     * @return
     *     The listenlen
     */
    @JsonProperty("litenlen")
    public String getListenlen() { return listenlen; }

    /**
     *
     * @return
     *     The ogg
     */
    @JsonProperty("ogg")
    public String getOgg() { return ogg; }

    /**
     *
     * @return
     *     The mp3
     */
    @JsonProperty("mp3")
    public String getMp3() { return mp3; }

    /**
     *
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The filename
     */
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    /**
     *
     * @param filename
     *     The filename
     */
    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @return
     *     The duration
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     *     The duration
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     *     The currentStatus
     */
    @JsonProperty("current_status")
    public String getCurrentStatus() {
        return currentStatus;
    }

    /**
     *
     * @param currentStatus
     *     The current_status
     */
    @JsonProperty("current_status")
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     *
     * @return
     *     The url
     */
    @JsonProperty("url")
    public List<String> getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(List<String> url) {
        this.url = url;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }
}
