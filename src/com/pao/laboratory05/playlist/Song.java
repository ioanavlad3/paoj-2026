package com.pao.laboratory05.playlist;

public record Song(String title, String artist, int durationSeconds)
        implements Comparable<Song> {

    public String formattedDuration() {
        return durationSeconds / 60 + ":" + String.format("%02d", durationSeconds % 60);
    }

    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.title);
    }

}
