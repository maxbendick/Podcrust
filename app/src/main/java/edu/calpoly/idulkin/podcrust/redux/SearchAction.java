package edu.calpoly.idulkin.podcrust.redux;

/**
 * Created by Max on 11/28/2016.
 */

public class SearchAction extends PodcrustAction {
    public final String query;

    public SearchAction(String query) {
        this.query = query;
    }
}
