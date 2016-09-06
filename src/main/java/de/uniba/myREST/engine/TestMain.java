package de.uniba.myREST.engine;

import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.models.*;
import de.uniba.myREST.response.ImageResponse;

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

        for (ImageResponse imageResponse: ArtistLookup.getArtistFromName("Linkin Park").getArtistImages()){
            System.out.println(imageResponse.getImageHeight());
            System.out.println(imageResponse.getImageUrl());
            System.out.println(imageResponse.getImageWidth());
        }
        //System.out.print(ArtistLookup.getArtistFromName("Linkin Park").getArtistPopularity());


    }

}
