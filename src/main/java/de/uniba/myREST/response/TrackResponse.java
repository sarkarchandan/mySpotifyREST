package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for Tracks
 * Created by chandan on 06.09.16.
 */
public class TrackResponse {

    private SimpleAlbumResponse trackAlbum;
    private List<SimpleArtistResponse> trackArtists;
    private List<String> trackAvailableMarkets;
    private int trackDiscNumber;
    private int trackDuration;
    private String trackHref;
    private String trackId;
    private String tracName;
    private int trackPopularity;
    private String trackPreviewUrl;
    private int trackNumber;
    private String trackUri;


    /*
     * Constructors
     */
    public TrackResponse() {
    }

    public TrackResponse(SimpleAlbumResponse trackAlbum, List<SimpleArtistResponse> trackArtists, List<String> trackAvailableMarkets, int trackDiscNumber, int trackDuration, String trackHref, String trackId, String tracName, int trackPopularity, String trackPreviewUrl, int trackNumber, String trackUri) {
        this.trackAlbum = trackAlbum;
        this.trackArtists = trackArtists;
        this.trackAvailableMarkets = trackAvailableMarkets;
        this.trackDiscNumber = trackDiscNumber;
        this.trackDuration = trackDuration;
        this.trackHref = trackHref;
        this.trackId = trackId;
        this.tracName = tracName;
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

    public List<String> getTrackAvailableMarkets() {
        return trackAvailableMarkets;
    }

    public void setTrackAvailableMarkets(List<String> trackAvailableMarkets) {
        this.trackAvailableMarkets = trackAvailableMarkets;
    }

    public int getTrackDiscNumber() {
        return trackDiscNumber;
    }

    public void setTrackDiscNumber(int trackDiscNumber) {
        this.trackDiscNumber = trackDiscNumber;
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

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTracName() {
        return tracName;
    }

    public void setTracName(String tracName) {
        this.tracName = tracName;
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
