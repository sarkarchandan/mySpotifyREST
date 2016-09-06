package de.uniba.myREST.engine;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.TrackSearchRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.Track;

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
    public static String getTrackIDFromName(String trackName){

        loggerTrackLookup.setLevel(Level.ALL);
        loggerTrackLookup.info("Class TrackLookup/Method getTrackIDFromName: Start Logging");

        String trackID = new String();


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
                        trackID = eachTrack.getId();
                    }
                }else{loggerTrackLookup.log(Level.WARNING,"No Matching Track found: Check the Parameter");}

            } catch (Exception e) {
                loggerTrackLookup.log(Level.SEVERE,"Bad Request"+e.getMessage());
            }
        }else{
            loggerTrackLookup.log(Level.WARNING,"Method received an empty Argument");
        }

        loggerTrackLookup.info("Class TrackLookup/Method getTrackIDFromName: Done Logging");
        return trackID;

    }

}
