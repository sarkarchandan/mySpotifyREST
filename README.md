# mySpotifyREST

mySpotifyREST  is a Java RESTful practice implementation built in open source RESTful Web Services framework Jersey. Public web API from Spotify has been used in this implementation. Currently this implementation offers JSON representations for:
- Search for an artist in Spotify
- Search for a specific track in Spotify
- Search for a specific album in Spotify
- Search for a list of desired no of New Spotify Releases

In this ongoing implementation, my aim is to create an interactive and convenient Search functionality for users by implementing HATEOAS(Hypermedia As The Engine Of Application State) concept of RESTful implementation.

At this moment upon searching for an artist, along with the details of the artist, users will be offered with:
- A URI to the list of top five tracks of the given artist.
- A URI to the brief details of five similar artists of the given artist.

##### Ongoing Work:
Adding these two links creates a possibility for the user to explore more about an Artist but this opens up doors to new possibilities of interactions. Once users get to see the similar artist of the given artist, users may want to explore about the similar artists as well e.g. their top songs or albums and then come back to previous state to name the few.

I am working towards extending from these two basic functionalities for the artist search towards designing a convenient interactive environment where users will be landed in something like a home page with all the new releases from the Spotify and from there users will have flexible options for their probable interaction with the application state. :octocat:

## Assumption
- This implementation creates Web Application Archive (.war) file and deploys the same in [Glassfish](https://glassfish.java.net/) container which can be downloaded from the link.
- It assumes that the user has a native installation of [Gradle](https://gradle.org/) or a [Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) pattern may also be used.

 ## Installation

Clone the [GitHub Repository](https://github.com/sarkarchandan/mySpotifyREST) 
```sh
$ git clone  https://github.com/sarkarchandan/mySpotifyREST
$ cd mySpotifyREST
```
## Usage
### Create Credentials
Go to [Spotify Developers Page](https://developer.spotify.com/my-applications/#!/) and register with Spotify. Registration is possible either using the Facebook account or with creating separate credentials. Upon registration, Spotify will ask for an Application Name and Application Description. It will then create an application with the specified name and provide a Client ID and a Client Secret for each registered application. This Client ID and Client Secret will be used to generate Access Token to establish authenticated connection to Spotify Web API.

### Import
- This implementation has been built using IntelliJ Idea but any IDE of user’s choice e.g. Eclipse can be used to import the project. Execute the corresponding gradle plug in to build the project workspace before importing.
```sh
$ gradle idea
```
OR
```sh
$ gradle eclipse
```
- Enter the Client ID and Client Secret to the respective static fields of the **GetAccessToken** class of the package _de.uniba.myREST.engine_

## Sample Executions
Open the Web Browser or Chrome Advanced REST Client and enter the respective querystrings for te different search parameters. Please refer the examples below:

##### Artist Search:
Sample Search Query: `http://localhost:8080/spotifyData/artists?artistName=Beatles`
##### Sample Outcome:

```
{
"artistGenres": [1]
0:  "british invasion"
"artistHref": "https://api.spotify.com/v1/artists/3WrFJ7ztbogyGnTHbHJFl2"
"artistId": "3WrFJ7ztbogyGnTHbHJFl2"
"artistImages": [4]
0:  {
"imageHeight": 1000
"imageUrl": "https://i.scdn.co/image/934c57df9fbdbbaa5e93b55994a4cb9571fd2085"
"imageWidth": 1000
}
.
.
"artistName": "The Beatles"
"artistPopularity": 84
"artistUri": "spotify:artist:3WrFJ7ztbogyGnTHbHJFl2"
"resourcelinks": [3]
    0:  {
    "resourceLink": "http://localhost:8080/spotifyData/artists?artistName=Beatles"
    "resourceRelation": "linkToself"
    }
    1:  {
    "resourceLink": "http://localhost:8080/spotifyData/topTracks?artistName=Beatles"
    "resourceRelation": "linkToTopFiveTracksForArtist"
    }
    2:  {
    "resourceLink": "http://localhost:8080/spotifyData/similarArtists?artistName=Beatles"
    "resourceRelation": "linkToFiveSimilarArtists"
    }
}
```
##### Further Interactions with Artist Search
- Follow the link for resourceRelation: "linkToTopFiveTracksForArtist"
##### Sample Outcome (To avoid a lengthy document we have just shown one sample track response)
```
{
"trackAlbum": {
"albumHref": "https://api.spotify.com/v1/albums/0ETFjACtuP2ADo6LFhL6HN"
"albumName": "Abbey Road (Remastered)"
"albumType": "album"
"albumUri": "spotify:album:0ETFjACtuP2ADo6LFhL6HN"
}-
"trackDuration": 185733
"trackHref": "https://api.spotify.com/v1/tracks/6dGnYIeXmHdcikdzNNDMm2"
"trackName": "Here Comes The Sun - Remastered"
"trackPopularity": 67
"trackPreviewUrl": "https://p.scdn.co/mp3-preview/6902e7da51d2f17e5369d57dadf8ce7d2a123f99"
"trackUri": "spotify:track:6dGnYIeXmHdcikdzNNDMm2"
}-
```
- Follow the link for resourceRelation: "linkToFiveSimilarArtists"
##### Sample Outcome (To avoid a lengthy document we have just shown one sample track response)
```
{
"simpleArtistHref": "https://api.spotify.com/v1/artists/74ASZWbe4lXaubB36ztrGX"
"simpleArtistId": "74ASZWbe4lXaubB36ztrGX"
"simpleArtistName": "Bob Dylan"
"simpleArtistUri": "spotify:artist:74ASZWbe4lXaubB36ztrGX"
}
```

##### Track Search:
Sample Search Query: `http://localhost:8080/spotifyData/tracks?trackName=Let+it+be`
##### Sample Outcome:
```
{
"trackAlbum": {
"simpleAlbumAvailableMarkets": [3]
0:  "CA"
1:  "MX"
2:  "US"
"simpleAlbumHref": "https://api.spotify.com/v1/albums/0jTGHV5xqHPvEcwL8f6YU5"
"simpleAlbumId": "0jTGHV5xqHPvEcwL8f6YU5"
"simpleAlbumImages": [3]
0:  {
"imageHeight": 640
"imageUrl": "https://i.scdn.co/image/b3651a85f2bca826b38194c51d09cd7b068aa3ab"
"imageWidth": 640
}-
1:  {
"imageHeight": 300
"imageUrl": "https://i.scdn.co/image/a329e45d52649d9ef327764a202df6084aff20ce"
"imageWidth": 300
}-
2:  {
"imageHeight": 64
"imageUrl": "https://i.scdn.co/image/8cae03783213449b24f247244a3b2049e98ee6e1"
"imageWidth": 64
}-
"simpleAlbumName": "Let It Be (Remastered)"
"simpleAlbumUri": "spotify:album:0jTGHV5xqHPvEcwL8f6YU5"
}-
"trackArtists": [1]
0:  {
"simpleArtistHref": "https://api.spotify.com/v1/artists/3WrFJ7ztbogyGnTHbHJFl2"
"simpleArtistId": "3WrFJ7ztbogyGnTHbHJFl2"
"simpleArtistName": "The Beatles"
"simpleArtistUri": "spotify:artist:3WrFJ7ztbogyGnTHbHJFl2"
}-
"trackDiscNumber": 1
"trackDurationInSeconds": 243026
"trackHref": "https://api.spotify.com/v1/tracks/7iN1s7xHE4ifF5povM6A48"
"trackId": "7iN1s7xHE4ifF5povM6A48"
"trackName": "Let It Be - Remastered"
"trackNumber": 6
"trackPopularity": 64
"trackPreviewUrl": "https://p.scdn.co/mp3-preview/f7913ebb647d47835c34fa4db7e889c8a87c6d10"
"trackUri": "spotify:track:7iN1s7xHE4ifF5povM6A48"
}
```

##### Album Search:
Sample Search Query: `http://localhost:8080/spotifyData/albums?albumName=Abbey+Road`
##### Sample Outcome:
```
{
"albumArtists": [1]
0:  {
"simpleArtistHref": "https://api.spotify.com/v1/artists/3WrFJ7ztbogyGnTHbHJFl2"
"simpleArtistId": "3WrFJ7ztbogyGnTHbHJFl2"
"simpleArtistName": "The Beatles"
"simpleArtistUri": "spotify:artist:3WrFJ7ztbogyGnTHbHJFl2"
}-
"albumAvailableMarkets": [3]
0:  "CA"
1:  "MX"
2:  "US"
"albumHref": "https://api.spotify.com/v1/albums/0ETFjACtuP2ADo6LFhL6HN"
"albumId": "0ETFjACtuP2ADo6LFhL6HN"
"albumImages": [3]
0:  {
"imageHeight": 640
"imageUrl": "https://i.scdn.co/image/c429243cd056974175abe72a3142d3dccffc166a"
"imageWidth": 640
}-
1:  {
"imageHeight": 300
"imageUrl": "https://i.scdn.co/image/31327f9fe6b6e0bd6e431a4add681397e95c6329"
"imageWidth": 300
}-
2:  {
"imageHeight": 64
"imageUrl": "https://i.scdn.co/image/15fed5371098fbf631193332164fba1d0e08c878"
"imageWidth": 64
}-
"albumName": "Abbey Road (Remastered)"
"albumType": "album"
"uri": "spotify:album:0ETFjACtuP2ADo6LFhL6HN"
}
```
##### Search for New Releases
Sample Search Query: `http://localhost:8080/spotifyData/newReleases?noOfNewReleases=5`
##### Sample Outcome (To avoid a lengthy document we have just shown one sample New release resource):
```
{
"newReleaseAlbumArtists": [1]
0:  {
"simpleArtistHref": "https://api.spotify.com/v1/artists/1Xylc3o4UrD53lo9CvFvVg"
"simpleArtistId": "1Xylc3o4UrD53lo9CvFvVg"
"simpleArtistName": "Zara Larsson"
"simpleArtistUri": "spotify:artist:1Xylc3o4UrD53lo9CvFvVg"
}-
"newReleaseAlbumHref": "https://api.spotify.com/v1/albums/1w0fs0y7Kb83F6ZmPpTDIB"
"newReleaseAlbumId": "1w0fs0y7Kb83F6ZmPpTDIB"
"newReleaseAlbumImages": [3]
0:  {
"imageHeight": 640
"imageUrl": "https://i.scdn.co/image/98c4f574b93d8135407b3d45debee4b4f67cd7e3"
"imageWidth": 640
}-
1:  {
"imageHeight": 300
"imageUrl": "https://i.scdn.co/image/6cdbb166c3d1305f3c42ca095705643c7c99e87f"
"imageWidth": 300
}-
2:  {
"imageHeight": 64
"imageUrl": "https://i.scdn.co/image/2c5b29b7f40b2ae1b77cae7b4e22fa6a3b0ae917"
"imageWidth": 64
}-
"newReleaseAlbumName": "Ain't My Fault"
"newReleaseAlbumUri": "spotify:album:1w0fs0y7Kb83F6ZmPpTDIB"
}
```
# Known Issues
- At this point **GetAccessToken** class expects the Client ID and Client Secret to be entered directly to the class body. I am working to come up with better method for that.
- I am working towards a better validation method for the parameters to be passed in search queries. **I am actively working on this ongoing implementation. I am open to any suggestions or comments.**
