package de.uniba.myREST.engine;

import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.*;
import de.uniba.myREST.response.ImageResponse;
import de.uniba.myREST.response.SimpleTrackResponse;

import java.io.IOException;

/**
 * Temporary Class created for minor Tests
 * Created by chandan on 06.09.16.
 */
public class TestMain {

    public static void main(String args[]) {

        //System.out.println(GetAccessToken.deliverAccessToken());


        //System.out.println(AlbumLookup.getAlbumIDFromName("...."));

        //System.out.println(TrackLookup.getTrackIDFromName(""));


        for(SimpleTrackResponse simpleTrackResponse: TopTracksLookUp.getTopFiveTracksforAnArtist("5f5B8Zd0xuvmcDin3oK76F")){


            System.out.println(simpleTrackResponse.getTrackAlbum().getAlbumType());
            System.out.println(simpleTrackResponse.getTrackAlbum().getAlbumHref());
            System.out.println(simpleTrackResponse.getTrackAlbum().getAlbumName());
            System.out.println(simpleTrackResponse.getTrackPopularity());
            System.out.println(simpleTrackResponse.getTrackPreviewUrl());
            System.out.println("################");

        }



    }

}
