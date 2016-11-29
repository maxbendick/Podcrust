package edu.calpoly.idulkin.podcrust.redux;

/**
 * Created by Max on 11/28/2016.
 */

public class SelectShowAction extends PodcrustAction {
    public final PodcrustState.Show show;

    public SelectShowAction(PodcrustState.Show show) {
        this.show = show;
    }
}
