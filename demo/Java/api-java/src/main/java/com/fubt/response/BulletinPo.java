package com.fubt.response;

/**
 * @Description 公告
 * @auther:
 * @date: 20190919
 */
public class BulletinPo {

    private Number id;
    private String title;
    private String keyword;
    private Number showClientId;
    private String isRoll;
    private Number newsTypeId;
    private String content;
    private String createTime;
    private String updateTime;
    private String creator;
    private String modifier;
    private Number version;
    private String language;
    private Number templateId;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Number getShowClientId() {
        return showClientId;
    }

    public void setShowClientId(Number showClientId) {
        this.showClientId = showClientId;
    }

    public String getIsRoll() {
        return isRoll;
    }

    public void setIsRoll(String isRoll) {
        this.isRoll = isRoll;
    }

    public Number getNewsTypeId() {
        return newsTypeId;
    }

    public void setNewsTypeId(Number newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Number getVersion() {
        return version;
    }

    public void setVersion(Number version) {
        this.version = version;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Number getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Number templateId) {
        this.templateId = templateId;
    }
}
