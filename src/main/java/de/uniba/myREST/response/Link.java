package de.uniba.myREST.response;

/**
 * Creates the custom datatype for the Link of the resources
 * Created by chandan on 07.09.16.
 */
public class Link {

    private String resourceLink;
    private String resourceRelation;

    /*
     * Constructors
     */
    public Link() {
    }

    public Link(String resourceLink, String resourceRelation) {
        this.resourceLink = resourceLink;
        this.resourceRelation = resourceRelation;
    }

    /*
     * Getter and Setter methods for the instance variables
     */
    public String getResourceLink() {
        return resourceLink;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    public String getResourceRelation() {
        return resourceRelation;
    }

    public void setResourceRelation(String resourceRelation) {
        this.resourceRelation = resourceRelation;
    }
}
