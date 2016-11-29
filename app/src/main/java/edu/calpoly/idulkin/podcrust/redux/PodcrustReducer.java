package edu.calpoly.idulkin.podcrust.redux;

/**
 * Created by Max on 11/28/2016.
 */

public class PodcrustReducer {
    public static PodcrustState reduce(PodcrustState state, PodcrustAction action) {
        if (state == null) {
            return new PodcrustState();
        }

        if (action instanceof SearchAction) {
            return state.assignSearchQuery(((SearchAction) action).query);
        }
        else if (action instanceof SelectShowAction) {
            return state.assignSelectedShow(((SelectShowAction) action).show);
        }


        return state;
    }
}
