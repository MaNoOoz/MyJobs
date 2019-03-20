package com.manooz.myjobs.POJO;

public class Website {

    private String websiteName;
    private String websiteDisc;
    private String key;
    private int websiteIcon;

    public Website(String websiteName, String websiteDisc, String key, int websiteIcon) {
        this.websiteName = websiteName;
        this.websiteDisc = websiteDisc;
        this.key = key;
        this.websiteIcon = websiteIcon;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteDisc() {
        return websiteDisc;
    }

    public void setWebsiteDisc(String websiteDisc) {
        this.websiteDisc = websiteDisc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getWebsiteIcon() {
        return websiteIcon;
    }

    public void setWebsiteIcon(int websiteIcon) {
        this.websiteIcon = websiteIcon;
    }
    public void setValues(Website updatedValue) {
        this.websiteName = updatedValue.websiteName;
        this.websiteDisc = updatedValue.websiteDisc;

    }
}
