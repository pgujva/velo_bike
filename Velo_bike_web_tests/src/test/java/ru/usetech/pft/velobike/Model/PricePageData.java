package ru.usetech.pft.velobike.Model;

public class PricePageData {
    private String title;
    private String text;
    private String price;
    private String url;
    private String image;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {

        return title;
    }

    public String getText() {
        return text;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public PricePageData(String title, String text, String price, String url, String image) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.url = url;
        this.image = image;
    }
}
