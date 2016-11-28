package edu.calpoly.idulkin.podcrust;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import audiosearch.model.AudioFile;
import audiosearch.model.Category;
import audiosearch.model.Entity;
import audiosearch.model.EpisodeResult;
import audiosearch.model.ImageFile;

/**
 * Created by Jonathan Chianglin on 11/27/2016.
 */

public class SearchAudio implements Parcelable{
    // EpisodeResult object from EpisodeQueryResult
    private EpisodeResult er;
    // AudioFile object from List<AudioFile> from EpisodeResult.getAudioFiles()
    private AudioFile af;
    /*
     * The follow are from EpisodeResult
     */
    // ID for the item
    private int id;
    // title for the item
    private String title;
    // OPTIONAL description of the audio file
    private String description;
    // OPTIONAL created date for the item
    private String date_created;
    // Date added to Audiosear.ch
    private String date_added;
    // OPTIONAL link to external permanent url
    private String identifier;
    // Show ID that the returned item belongs to
    private int show_id;
    // Show title associated with the returned item
    private String show_title;
    // OPTIONAL External item page of source material
    private String digital_location;
    // OPTIONAL episode import source
    private String physical_location;
    // OPTIONAL length of audio file
    private int erduration;
    // OPTIONAL date and time the show was last updated
    private String updated_at;
    // OPTIONAL the show network
    private String network;
    // OPTIONAL iTunes episode id
    private int itunes_episode;
    // OPTIONAL categories
    private List<Category> categories;
    // OPTIONAL array of audio files attributes
    private List<AudioFile> audio_files;
    // OPTIONAL array of entities related to the item
    private List<Entity> entities;
    // OPTIONAL array of ImageFiles
    private List<ImageFile> imageFiles;

    /*
     * The following are from AudioFile
     */
    // AudioFile Filename
    private String filename;
    // AudioFile duration
    private String afduration;
    // Status of audio file processing in Audiosear.ch
    private String currentStatus;
    // "Optional", Absolute paths to audio files
    private List<String> url = new ArrayList<String>();
    // mp3 link (String)
    private String mp3;
    // ogg file
    private String ogg;
    /*
     * Listen length
     * short or long
     */
    private String listenlen;
    // URL Title
    private String urlTitle;

    public SearchAudio(EpisodeResult er, AudioFile af) {
        this.er = er;
        this.af = af;
        this.id = er.getId();
        this.title = er.getTitle();
        this.description = er.getDescription();
        this.date_created = er.getDateCreated();
        this.date_added = er.getDateAdded();
        this.identifier = er.getIdentifier();
        this.show_id = er.getShowId();
        this.show_title = er.getShowTitle();
        this.digital_location = er.getDigitalLocation();
        this.physical_location = er.getPhysicalLocation();
        this.erduration = er.getDuration();
        this.updated_at = er.getUpdatedAt();
        this.network = er.getNetwork();
        this.categories = er.getCategories();
        this.audio_files = er.getAudioFiles();
        this.entities = er.getEntities();
        this.imageFiles = er.getImageFiles();
        //
        this.filename = af.getFilename();
        this.afduration = af.getDuration();
        this.currentStatus = af.getCurrentStatus();
        this.url = af.getUrl();
        this.mp3 = af.getMp3();
        this.ogg = af.getOgg();
        this.listenlen = af.getListenlen();
        this.urlTitle = af.getUrlTitle();
    }

    public SearchAudio(String title, String mp3) {
        this.title = title;
        this.mp3 = mp3;
    }

    public static final Parcelable.Creator<SearchAudio> CREATOR = new Parcelable.Creator<SearchAudio>() {
        @Override
        public SearchAudio createFromParcel(Parcel in) {
            SearchAudio e = new SearchAudio(in.readString(), in.readString());
            return e;
        }

        @Override
        public SearchAudio[] newArray(int size) {
            return new SearchAudio[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(mp3);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getter and setter methods below
    public EpisodeResult getEr() {
        return er;
    }

    public void setEr(EpisodeResult er) {
        this.er = er;
    }

    public AudioFile getAf() {
        return af;
    }

    public void setAf(AudioFile af) {
        this.af = af;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public String getShow_title() {
        return show_title;
    }

    public void setShow_title(String show_title) {
        this.show_title = show_title;
    }

    public String getDigital_location() {
        return digital_location;
    }

    public void setDigital_location(String digital_location) {
        this.digital_location = digital_location;
    }

    public String getPhysical_location() {
        return physical_location;
    }

    public void setPhysical_location(String physical_location) {
        this.physical_location = physical_location;
    }

    public int getErduration() {
        return erduration;
    }

    public void setErduration(int erduration) {
        this.erduration = erduration;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public int getItunes_episode() {
        return itunes_episode;
    }

    public void setItunes_episode(int itunes_episode) {
        this.itunes_episode = itunes_episode;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<AudioFile> getAudio_files() {
        return audio_files;
    }

    public void setAudio_files(List<AudioFile> audio_files) {
        this.audio_files = audio_files;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<ImageFile> getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(List<ImageFile> imageFiles) {
        this.imageFiles = imageFiles;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAfduration() {
        return afduration;
    }

    public void setAfduration(String afduration) {
        this.afduration = afduration;
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
