package ru.usetech.pft.velobike.Model;

public class NewsPageData {
    public String title;
    public String data;
    public String text;
    public String url;
    public NewsPageData(String title, String data, String text, String url) {
        this.title = title;
        this.data = data;
        this.text = text;
        this.data = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
