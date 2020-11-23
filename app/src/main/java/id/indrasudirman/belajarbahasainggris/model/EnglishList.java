package id.indrasudirman.belajarbahasainggris.model;

public class EnglishList {
    private String name;
    private int numOfPages;
    private int thumbnail;

    public EnglishList() {
        //Default constructor
    }

    public EnglishList(String name, int numOfPages, int thumbnail) {
        this.name = name;
        this.numOfPages = numOfPages;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
