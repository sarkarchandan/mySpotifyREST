package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for Artists
 * Created by chandan on 06.09.16.
 */
public class ArtistResponse {


    private List<String> artistGenres;
    private String artistHref;
    private String artistId;
    private List<ImageResponse> artistImages;
    private String artistName;
    private int artistPopularity;
    private String artistUri;

    /*
     * Constructors
     */
    public ArtistResponse() {
    }

    public ArtistResponse(List<String> artistGenres, String artistHref, String artistId, List<ImageResponse> artistImages, String artistName, int artistPopularity, String artistUri) {
        this.artistGenres = artistGenres;
        this.artistHref = artistHref;
        this.artistId = artistId;
        this.artistImages = artistImages;
        this.artistName = artistName;
        this.artistPopularity = artistPopularity;
        this.artistUri = artistUri;
    }

    /*
     * Getter and Setter methods for instance variables
     */

    public List<String> getArtistGenres() {
        return artistGenres;
    }

    public void setArtistGenres(List<String> artistGenres) {
        this.artistGenres = artistGenres;
    }

    public String getArtistHref() {
        return artistHref;
    }

    public void setArtistHref(String artistHref) {
        this.artistHref = artistHref;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public List<ImageResponse> getArtistImages() {
        return artistImages;
    }

    public void setArtistImages(List<ImageResponse> artistImages) {
        this.artistImages = artistImages;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getArtistPopularity() {
        return artistPopularity;
    }

    public void setArtistPopularity(int artistPopularity) {
        this.artistPopularity = artistPopularity;
    }

    public String getArtistUri() {
        return artistUri;
    }

    public void setArtistUri(String artistUri) {
        this.artistUri = artistUri;
    }
}
