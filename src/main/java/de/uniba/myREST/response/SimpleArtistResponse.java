package de.uniba.myREST.response;

/**
 * Created by chandan on 06.09.16.
 */
public class SimpleArtistResponse {


    private String simpleArtistHref;
    private String simpleArtistId;
    private String simpleArtistName;
    private String simpleArtistUri;


    /*
     * Constructors
     */
    public SimpleArtistResponse() {
    }

    public SimpleArtistResponse(String simpleArtistHref, String simpleArtistId, String simpleArtistName, String simpleArtistUri) {
        this.simpleArtistHref = simpleArtistHref;
        this.simpleArtistId = simpleArtistId;
        this.simpleArtistName = simpleArtistName;
        this.simpleArtistUri = simpleArtistUri;
    }

    /*
     * Getter and Setter methods
     */

    public String getSimpleArtistHref() {
        return simpleArtistHref;
    }

    public void setSimpleArtistHref(String simpleArtistHref) {
        this.simpleArtistHref = simpleArtistHref;
    }

    public String getSimpleArtistId() {
        return simpleArtistId;
    }

    public void setSimpleArtistId(String simpleArtistId) {
        this.simpleArtistId = simpleArtistId;
    }

    public String getSimpleArtistName() {
        return simpleArtistName;
    }

    public void setSimpleArtistName(String simpleArtistName) {
        this.simpleArtistName = simpleArtistName;
    }

    public String getSimpleArtistUri() {
        return simpleArtistUri;
    }

    public void setSimpleArtistUri(String simpleArtistUri) {
        this.simpleArtistUri = simpleArtistUri;
    }
}
