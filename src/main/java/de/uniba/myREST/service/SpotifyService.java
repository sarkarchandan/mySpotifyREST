package de.uniba.myREST.service;

import de.uniba.myREST.engine.*;
import de.uniba.myREST.response.ArtistResponse;
import de.uniba.myREST.response.SimpleArtistResponse;
import de.uniba.myREST.response.SimpleTrackResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.lang.reflect.Method;
import java.util.List;
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


    /**
     * Returns a specific artist details serialized as JSON type
     * @param artistName {String}
     * @param uriInfo {UriInfo}
     * @return Response
     */
    @GET
    @Path("/artists")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getSpotifyArtistData(@QueryParam("artistName") String artistName, @Context UriInfo uriInfo){

        loggerSpotifyService.setLevel(Level.ALL);
        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyArtistData: Start Logging");


        if (artistName==null || artistName.equals("")){

            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }

        /*
         * Declaring ArtistResponse object
         */
        ArtistResponse response = ArtistLookup.getArtistFromName(artistName);

        /*
         * Building uri link to self with the Context UriInfo
         */
        String selfUri = uriInfo.getBaseUriBuilder()
                .path(SpotifyService.class)
                .path("/artists")
                .queryParam("artistName",artistName)
                .build().toString();

        //Adding the Uri link to the list of links//
        response.addLink(selfUri,"linkToself");


        /*
         * Building uri link to the top 5 tracks of the given artist with Context UriInfo
         */
        String topTrackUri = uriInfo.getBaseUriBuilder()
                .path(SpotifyService.class)
                .path("/topTracks")
                .queryParam("artistName",artistName)
                .build().toString();
        //Adding the Uri link to the list of links//
        response.addLink(topTrackUri,"linkToTopFiveTracksForArtist");

        /*
         * Building uri link to the similar 5 artists of the given artist with Context UriInfo
         */
        String similarArtistsUri = uriInfo.getBaseUriBuilder()
                .path(SpotifyService.class)
                .path("/similarArtists")
                .queryParam("artistName",artistName)
                .build().toString();
        //Adding the Uri link to the list of links//
        response.addLink(similarArtistsUri,"linkToFiveSimilarArtists");


        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyArtistData: Done Logging");
        return Response.ok(response, MediaType.APPLICATION_JSON).build();

    }

    /**
     * Returns a specific track details serialized as JSON type
     * @param trackName {String}
     * @return {Response}
     */
    @GET
    @Path("/tracks")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getSpotifyTrackData(@QueryParam("trackName") String trackName){

        loggerSpotifyService.setLevel(Level.ALL);
        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyTrackData: Start Logging");

        if(trackName==null || trackName.equals("")){
            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }

        loggerSpotifyService.info("lass SpotifyService/Method getSpotifyTrackData: Done Logging");
        return Response.ok(TrackLookup.getTrackFromName(trackName),MediaType.APPLICATION_JSON).build();

    }

    /**
     * Returns a specific Album details serialized as JSON type
     * @param albumName {String}
     * @return {Response}
     */
    @GET
    @Path("/albums")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getSpotifyAlbumData(@QueryParam("albumName") String albumName){
        loggerSpotifyService.setLevel(Level.ALL);
        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyAlbumData: Start Logging");

        if(albumName==null || albumName.equals("")){

            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }

        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyAlbumData: Done Logging");
        return Response.ok(AlbumLookup.getAlbumFromName(albumName),MediaType.APPLICATION_JSON).build();
    }

    /**
     * Returns ches five top tracks for a specific artist
     * @param artistName {String}
     * @return {Response}
     */
    @GET
    @Path("/topTracks")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getSpotifyTopTracksForArtistID(@QueryParam("artistName") String artistName){
        loggerSpotifyService.setLevel(Level.ALL);
        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyTopTracksforArtist: Start Logging");

        if (artistName==null||artistName.equals("")){

            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }

        GenericEntity<List<SimpleTrackResponse>> response = new GenericEntity<List<SimpleTrackResponse>>(TopTracksLookUp.getTopFiveTracksforAnArtist(artistName)){};

        loggerSpotifyService.info("Class SpotifyService/Method getSpotifyTopTracksforArtist: Done Logging");

        return Response.ok(response,MediaType.APPLICATION_JSON).build();

    }

    /**
     * Returns five similar artists for given artist
     * @param artistName {String}
     * @return {Response}
     */
    @GET
    @Path("/similarArtists")
    @Consumes(TEXT_PLAIN)
    @Produces(APPLICATION_JSON)
    public Response getSpotifySimilarArtistsForArtist(@QueryParam("artistName") String artistName){
        loggerSpotifyService.setLevel(Level.ALL);
        loggerSpotifyService.info("Class SpotifyService/Method getSpotifySimilarArtistsForArtist: Start Logging");

        if(artistName==null || artistName.equals("")){

            return Response.status(Response.Status.BAD_REQUEST).entity("Bad Request").build();
        }

        GenericEntity<List<SimpleArtistResponse>> response = new GenericEntity<List<SimpleArtistResponse>>(SimilarArtistLookup.getFiveSimilarArtistsForArtist(artistName)){};

        loggerSpotifyService.info("Class SpotifyService/Method getSpotifySimilarArtistsForArtist: Done Logging");
        return Response.ok(response,MediaType.APPLICATION_JSON).build();

    }



}
