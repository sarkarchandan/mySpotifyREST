package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for SimpleTrackAlbumResponse.
 * This class will be used to model the album for top tracks of an artist
 * Created by chandan on 07.09.16.
 */
public class SimpleTrackAlbumResponse {

    private String albumType;
    private String albumHref;
    private String albumName;
    private String albumUri;

    /*
     * Constructors
     */
    public SimpleTrackAlbumResponse() {
    }

    public SimpleTrackAlbumResponse(String albumType, String albumHref, String albumName, String albumUri) {
        this.albumType = albumType;
        this.albumHref = albumHref;
        this.albumName = albumName;
        this.albumUri = albumUri;
    }

/*
     * Getter and Setter methods for instance variables
     */

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
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

    public String getAlbumUri() {
        return albumUri;
    }

    public void setAlbumUri(String albumUri) {
        this.albumUri = albumUri;
    }
}
