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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsPageData that = (NewsPageData) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NewsPageData{" +
                "title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                '}';
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
