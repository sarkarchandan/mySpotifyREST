package de.uniba.myREST.response;

/**
 * Creates custom datatype for
 * Created by chandan on 06.09.16.
 */
public class ImageResponse {

    private int imageHeight;
    private String imageUrl;
    private int imageWidth;

    /*
     * Constructors
     */
    public ImageResponse() {
    }

    public ImageResponse(int imageHeight, String imageUrl, int imageWidth) {
        this.imageHeight = imageHeight;
        this.imageUrl = imageUrl;
        this.imageWidth = imageWidth;
    }

    /*
     * Getter and Setter methods for instance variables
     */
    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }
}
