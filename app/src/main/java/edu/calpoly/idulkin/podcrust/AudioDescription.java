package edu.calpoly.idulkin.podcrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import audiosearch.model.AudioFile;
import audiosearch.model.Category;
import audiosearch.model.ImageUrls;
import audiosearch.model.RelatedEpisodes;
import audiosearch.model.Urls;

/**
 * Created by Danny Chianglin on 11/8/2016.
 */

public class AudioDescription {
    /*
     * RelatedEpisode object from TrendResult
     */
    private RelatedEpisodes rE;
    /*
     * AudioFile object from the RelatedEpisode
     */
    private AudioFile aF;
    /*
     * Episode id
     */
    private Integer id;
    /*
     * Episode title
     */
    private String title;
    /*
     * Series (show) iD
     */
    private Integer showId;
    /*
     * Series (show) title
     */
    private String showTitle;
    /*
     * Network
     */
    private String network;
    /*
     * List of categories with parent_id, name, name_lc, id
     * All can call getter method
     */
    private List<Category> categories = new ArrayList<Category>();
    /*
     * List of AudioFiles (usually one) with id, filename, duration, current_status, urls (according to schema)
     * duration, mp3, listenlen (listenlength: short/long), url_title, id, ogg
     */
    private List<AudioFile> audioFiles = new ArrayList<AudioFile>();
    /*
     * ImageUrls for thumbnail and full-size (thumb and full)
     * imageUrl.getThumb() and imageUrl.getFull()
     * imageUrl.setThumb() and imageUrl.setFull()
     */
    private ImageUrls imageUrls;
    /*
     * Urls : "self" in a json format and "ui" go to episode's page on the web
     * Urls.self = API URL
     * Urls.ui   = Audiosear.ch URL
     */
    private Urls urls;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    /*
     * AudioFile Filename
     */
    private String filename;
    /*
     * AudioFile duration
     */
    private String duration;
    /*
     * Status of audio file processing in Audiosear.ch
     */
    private String currentStatus;
    /*
     * "Optional", Absolute paths to audio files
     */
    private List<String> url = new ArrayList<String>();
    /*
     * mp3 link (String)
     */
    private String mp3;
    /*
     * ogg file
     */
    private String ogg;
    /*
     * Listen length
     * short or long
     */
    private String listenlen;
    /*
     * URL Title
     */
    private String urlTitle;

    public AudioDescription(RelatedEpisodes rE, AudioFile aF) {
        this.rE = rE;
        this.aF = aF;
        this.id = rE.getId();
        this.title = rE.getTitle();
        this.showId = rE.getShowId();
        this.showTitle = rE.getShowTitle();
        this.network = rE.getNetwork();
        this.categories = rE.getCategories();
        this.audioFiles = rE.getAudioFiles();
        this.imageUrls = rE.getImageUrls();
        this.urls = rE.getUrls();
        this.additionalProperties = rE.getAdditionalProperties();
        this.filename = aF.getFilename();
        this.duration = aF.getDuration();
        this.currentStatus = aF.getCurrentStatus();
        this.url = aF.getUrl();
        this.mp3 = aF.getMp3();
        this.ogg = aF.getOgg();
        this.listenlen = aF.getListenlen();
        this.urlTitle = aF.getUrlTitle();
    }

    public RelatedEpisodes getrE() {
        return rE;
    }

    public void setrE(RelatedEpisodes rE) {
        this.rE = rE;
    }

    public AudioFile getaF() {
        return aF;
    }

    public void setaF(AudioFile aF) {
        this.aF = aF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<AudioFile> getAudioFiles() {
        return audioFiles;
    }

    public void setAudioFiles(List<AudioFile> audioFiles) {
        this.audioFiles = audioFiles;
    }

    public ImageUrls getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ImageUrls imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getOgg() {
        return ogg;
    }

    public void setOgg(String ogg) {
        this.ogg = ogg;
    }

    public String getListenlen() {
        return listenlen;
    }

    public void setListenlen(String listenlen) {
        this.listenlen = listenlen;
    }

    public String getUrlTitle() {
        return urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }

}
