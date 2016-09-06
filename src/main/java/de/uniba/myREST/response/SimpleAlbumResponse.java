package de.uniba.myREST.response;

import java.util.List;

/**
 * Creates custom datatype for SimpleAlbum
 * Created by chandan on 06.09.16.
 */
public class SimpleAlbumResponse {

    private String simpleAlbumHref;
    private String simpleAlbumId;
    private List<ImageResponse> simpleAlbumImages;
    private String simpleAlbumName;
    private String simpleAlbumUri;
    private List<String> simpleAlbumAvailableMarkets;

    /*
     * Constructots
     */
    public SimpleAlbumResponse() {
    }

    public SimpleAlbumResponse(String simpleAlbumHref, String simpleAlbumId, List<ImageResponse> simpleAlbumImages, String simpleAlbumName, String simpleAlbumUri, List<String> simpleAlbumAvailableMarkets) {
        this.simpleAlbumHref = simpleAlbumHref;
        this.simpleAlbumId = simpleAlbumId;
        this.simpleAlbumImages = simpleAlbumImages;
        this.simpleAlbumName = simpleAlbumName;
        this.simpleAlbumUri = simpleAlbumUri;
        this.simpleAlbumAvailableMarkets = simpleAlbumAvailableMarkets;
    }

    /*
     * Getter and Setter methods for instance variables
     */

    public String getSimpleAlbumHref() {
        return simpleAlbumHref;
    }

    public void setSimpleAlbumHref(String simpleAlbumHref) {
        this.simpleAlbumHref = simpleAlbumHref;
    }

    public String getSimpleAlbumId() {
        return simpleAlbumId;
    }

    public void setSimpleAlbumId(String simpleAlbumId) {
        this.simpleAlbumId = simpleAlbumId;
    }

    public List<ImageResponse> getSimpleAlbumImages() {
        return simpleAlbumImages;
    }

    public void setSimpleAlbumImages(List<ImageResponse> simpleAlbumImages) {
        this.simpleAlbumImages = simpleAlbumImages;
    }

    public String getSimpleAlbumName() {
        return simpleAlbumName;
    }

    public void setSimpleAlbumName(String simpleAlbumName) {
        this.simpleAlbumName = simpleAlbumName;
    }

    public String getSimpleAlbumUri() {
        return simpleAlbumUri;
    }

    public void setSimpleAlbumUri(String simpleAlbumUri) {
        this.simpleAlbumUri = simpleAlbumUri;
    }

    public List<String> getSimpleAlbumAvailableMarkets() {
        return simpleAlbumAvailableMarkets;
    }

    public void setSimpleAlbumAvailableMarkets(List<String> simpleAlbumAvailableMarkets) {
        this.simpleAlbumAvailableMarkets = simpleAlbumAvailableMarkets;
    }
}
