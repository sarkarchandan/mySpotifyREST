package de.uniba.myREST.engine;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.*;
import com.wrapper.spotify.models.Image;
import de.uniba.myREST.response.ImageResponse;
import de.uniba.myREST.response.SimpleAlbumResponse;
import de.uniba.myREST.response.SimpleArtistResponse;
import de.uniba.myREST.response.TrackResponse;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the Track ID for a given Track name
 * @author Created by chandan on 06.09.16.
 */
public class TrackLookup {

    /*
     * Enable logging at the class level
     */
    private static Logger loggerTrackLookup = Logger.getLogger(TrackLookup.class.getName());


    /**
     * Returns Track ID for a given Track Name
     * @param trackName {String}
     * @return trackID {String}
     */
    public static TrackResponse getTrackIDFromName(String trackName){

        loggerTrackLookup.setLevel(Level.ALL);
        loggerTrackLookup.info("Class TrackLookup/Method getTrackIDFromName: Start Logging");


        /*
         * Declaring reference for TrackResponse type
         * Declaring reference for SimpleAlbumResponse. This is required to construct the TrackResponse object. Refer TrackResponse datatype definition
         * Declaring reference for SimpleArtistResponse.
         * Declaring reference for ImageResponse.
         * Declaring list<String> of AvailableMarkets of each track.
         * Declaring list<String> of AvailableMarkets for SimpleAlbum of each Track. This is required to construct the SimpleAlbumResponse object.
         * Declaring list<SimpleArtistResponse>. List of SimpleArtistResponse is required to construct TrackResponse object. Refer TrackResponse datatype definition
         * declaring list<ImageResponse>. List of ImageResponse is required to construct the SimpleAlbumResponse object.
         */
        TrackResponse trackResponse=null;
        SimpleAlbumResponse simpleAlbumResponse;
        SimpleArtistResponse simpleArtistResponse;
        ImageResponse imageResponse;
        List<String> listOfTrackAvailableMarkets = new ArrayList<>();
        List<String> listOfSimpleAlbumAvailableMarket = new ArrayList<>();
        List<SimpleArtistResponse> listOfSimpleArtistResponse = new ArrayList<>();
        List<ImageResponse> listOfSimpleAlbumImages = new ArrayList<>();



        /*
         * Make the authenticated call to Spotify Web API
         */
        Api api = Api.builder()
                .accessToken(GetAccessToken.deliverAccessToken())
                .build();

        if(trackName!=null||!trackName.equals("")){

            final TrackSearchRequest request = api.searchTracks(trackName).offset(0).limit(1).build();

            try {
                final Page<Track> trackSearchResult = request.get();
                /*
                 * Custom datatype Page has a Generic list as one of it's instance variables.
                 * We are using that generic list to fetch a list of Tracks which should contain only one Track element
                 */
                List<Track> searchTracks = trackSearchResult.getItems();

                if(searchTracks.size()!=0) {
                    for (Track eachTrack : searchTracks) {
                        //////////////////////////////

                        for(Image imageOfSimpleAlbum: eachTrack.getAlbum().getImages()){
                            listOfSimpleAlbumImages.add(new ImageResponse(
                                    imageOfSimpleAlbum.getHeight(),
                                    imageOfSimpleAlbum.getUrl(),
                                    imageOfSimpleAlbum.getWidth()));
                        }
                        for (String eachSimpleAlbumAvailableMarket: eachTrack.getAlbum().getAvailableMarkets()){
                            listOfSimpleAlbumAvailableMarket.add(eachSimpleAlbumAvailableMarket);
                        }


                        simpleAlbumResponse = new SimpleAlbumResponse(
                                eachTrack.getAlbum().getHref(),
                                eachTrack.getAlbum().getId(),
                                listOfSimpleAlbumImages,
                                eachTrack.getAlbum().getName(),
                                eachTrack.getAlbum().getUri(),
                                listOfSimpleAlbumAvailableMarket
                        );

                        for (SimpleArtist eachSimpleArtist: eachTrack.getArtists()){
                            listOfSimpleArtistResponse.add(new SimpleArtistResponse(
                                    eachSimpleArtist.getHref(),
                                    eachSimpleArtist.getId(),
                                    eachSimpleArtist.getName(),
                                    eachSimpleArtist.getUri()));
                        }

                        for (String eachTrackAvailableMarket: eachTrack.getAvailableMarkets()){
                            listOfTrackAvailableMarkets.add(eachTrackAvailableMarket);
                        }

                        trackResponse = new TrackResponse(
                                simpleAlbumResponse,
                                listOfSimpleArtistResponse,
                                listOfTrackAvailableMarkets,
                                eachTrack.getDiscNumber(),
                                eachTrack.getDuration(),
                                eachTrack.getHref(),
                                eachTrack.getId(),
                                eachTrack.getName(),
                                eachTrack.getPopularity(),
                                eachTrack.getPreviewUrl(),
                                eachTrack.getTrackNumber(),
                                eachTrack.getUri()
                        );

                    }
                }else{loggerTrackLookup.log(Level.WARNING,"No Matching Track found: Check the Parameter");}

            } catch (Exception e) {
                loggerTrackLookup.log(Level.SEVERE,"Bad Request"+e.getMessage());
            }
        }else{
            loggerTrackLookup.log(Level.WARNING,"Method received an empty Argument");
        }

        loggerTrackLookup.info("Class TrackLookup/Method getTrackIDFromName: Done Logging");
        return trackResponse;

    }

}
