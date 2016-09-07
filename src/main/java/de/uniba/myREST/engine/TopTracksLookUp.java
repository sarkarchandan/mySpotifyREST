package de.uniba.myREST.engine;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TopTracksRequest;
import com.wrapper.spotify.models.Track;
import de.uniba.myREST.response.SimpleTrackAlbumResponse;
import de.uniba.myREST.response.SimpleTrackResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the top 5 tracks for a given artist
 * Created by chandan on 07.09.16.
 */
public class TopTracksLookUp {

    /*
     * Enable logging at the class level
     */
    private static Logger loggerTopTracksLookUp = Logger.getLogger(TopTracksLookUp.class.getName());


    /**
     * Retirns Top five track objects for a given artist
     * @param artistID {String}
     * @return {SimpleTrackResponse}
     */
    public static List<SimpleTrackResponse> getTopFiveTracksforAnArtist(String artistID){
        loggerTopTracksLookUp.setLevel(Level.ALL);
        loggerTopTracksLookUp.info("Class TopTracksLookUp/Method getTopFiveTracksforAnArtist: Start Logging");

        /*
         * Declaring an empty list of objects with List<SimpleTrackResponse> reference type
         * Declaring reference type for SimpleTrackAlbumResponse
         */
        List<SimpleTrackResponse> simpleTrackResponses = new ArrayList<>();
        SimpleTrackAlbumResponse simpleTrackAlbumResponse;

        /*
         * Make authenticated call to Spotify Api
         */
        Api api = Api.builder()
                .accessToken(GetAccessToken.deliverAccessToken())
                .build();

        if(artistID!=null ||!artistID.equals("")){

            try {
                TopTracksRequest topTracksRequest = api.getTopTracksForArtist(artistID, "US").build();
                List<Track> topTracks = topTracksRequest.get().subList(0, 5);

                /*
                 * Iterating for eachof the top tracks for a given artist
                 */
                for(Track eachOfTheTracks: topTracks){

                    /*
                     * Constructing SimpleTrackAlbumResponse object which will be required to construct SimpleTrackResponse object
                     */
                    simpleTrackAlbumResponse = new SimpleTrackAlbumResponse(
                            eachOfTheTracks.getAlbum().getAlbumType().getType(),
                            eachOfTheTracks.getAlbum().getHref(),
                            eachOfTheTracks.getAlbum().getName(),
                            eachOfTheTracks.getAlbum().getUri()
                    );

                    /*
                     * Constructing SimpleTrackResponse type object.
                     * This is final SimpleTrackResponse object which will be serialized to JSON type
                     */
                    simpleTrackResponses.add(
                            new SimpleTrackResponse(
                                    simpleTrackAlbumResponse,
                                   eachOfTheTracks.getDuration(),
                                    eachOfTheTracks.getHref(),
                                    eachOfTheTracks.getName(),
                                    eachOfTheTracks.getPopularity(),
                                    eachOfTheTracks.getPreviewUrl(),
                                    eachOfTheTracks.getUri()
                            )
                    );
                }
            } catch (Exception e){
                loggerTopTracksLookUp.log(Level.SEVERE,"Could not fetch songs for the artist: Check the parameter passed");
            }
        } else {
            loggerTopTracksLookUp.log(Level.WARNING,"Method received an empty argument");
        }
        loggerTopTracksLookUp.info("Class TopTracksLookUp/Method getTopFiveTracksforAnArtist: Done Logging");
        return simpleTrackResponses;
    }

}
