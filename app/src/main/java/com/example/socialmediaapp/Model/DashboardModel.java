package com.example.socialmediaapp.Model;
public class DashboardModel {
    int profile, postImage, save,line;
    String name, about, like, comment, share;

    public DashboardModel(int profile, int postImage, int save,int line, String name, String about, String like, String comment, String share) {
        this.profile = profile;
        this.postImage = postImage;
        this.save = save;
        this.name = name;
        this.about = about;
        this.like = like;
        this.comment = comment;
        this.share = share;
        this.line=line;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }
    public int getlineImage() {
        return getlineImage();
    }

    public void setShare(String share) {
        this.share = share;
    }
}
