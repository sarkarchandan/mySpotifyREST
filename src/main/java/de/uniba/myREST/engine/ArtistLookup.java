package de.uniba.myREST.engine;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Image;
import com.wrapper.spotify.models.Page;
import de.uniba.myREST.response.ArtistResponse;
import de.uniba.myREST.response.ImageResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the Artist Details as an object for a given Artist Name
 * @author Created by chandan on 06.09.16.
 */
public class ArtistLookup {

    /*
     * Enable logging at the class level
     */
    private static Logger loggerArtistLookup = Logger.getLogger(ArtistLookup.class.getName());

    /**
     * Returns Artist Details as an object for a given Artist Name
     * @param artistName {String}
     * @return artistResponse {ArtistResponse}
     */
    public static ArtistResponse getArtistFromName(String artistName) {

        loggerArtistLookup.setLevel(Level.ALL);
        loggerArtistLookup.info("Class ArtistLookup/Method getArtistIDFromName: Start Logging");

        /*
         * Declaring Reference and creating a new object for holding Image details for the artist
         * Declaring a List of strings for holding the Generes of the artist
         * Declaring a reference for ArtistResponse type
         */
        List<ImageResponse> artistImageResponse = new ArrayList<>();
        List<String> genreList = new ArrayList<>();
        ArtistResponse artistResponse=null;

        /*
         * Make the authenticated call to Spotify Web API
         */
        Api api = Api.builder()
                .accessToken(GetAccessToken.deliverAccessToken())
                .build();


        if(artistName!=null||!artistName.equals("")) {

            //Call to API Method//
            final ArtistSearchRequest searchRequest = api.searchArtists(artistName).offset(0).limit(1).build();

            try {
                final Page<Artist> artistSearchResult = searchRequest.get();
                /*
                 * Custom datatype Page has a Generic list as one of it's instance variables.
                 * We are using that generic list to fetch a list of Artists which should contain only one Artist element
                 */
                final List<Artist> searchArtists = artistSearchResult.getItems();

                if(searchArtists.size()!=0) {

                    /*Iterating to fetch the single artist object from the search result*/
                    for (Artist artist : searchArtists) {

                        /*Iterating within the list of Images of the artist to add them to List of ImageResponsetype objects*/
                        for(Image artistImageParameter: artist.getImages()) {
                            artistImageResponse.add(new ImageResponse(artistImageParameter.getHeight(), artistImageParameter.getUrl(), artistImageParameter.getWidth()));
                        }
                        /*Iterating within the Geners of the artist to add them to List of Strings*/
                        for(String artistGenreParameter: artist.getGenres()){
                            genreList.add(artistGenreParameter);
                        }
                        /*Constructing the ArtistResponse type object*/
                        artistResponse = new ArtistResponse(genreList,
                                artist.getHref(),
                                artist.getId(),
                                artistImageResponse,
                                artist.getName(),
                                artist.getPopularity(),
                                artist.getUri());
                    }
                }else {loggerArtistLookup.log(Level.WARNING,"No Matching Artist found: Check the Parameter");}

            } catch (Exception e) {
                loggerArtistLookup.log(Level.SEVERE,"Bad Request" + e.getMessage());
            }

        }else{
            loggerArtistLookup.log(Level.WARNING,"Method received an empty Argument");
        }

        loggerArtistLookup.info("Class ArtistLookup/Method getArtistIDFromName: Done Logging");
        return artistResponse;
    }


}
