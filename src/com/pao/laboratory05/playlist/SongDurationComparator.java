package com.pao.laboratory05.playlist;

import java.util.Comparator;

public class SongDurationComparator implements Comparator<Song> {
    @Override
    public int compare(Song t, Song o) {
        if (t.durationSeconds() == o.durationSeconds())
            return 0;
        return t.durationSeconds() < o.durationSeconds() ? -1 : 1 ;
    }

}
