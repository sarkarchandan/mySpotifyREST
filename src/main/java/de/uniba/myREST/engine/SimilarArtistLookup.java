package de.uniba.myREST.engine;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.RelatedArtistsRequest;
import com.wrapper.spotify.models.Artist;
import de.uniba.myREST.response.SimpleArtistResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fetches the Similar Artist for given Artist Name
 * @author Created by chandan on 07.09.16.
 */
public class SimilarArtistLookup {

    /*
     * Enabling logging at the class level
     */
    private static Logger loggerSimilarArtistLookup = Logger.getLogger(SimilarArtistLookup.class.getName());


    public static List<SimpleArtistResponse> getFiveSimilarArtistsForArtist(String artistName){
        loggerSimilarArtistLookup.setLevel(Level.ALL);
        loggerSimilarArtistLookup.info("Class SimilarArtistLookup/Method getSimilarArtistsForArtist: Start Logging");


        /*
         * Declaring an empty list of objects with List<SimpleArtistResponse> reference type
         */
        List<SimpleArtistResponse> simpleArtistResponses = new ArrayList<>();

        /*
         * Declaring Api object to make authenticated call to Spotify Web Api
         */
        Api api = Api.builder()
                .accessToken(GetAccessToken.deliverAccessToken())
                .build();

        if (artistName!=null || !artistName.equals("")){


            RelatedArtistsRequest relatedArtistsRequest = api.getArtistRelatedArtists(ArtistLookup.getArtistFromName(artistName).getArtistId().toString()).build();

            try {
                List<Artist> similarArtistList = relatedArtistsRequest.get().subList(0, 5);
                if(similarArtistList.size()!=0) {
                    for (Artist eachSimilarArtist : similarArtistList) {

                        /*
                         * Constructing List<SimpleArtistResponse> object.
                         * This is the final list of objects which will be serialized to JSON type
                         */
                        simpleArtistResponses.add(
                                new SimpleArtistResponse(
                                        eachSimilarArtist.getHref(),
                                        eachSimilarArtist.getId(),
                                        eachSimilarArtist.getName(),
                                        eachSimilarArtist.getUri()
                                )
                        );
                    }
                } else{
                    loggerSimilarArtistLookup.info("No Similar artist for the given artist is found");
                }
            }catch (Exception e){
                loggerSimilarArtistLookup.log(Level.SEVERE,"Could not fetch similar artists for the given artist, Check the parameter passed");
            }
        }else{
            loggerSimilarArtistLookup.log(Level.WARNING,"Method received an empty Argument");
        }
        loggerSimilarArtistLookup.info("Class SimilarArtistLookup/Method getSimilarArtistsForArtist: Done Logging");

        return simpleArtistResponses;

    }

}
