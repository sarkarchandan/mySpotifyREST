package de.uniba.myREST.engine;


import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.SimpleAlbum;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the Album Id for a given Album name
 * @author Created by chandan on 06.09.16.
 */


public class AlbumLookup {

    /*
     * Enable logging at the class level
     */
    private static Logger loggerAlbumLookup = Logger.getLogger(AlbumLookup.class.getName());

    /**
     * Returns the Album Id for a given Album Name
     * @param albumName {String}
     * @return albumID {String}
     */
    public static String getAlbumIDFromName(String albumName){

        loggerAlbumLookup.setLevel(Level.ALL);
        loggerAlbumLookup.info("Class AlbumLookup/Method getAlbumIDFromName: Start Logging");

        String albumID= new String();

        /*
         * Make the authenticated call to Spotify Web API
         */
        Api api = Api.builder()
                .accessToken(GetAccessToken.deliverAccessToken())
                .build();

        if (albumName!=null|| !albumName.equals("")) {
            //Call to API Method//
            final AlbumSearchRequest request = api.searchAlbums(albumName).offset(0).limit(1).build();

            try {
                final Page<SimpleAlbum> albumSearchResult = request.get();

                if (albumSearchResult.getItems().size() != 0) {
                    for (SimpleAlbum album : albumSearchResult.getItems()) {
                        albumID = album.getId();

                    }
                } else {
                    loggerAlbumLookup.log(Level.WARNING, "No Matching Album is found: Check the Parameter");
                }
            } catch (Exception e) {
                loggerAlbumLookup.log(Level.SEVERE, "Bad Request" + e.getMessage());
            }
        }else {
            loggerAlbumLookup.log(Level.WARNING,"Method received an empty Argument");
        }
        loggerAlbumLookup.info("Class AlbumLookup/Method getAlbumIDFromName: Done Logging");
        return albumID;
    }
}
