
package edu.calpoly.idulkin.podcrust.rest.SearchShowResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "title",
    "network",
    "categories",
    "description",
    "hosts",
    "ui_url",
    "rss_url",
    "image_files",
    "sc_feed",
    "web_profiles"
})
public class Result {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("network")
    private Network network;
    @JsonProperty("categories")
    private List<Category> categories = new ArrayList<Category>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("hosts")
    private List<Object> hosts = new ArrayList<Object>();
    @JsonProperty("ui_url")
    private String uiUrl;
    @JsonProperty("rss_url")
    private String rssUrl;
    @JsonProperty("image_files")
    private List<ImageFile> imageFiles = new ArrayList<ImageFile>();
    @JsonProperty("sc_feed")
    private String scFeed;
    @JsonProperty("web_profiles")
    private String webProfiles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The network
     */
    @JsonProperty("network")
    public Network getNetwork() {
        return network;
    }

    /**
     * 
     * @param network
     *     The network
     */
    @JsonProperty("network")
    public void setNetwork(Network network) {
        this.network = network;
    }

    /**
     * 
     * @return
     *     The categories
     */
    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The hosts
     */
    @JsonProperty("hosts")
    public List<Object> getHosts() {
        return hosts;
    }

    /**
     * 
     * @param hosts
     *     The hosts
     */
    @JsonProperty("hosts")
    public void setHosts(List<Object> hosts) {
        this.hosts = hosts;
    }

    /**
     * 
     * @return
     *     The uiUrl
     */
    @JsonProperty("ui_url")
    public String getUiUrl() {
        return uiUrl;
    }

    /**
     * 
     * @param uiUrl
     *     The ui_url
     */
    @JsonProperty("ui_url")
    public void setUiUrl(String uiUrl) {
        this.uiUrl = uiUrl;
    }

    /**
     * 
     * @return
     *     The rssUrl
     */
    @JsonProperty("rss_url")
    public String getRssUrl() {
        return rssUrl;
    }

    /**
     * 
     * @param rssUrl
     *     The rss_url
     */
    @JsonProperty("rss_url")
    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    /**
     * 
     * @return
     *     The imageFiles
     */
    @JsonProperty("image_files")
    public List<ImageFile> getImageFiles() {
        return imageFiles;
    }

    /**
     * 
     * @param imageFiles
     *     The image_files
     */
    @JsonProperty("image_files")
    public void setImageFiles(List<ImageFile> imageFiles) {
        this.imageFiles = imageFiles;
    }

    /**
     * 
     * @return
     *     The scFeed
     */
    @JsonProperty("sc_feed")
    public String getScFeed() {
        return scFeed;
    }

    /**
     * 
     * @param scFeed
     *     The sc_feed
     */
    @JsonProperty("sc_feed")
    public void setScFeed(String scFeed) {
        this.scFeed = scFeed;
    }

    /**
     * 
     * @return
     *     The webProfiles
     */
    @JsonProperty("web_profiles")
    public String getWebProfiles() {
        return webProfiles;
    }

    /**
     * 
     * @param webProfiles
     *     The web_profiles
     */
    @JsonProperty("web_profiles")
    public void setWebProfiles(String webProfiles) {
        this.webProfiles = webProfiles;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
