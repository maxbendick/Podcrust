package edu.calpoly.idulkin.podcrust.redux;

import java.util.List;

/**
 * Created by Max on 11/28/2016.
 */

public class PodcrustState {
    public final Show selectedShow;
    public final Episode selectedEpisode;
    public final List<Show> shows;
    public final List<Episode> episodes;
    public final String searchQuery;

    public PodcrustState(Show selectedShow, Episode selectedEpisode, List<Show> shows, List<Episode> episodes, String searchQuery) {
        this.selectedShow = selectedShow;
        this.selectedEpisode = selectedEpisode;
        this.shows = shows;
        this.episodes = episodes;
        this.searchQuery = searchQuery;
    }
    public PodcrustState() {
        this.selectedShow = null;
        this.selectedEpisode = null;
        this.shows = null;
        this.episodes = null;
        this.searchQuery = null;
    }
    public PodcrustState assignSelectedShow(PodcrustState.Show selectedShow) {
        return new PodcrustState(selectedShow, this.selectedEpisode, this.shows, this.episodes, this.searchQuery);
    }
    public PodcrustState assignSelectedEpisode(PodcrustState.Episode selectedEpisode) {
        return new PodcrustState(this.selectedShow, selectedEpisode, this.shows, this.episodes, this.searchQuery);
    }
    public PodcrustState assignShows(List<PodcrustState.Show> shows) {
        return new PodcrustState(this.selectedShow, this.selectedEpisode, shows, this.episodes, this.searchQuery);
    }
    public PodcrustState assignepisodes(List<PodcrustState.Episode> episodes) {
        return new PodcrustState(this.selectedShow, this.selectedEpisode, this.shows, episodes, this.searchQuery);
    }
    public PodcrustState assignSearchQuery(String searchQuery) {
        return new PodcrustState(this.selectedShow, this.selectedEpisode, this.shows, this.episodes, searchQuery);
    }

    public static class Episode {}
    public static class Show{}
}