
package edu.calpoly.idulkin.podcrust.rest.SearchShowResult;

import java.util.HashMap;
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
    "item_id",
    "file",
    "is_uploaded",
    "upload_id",
    "created_at",
    "updated_at",
    "original_file_url",
    "storage_id",
    "imageable_id",
    "imageable_type",
    "extra",
    "md5hash"
})
public class ImageFile {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("item_id")
    private Object itemId;
    @JsonProperty("file")
    private File file;
    @JsonProperty("is_uploaded")
    private Object isUploaded;
    @JsonProperty("upload_id")
    private Object uploadId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("original_file_url")
    private String originalFileUrl;
    @JsonProperty("storage_id")
    private Integer storageId;
    @JsonProperty("imageable_id")
    private Integer imageableId;
    @JsonProperty("imageable_type")
    private String imageableType;
    @JsonProperty("extra")
    private Extra extra;
    @JsonProperty("md5hash")
    private String md5hash;
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
     *     The itemId
     */
    @JsonProperty("item_id")
    public Object getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId
     *     The item_id
     */
    @JsonProperty("item_id")
    public void setItemId(Object itemId) {
        this.itemId = itemId;
    }

    /**
     * 
     * @return
     *     The file
     */
    @JsonProperty("file")
    public File getFile() {
        return file;
    }

    /**
     * 
     * @param file
     *     The file
     */
    @JsonProperty("file")
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 
     * @return
     *     The isUploaded
     */
    @JsonProperty("is_uploaded")
    public Object getIsUploaded() {
        return isUploaded;
    }

    /**
     * 
     * @param isUploaded
     *     The is_uploaded
     */
    @JsonProperty("is_uploaded")
    public void setIsUploaded(Object isUploaded) {
        this.isUploaded = isUploaded;
    }

    /**
     * 
     * @return
     *     The uploadId
     */
    @JsonProperty("upload_id")
    public Object getUploadId() {
        return uploadId;
    }

    /**
     * 
     * @param uploadId
     *     The upload_id
     */
    @JsonProperty("upload_id")
    public void setUploadId(Object uploadId) {
        this.uploadId = uploadId;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The updated_at
     */
    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The originalFileUrl
     */
    @JsonProperty("original_file_url")
    public String getOriginalFileUrl() {
        return originalFileUrl;
    }

    /**
     * 
     * @param originalFileUrl
     *     The original_file_url
     */
    @JsonProperty("original_file_url")
    public void setOriginalFileUrl(String originalFileUrl) {
        this.originalFileUrl = originalFileUrl;
    }

    /**
     * 
     * @return
     *     The storageId
     */
    @JsonProperty("storage_id")
    public Integer getStorageId() {
        return storageId;
    }

    /**
     * 
     * @param storageId
     *     The storage_id
     */
    @JsonProperty("storage_id")
    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    /**
     * 
     * @return
     *     The imageableId
     */
    @JsonProperty("imageable_id")
    public Integer getImageableId() {
        return imageableId;
    }

    /**
     * 
     * @param imageableId
     *     The imageable_id
     */
    @JsonProperty("imageable_id")
    public void setImageableId(Integer imageableId) {
        this.imageableId = imageableId;
    }

    /**
     * 
     * @return
     *     The imageableType
     */
    @JsonProperty("imageable_type")
    public String getImageableType() {
        return imageableType;
    }

    /**
     * 
     * @param imageableType
     *     The imageable_type
     */
    @JsonProperty("imageable_type")
    public void setImageableType(String imageableType) {
        this.imageableType = imageableType;
    }

    /**
     * 
     * @return
     *     The extra
     */
    @JsonProperty("extra")
    public Extra getExtra() {
        return extra;
    }

    /**
     * 
     * @param extra
     *     The extra
     */
    @JsonProperty("extra")
    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    /**
     * 
     * @return
     *     The md5hash
     */
    @JsonProperty("md5hash")
    public String getMd5hash() {
        return md5hash;
    }

    /**
     * 
     * @param md5hash
     *     The md5hash
     */
    @JsonProperty("md5hash")
    public void setMd5hash(String md5hash) {
        this.md5hash = md5hash;
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
