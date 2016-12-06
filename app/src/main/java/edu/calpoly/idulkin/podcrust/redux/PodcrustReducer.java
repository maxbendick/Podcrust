package edu.calpoly.idulkin.podcrust.redux;

/**
 * Created by Max on 11/28/2016.
 */

public class PodcrustReducer {
    public static PodcrustState reduce(PodcrustAction action, PodcrustState state) {
        if (state == null) {
            return new PodcrustState();
        }

        if (action instanceof SearchAction) {
            return state
                .assignSearchQuery(((SearchAction) action).query)
                .assignRoute(PodcrustState.Route.SEARCH);
        }
        else if (action instanceof SelectShowAction) {
            return state
                .assignSelectedShow(((SelectShowAction) action).show)
                .assignRoute(PodcrustState.Route.SHOW);
        }
        else if (action instanceof DisplayTrendingAction) {
            return state
                .assignRoute(PodcrustState.Route.TRENDING);
        }

        return state;
    }
}
