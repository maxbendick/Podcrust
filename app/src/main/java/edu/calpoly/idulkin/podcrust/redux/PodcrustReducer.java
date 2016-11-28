package edu.calpoly.idulkin.podcrust.redux;

/**
 * Created by Max on 11/28/2016.
 */

public class PodcrustReducer {
    public static PodcrustState reduce(PodcrustState state, PodcrustAction action) {
        if (state == null) {
            return new PodcrustState(null, null, null, null, null);
        }

        switch(action.type) {
            case SEARCH:
                return state;
        }

        return state;
    }
}
