package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for SimpleTrackResponse
 * This class will be used to model the top tracks for an artist
 * Created by chandan on 07.09.16.
 */
public class SimpleTrackResponse {

    private SimpleTrackAlbumResponse trackAlbum;
    private int trackDuration;
    private String trackHref;
    private String trackName;
    private int trackPopularity;
    private String trackPreviewUrl;
    private String trackUri;

    /*
     * Constructors
     */
    public SimpleTrackResponse() {
    }

    public SimpleTrackResponse(SimpleTrackAlbumResponse trackAlbum, int trackDuration, String trackHref, String trackName, int trackPopularity, String trackPreviewUrl, String trackUri) {
        this.trackAlbum = trackAlbum;
        this.trackDuration = trackDuration;
        this.trackHref = trackHref;
        this.trackName = trackName;
        this.trackPopularity = trackPopularity;
        this.trackPreviewUrl = trackPreviewUrl;
        this.trackUri = trackUri;
    }

    /*
     * Getter and Setter methods for instance variables
     */
    public SimpleTrackAlbumResponse getTrackAlbum() {
        return trackAlbum;
    }

    public void setTrackAlbum(SimpleTrackAlbumResponse trackAlbum) {
        this.trackAlbum = trackAlbum;
    }

    public int getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(int trackDuration) {
        this.trackDuration = trackDuration;
    }

    public String getTrackHref() {
        return trackHref;
    }

    public void setTrackHref(String trackHref) {
        this.trackHref = trackHref;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackPopularity() {
        return trackPopularity;
    }

    public void setTrackPopularity(int trackPopularity) {
        this.trackPopularity = trackPopularity;
    }

    public String getTrackPreviewUrl() {
        return trackPreviewUrl;
    }

    public void setTrackPreviewUrl(String trackPreviewUrl) {
        this.trackPreviewUrl = trackPreviewUrl;
    }

    public String getTrackUri() {
        return trackUri;
    }

    public void setTrackUri(String trackUri) {
        this.trackUri = trackUri;
    }
}
