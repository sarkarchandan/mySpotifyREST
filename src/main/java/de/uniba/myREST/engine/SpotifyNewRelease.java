package de.uniba.myREST.engine;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.NewReleasesRequest;
import com.wrapper.spotify.models.*;
import de.uniba.myREST.response.ImageResponse;
import de.uniba.myREST.response.NewReleaseAlbumResponse;
import de.uniba.myREST.response.SimpleAlbumResponse;
import de.uniba.myREST.response.SimpleArtistResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the New Music Releases from Spotify
 * @author Created by chandan on 08.09.16.
 */
public class SpotifyNewRelease {

    /*
     * Enable logging at the class level
     */
    private static Logger loggerSpotifyNewRelease = Logger.getLogger(SpotifyNewRelease.class.getName());

    public static List<NewReleaseAlbumResponse> getNewSpotifyReleases(int noOfAlbums){
        loggerSpotifyNewRelease.setLevel(Level.ALL);
        loggerSpotifyNewRelease.info("Class SpotifyNewRelease/Method: getNewSpotifyReleases: Start Logging");


        /*
         * Declaring List<NewReleaseAlbumResponse>  objects which will contain the list of new released albums
         * Declaring List<SimpleArtistResponse> objects which will contain the list of artists for the new released albums. This is required to construct NewReleaseAlbumResponse objects
         * Declaring List<ImageResponse> objects which pwill contains the list of Images for the new released albums. This is required to construct NewReleaseAlbumResponse objects
         */
        List<NewReleaseAlbumResponse> newReleasedSpotifyAlbums = new ArrayList<>();
        List<SimpleArtistResponse> newReleasedAlbumArtists = new ArrayList<>();
        List<ImageResponse> newReleasedAlbumImages = new ArrayList<>();

        /*
         * Declaring Api object to make the authenticated call to Spotify Web Api
         */
        Api api = Api.builder()
                .accessToken(GetAccessToken.deliverAccessToken())
                .build();


        if (noOfAlbums>0) {
            try {
                final NewReleasesRequest newRequest = api.getNewReleases()
                        .offset(0)
                        .limit(5)
                        .build();

                NewReleases newReleasedAlbums = newRequest.get();
                Page<SimpleAlbum> newReleasedSimpleAlbumPages = newReleasedAlbums.getAlbums();

                if(newReleasedSimpleAlbumPages.getItems().size()!=0) {
            /*
             * Iterating through list of New released albums of which are of reference type SimpleAlbum  to fetch information about each new released albums
             */
                    for (SimpleAlbum eachNewReleasedSimpleAlbum : newReleasedSimpleAlbumPages.getItems().subList(0, noOfAlbums)) {

                /*
                 * Iterating through all SimpleArtists of the album.
                   * Since Here we are getting each new reeased albums of reference type SimpleAlbum, we need to fetch the Artist details else where.
                   * Hence we want to re-use the AlbumLookup class method to fetch the album artist details by passing the album name as parameter to the method AlbumLookup.getAlbumFromName({albumName})
                 */
                        for (SimpleArtistResponse artistOfNewReleasedAlbum : AlbumLookup
                                .getAlbumFromName(eachNewReleasedSimpleAlbum.getName())
                                .getAlbumArtists()) {

                    /*
                     * Constructing the List<SimpleArtistResponse> objects.
                     */
                            newReleasedAlbumArtists.add(
                                    new SimpleArtistResponse(
                                            artistOfNewReleasedAlbum.getSimpleArtistHref(),
                                            artistOfNewReleasedAlbum.getSimpleArtistId(),
                                            artistOfNewReleasedAlbum.getSimpleArtistName(),
                                            artistOfNewReleasedAlbum.getSimpleArtistUri()
                                    )
                            );

                        }

                /*
                 * Iterating through the list of images for the new released album.
                  * This List<ImageResponse> is required to construct the  NewReleaseAlbumResponse objects
                 */
                        for (Image imageforNewReleasedAlbum : eachNewReleasedSimpleAlbum.getImages()) {

                            newReleasedAlbumImages.add(
                                    new ImageResponse(
                                            imageforNewReleasedAlbum.getHeight(),
                                            imageforNewReleasedAlbum.getUrl(),
                                            imageforNewReleasedAlbum.getWidth()
                                    )
                            );
                        }

                /*
                 * Constructing List<NewReleaseAlbumResponse> object.
                 * This is the final object that will be serialized to JSON type
                 */
                        newReleasedSpotifyAlbums.add(
                                new NewReleaseAlbumResponse(
                                        eachNewReleasedSimpleAlbum.getId(),
                                        eachNewReleasedSimpleAlbum.getName(),
                                        newReleasedAlbumArtists,
                                        newReleasedAlbumImages,
                                        eachNewReleasedSimpleAlbum.getHref(),
                                        eachNewReleasedSimpleAlbum.getUri()
                                )
                        );
                    }
                }else{
                    loggerSpotifyNewRelease.log(Level.WARNING,"No Matching New Release Album is found: Check the Parameter");
                }

            } catch (Exception e) {
                loggerSpotifyNewRelease.log(Level.SEVERE,"Bad Request"+e.getMessage());
            }
        } else{
            loggerSpotifyNewRelease.log(Level.WARNING,"Method requires an integer parameter which is not received");
        }

        loggerSpotifyNewRelease.info("Class SpotifyNewRelease/Method: getNewSpotifyReleases: Done Logging");
        return newReleasedSpotifyAlbums;
    }

}
