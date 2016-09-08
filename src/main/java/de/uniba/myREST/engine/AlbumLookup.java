package de.uniba.myREST.engine;


import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.methods.AlbumSearchRequest;
import com.wrapper.spotify.models.*;
import de.uniba.myREST.response.AlbumResponse;
import de.uniba.myREST.response.ImageResponse;
import de.uniba.myREST.response.SimpleArtistResponse;

import java.util.ArrayList;
import java.util.List;
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
    public static AlbumResponse getAlbumFromName(String albumName){

        loggerAlbumLookup.setLevel(Level.ALL);
        loggerAlbumLookup.info("Class AlbumLookup/Method getAlbumIDFromName: Start Logging");


        /*
         * Declaring reference for AlbumResponse type.
         * Declaring List<String> to contain all the Available Markets for Album. This is required to construct AlbumResponse object.
         * Declaring List<ImageResponse> to contain all the  Images for the Album. This is required to construct AlbumResponse object
         * Declaring List<SimpleArtistResponse> to contain all the Artists of the Album
         */
        AlbumResponse albumResponse=null;
        List<String> listOfAlbumAvailableMarkets = new ArrayList<>();
        List<ImageResponse> listOfAlbumImages = new ArrayList<>();
        List<SimpleArtistResponse> listOfAlbumArtists = new ArrayList<>();

        /*
         * Declaring Api object to make the authenticated call to Spotify Web API
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



                        /*
                         * Iterating through all Available Markets of the Album to add each Available Market to the List<String> of All Available Markets.
                         * This is required to construct the AlbumResponse object
                         */
                        for(String eachAvailableMarket: album.getAvailableMarkets()){
                            listOfAlbumAvailableMarkets.add(eachAvailableMarket);
                        }

                        /*
                         * Iterating through all Album Images to construct List<ImageResponse> objects.
                         * List<ImageResponse> objects is required to construct AlbumResponse object
                         */
                        for(Image eachAlbumImage: album.getImages()){
                            listOfAlbumImages.add(new ImageResponse(
                                    eachAlbumImage.getHeight(),
                                    eachAlbumImage.getUrl(),
                                    eachAlbumImage.getWidth()
                            ));
                        }

                        /*
                         * Constructing the List<SimpleArtistResponse> to get the Artist details of the Album.
                         * We are using Spotify AlbumRequest method here explicitly to include Artist Details in the AlbumResponse.
                         * Until now we were dealing with the reference type SimpleAlbum which doesn't include Artist Details.
                         * Here we are getting the original Album reference with the help of SimpleAlbum Id and from there we are getting the Artist Details
                         */
                        AlbumRequest customAlbumRequest = api.getAlbum(album.getId())
                                .build();
                        Album albumDetails = customAlbumRequest.get();
                        /*
                         * Iterating through the list of SimpleArtists for a given Album reference
                         */
                        for (SimpleArtist albumArtist: albumDetails.getArtists()){

                            listOfAlbumArtists.add(
                                    new SimpleArtistResponse(
                                            albumArtist.getHref(),
                                            albumArtist.getId(),
                                            albumArtist.getName(),
                                            albumArtist.getUri()
                                    )
                            );
                        }

                        /* Constructing AlbumResponse object.
                         * This is the final AlbumResponse object which will be serialized to JSON type.
                         */
                        albumResponse = new AlbumResponse(
                                album.getId(),
                                album.getAlbumType().getType(),
                                listOfAlbumAvailableMarkets,
                                listOfAlbumImages,
                                album.getHref(),
                                album.getName(),
                                listOfAlbumArtists,
                                album.getUri()
                                );

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
        return albumResponse;
    }
}
