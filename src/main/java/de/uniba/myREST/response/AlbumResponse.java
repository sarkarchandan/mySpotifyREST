package de.uniba.myREST.response;

import com.wrapper.spotify.models.*;

import java.util.List;

/**
 * Creates custom datatype for AlbumResponse
 * This class will be used to model the object for all album search
 * Created by chandan on 06.09.16.
 */
public class AlbumResponse {

    private String albumId;
    private String albumType;
    private List<String> albumAvailableMarkets;
    private List<ImageResponse> albumImages;
    private String albumHref;
    private String albumName;
    private String uri;




    /*
     * Constructors
     */
    public AlbumResponse() {
    }

    public AlbumResponse(String albumId, String albumType, List<String> albumAvailableMarkets, List<ImageResponse> albumImages, String albumHref, String albumName, String uri) {
        this.albumId = albumId;
        this.albumType = albumType;
        this.albumAvailableMarkets = albumAvailableMarkets;
        this.albumImages = albumImages;
        this.albumHref = albumHref;
        this.albumName = albumName;
        this.uri = uri;
    }


    /*
     * Getter and Setter methods for the instance varibales
     */
    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public List<String> getAlbumAvailableMarkets() {
        return albumAvailableMarkets;
    }

    public void setAlbumAvailableMarkets(List<String> albumAvailableMarkets) {
        this.albumAvailableMarkets = albumAvailableMarkets;
    }

    public List<ImageResponse> getAlbumImages() {
        return albumImages;
    }

    public void setAlbumImages(List<ImageResponse> albumImages) {
        this.albumImages = albumImages;
    }

    public String getAlbumHref() {
        return albumHref;
    }

    public void setAlbumHref(String albumHref) {
        this.albumHref = albumHref;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
