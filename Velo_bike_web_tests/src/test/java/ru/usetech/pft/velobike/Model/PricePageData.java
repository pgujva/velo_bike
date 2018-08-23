package ru.usetech.pft.velobike.Model;

import org.openqa.selenium.WebElement;

public class PricePageData {
    private String title;
    private String text;
    private String price;
    private String image;
    private WebElement url;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(WebElement url) {
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

    public WebElement getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "PricePageData{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricePageData that = (PricePageData) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    public PricePageData(String title, String text, String price, String image , WebElement url) {
        this.title = title;
        this.text = text;
        this.price = price;

        this.url = url;
        this.image = image;
    }
}
