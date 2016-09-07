package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for Tracks
 * This class will be used to model the response object for track search by name
 * Created by chandan on 06.09.16.
 */
public class TrackResponse {

    private SimpleAlbumResponse trackAlbum;
    private List<SimpleArtistResponse> trackArtists;
    private int trackDiscNumber;
    private int trackDurationInSeconds;
    private String trackHref;
    private String trackId;
    private String trackName;
    private int trackPopularity;
    private String trackPreviewUrl;
    private int trackNumber;
    private String trackUri;


    /*
     * Constructors
     */
    public TrackResponse() {
    }

    public TrackResponse(SimpleAlbumResponse trackAlbum, List<SimpleArtistResponse> trackArtists, int trackDiscNumber, int trackDurationInSeconds, String trackHref, String trackId, String trackName, int trackPopularity, String trackPreviewUrl, int trackNumber, String trackUri) {
        this.trackAlbum = trackAlbum;
        this.trackArtists = trackArtists;
        this.trackDiscNumber = trackDiscNumber;
        this.trackDurationInSeconds = trackDurationInSeconds;
        this.trackHref = trackHref;
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackPopularity = trackPopularity;
        this.trackPreviewUrl = trackPreviewUrl;
        this.trackNumber = trackNumber;
        this.trackUri = trackUri;
    }

    /*
     * Getter and Setter methods for instance variables
     */
    public SimpleAlbumResponse getTrackAlbum() {
        return trackAlbum;
    }

    public void setTrackAlbum(SimpleAlbumResponse trackAlbum) {
        this.trackAlbum = trackAlbum;
    }

    public List<SimpleArtistResponse> getTrackArtists() {
        return trackArtists;
    }

    public void setTrackArtists(List<SimpleArtistResponse> trackArtists) {
        this.trackArtists = trackArtists;
    }

    public int getTrackDiscNumber() {
        return trackDiscNumber;
    }

    public void setTrackDiscNumber(int trackDiscNumber) {
        this.trackDiscNumber = trackDiscNumber;
    }

    public int getTrackDurationInSeconds() {
        return trackDurationInSeconds;
    }

    public void setTrackDurationInSeconds(int trackDurationInSeconds) {
        this.trackDurationInSeconds = trackDurationInSeconds;
    }

    public String getTrackHref() {
        return trackHref;
    }

    public void setTrackHref(String trackHref) {
        this.trackHref = trackHref;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
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

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrackUri() {
        return trackUri;
    }

    public void setTrackUri(String trackUri) {
        this.trackUri = trackUri;
    }
}
