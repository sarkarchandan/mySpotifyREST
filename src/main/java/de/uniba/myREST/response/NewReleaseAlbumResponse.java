package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for NewReleased Albums
 * Created by chandan on 08.09.16.
 */
public class NewReleaseAlbumResponse {


    private String newReleaseAlbumId;
    private String newReleaseAlbumName;
    private List<SimpleArtistResponse> newReleaseAlbumArtists;
    private List<ImageResponse> newReleaseAlbumImages;
    private String newReleaseAlbumHref;
    private String newReleaseAlbumUri;

    /*
     * Constructors
     */
    public NewReleaseAlbumResponse() {
    }

    public NewReleaseAlbumResponse(String newReleaseAlbumId, String newReleaseAlbumName, List<SimpleArtistResponse> newReleaseAlbumArtists, List<ImageResponse> newReleaseAlbumImages, String newReleaseAlbumHref, String newReleaseAlbumUri) {
        this.newReleaseAlbumId = newReleaseAlbumId;
        this.newReleaseAlbumName = newReleaseAlbumName;
        this.newReleaseAlbumArtists = newReleaseAlbumArtists;
        this.newReleaseAlbumImages = newReleaseAlbumImages;
        this.newReleaseAlbumHref = newReleaseAlbumHref;
        this.newReleaseAlbumUri = newReleaseAlbumUri;
    }

    /*
         * Getter and Setter methods for instance variables
         */

    public String getNewReleaseAlbumId() {
        return newReleaseAlbumId;
    }

    public void setNewReleaseAlbumId(String newReleaseAlbumId) {
        this.newReleaseAlbumId = newReleaseAlbumId;
    }

    public String getNewReleaseAlbumName() {
        return newReleaseAlbumName;
    }

    public void setNewReleaseAlbumName(String newReleaseAlbumName) {
        this.newReleaseAlbumName = newReleaseAlbumName;
    }

    public List<SimpleArtistResponse> getNewReleaseAlbumArtists() {
        return newReleaseAlbumArtists;
    }

    public void setNewReleaseAlbumArtists(List<SimpleArtistResponse> newReleaseAlbumArtists) {
        this.newReleaseAlbumArtists = newReleaseAlbumArtists;
    }

    public List<ImageResponse> getNewReleaseAlbumImages() {
        return newReleaseAlbumImages;
    }

    public void setNewReleaseAlbumImages(List<ImageResponse> newReleaseAlbumImages) {
        this.newReleaseAlbumImages = newReleaseAlbumImages;
    }

    public String getNewReleaseAlbumHref() {
        return newReleaseAlbumHref;
    }

    public void setNewReleaseAlbumHref(String newReleaseAlbumHref) {
        this.newReleaseAlbumHref = newReleaseAlbumHref;
    }

    public String getNewReleaseAlbumUri() {
        return newReleaseAlbumUri;
    }

    public void setNewReleaseAlbumUri(String newReleaseAlbumUri) {
        this.newReleaseAlbumUri = newReleaseAlbumUri;
    }
}
