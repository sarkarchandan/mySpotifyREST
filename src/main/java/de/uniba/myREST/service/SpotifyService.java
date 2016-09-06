package de.uniba.myREST.service;

import de.uniba.myREST.engine.ArtistLookup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * Provides the users to fetch music data from the Spotify Web API
 * Created by chandan on 06.09.16.
 */
@Path("/spotifyData")
public class SpotifyService {

    /*
     * Enable logging at the class level
     */
    private static Logger loggerSpotifyService = Logger.getLogger(SpotifyService.class.getName());

    @GET
    @Path("/artist")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getSpotifyArtistData(@QueryParam("artistName") String artistName){

        loggerSpotifyService.setLevel(Level.ALL);
        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyArtistData: Start Logging");


        if (artistName==null || artistName.equals("")){

            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }

        return Response.ok(ArtistLookup.getArtistFromName(artistName), MediaType.APPLICATION_JSON).build();

    }

}
