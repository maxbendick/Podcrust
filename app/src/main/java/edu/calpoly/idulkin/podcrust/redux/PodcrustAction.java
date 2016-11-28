package edu.calpoly.idulkin.podcrust.redux;

/**
 * Created by Max on 11/28/2016.
 */

public abstract class PodcrustAction {
    public static enum Type {
        SEARCH
    }

    public final Type type;

    public PodcrustAction(Type type) {
        this.type = type;
    }

}
