
package com.test.pixabaydemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pageURL")
    @Expose
    private String pageURL;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("previewURL")
    @Expose
    private String previewURL;
    @SerializedName("previewWidth")
    @Expose
    private Integer previewWidth;
    @SerializedName("previewHeight")
    @Expose
    private Integer previewHeight;
    @SerializedName("webformatURL")
    @Expose
    private String webformatURL;
    @SerializedName("webformatWidth")
    @Expose
    private Integer webformatWidth;
    @SerializedName("webformatHeight")
    @Expose
    private Integer webformatHeight;
    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;
    @SerializedName("fullHDURL")
    @Expose
    private String fullHDURL;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("imageWidth")
    @Expose
    private Integer imageWidth;
    @SerializedName("imageHeight")
    @Expose
    private Integer imageHeight;
    @SerializedName("imageSize")
    @Expose
    private Integer imageSize;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("downloads")
    @Expose
    private Integer downloads;
    @SerializedName("favorites")
    @Expose
    private Integer favorites;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;
    public final static Parcelable.Creator<Hit> CREATOR = new Creator<Hit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Hit createFromParcel(Parcel in) {
            return new Hit(in);
        }

        public Hit[] newArray(int size) {
            return (new Hit[size]);
        }

    }
    ;

    protected Hit(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.tags = ((String) in.readValue((String.class.getClassLoader())));
        this.previewURL = ((String) in.readValue((String.class.getClassLoader())));
        this.previewWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.previewHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.webformatURL = ((String) in.readValue((String.class.getClassLoader())));
        this.webformatWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.webformatHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.largeImageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.fullHDURL = ((String) in.readValue((String.class.getClassLoader())));
        this.imageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.imageWidth = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imageHeight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imageSize = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.views = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.downloads = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.favorites = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.comments = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.user = ((String) in.readValue((String.class.getClassLoader())));
        this.userImageURL = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Hit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public Integer getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(Integer previewWidth) {
        this.previewWidth = previewWidth;
    }

    public Integer getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(Integer previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public Integer getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(Integer webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public Integer getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(Integer webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getFullHDURL() {
        return fullHDURL;
    }

    public void setFullHDURL(String fullHDURL) {
        this.fullHDURL = fullHDURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(pageURL);
        dest.writeValue(type);
        dest.writeValue(tags);
        dest.writeValue(previewURL);
        dest.writeValue(previewWidth);
        dest.writeValue(previewHeight);
        dest.writeValue(webformatURL);
        dest.writeValue(webformatWidth);
        dest.writeValue(webformatHeight);
        dest.writeValue(largeImageURL);
        dest.writeValue(fullHDURL);
        dest.writeValue(imageURL);
        dest.writeValue(imageWidth);
        dest.writeValue(imageHeight);
        dest.writeValue(imageSize);
        dest.writeValue(views);
        dest.writeValue(downloads);
        dest.writeValue(favorites);
        dest.writeValue(likes);
        dest.writeValue(comments);
        dest.writeValue(userId);
        dest.writeValue(user);
        dest.writeValue(userImageURL);
    }

    public int describeContents() {
        return  0;
    }

}
