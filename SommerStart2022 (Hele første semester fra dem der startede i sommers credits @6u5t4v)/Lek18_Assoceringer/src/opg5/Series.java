package opg5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;
    private ArrayList<Episode> episodes;

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
        return episode;
    }

    public ArrayList<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }

    public int totalLength() {
        int length = 0;
        for (Episode e : episodes) {
            length += e.getLengthMinutes();
        }
        return length;
    }

    public ArrayList<String> getGuestActors() {
        ArrayList<String> actors = new ArrayList<>();
        for (Episode e : episodes) {
            actors.addAll(e.getGuestActors());
        }
        return actors;
    }
}
