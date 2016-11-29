package edu.calpoly.idulkin.podcrust.redux;

import trikita.jedux.Store;

/**
 * Created by Max on 11/28/2016.
 */

public class PodcrustStore {
    public static Store<PodcrustAction, PodcrustState> store =
            new Store<>(new Store.Reducer<PodcrustAction, PodcrustState>() {
                @Override
                public PodcrustState reduce(PodcrustAction a, PodcrustState s) {
                    return PodcrustReducer.reduce(a, s);
                }
            }, null, null);

    public static Runnable subscribe(final Runnable r) {
        return store.subscribe(r);
    }
    public static PodcrustState getState() {
        return store.getState();
    }
    public static PodcrustState dispatch(PodcrustAction a) {
        return store.dispatch(a);
    }
}
