/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp2112project2;

/**
 *
 * @author apple
 */
public class Song {
    String songName;
    String artist;
    int id;
    String genre;
    int year;

    //Constructor
    public Song(String songName, String artist, int id, String genre, int year) {
        this.songName = songName;
        this.artist = artist;
        this.id = id;
        this.genre = genre;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" + "songName=" + songName + ", artist=" + artist + ", id=" + id + ", genre=" + genre + ", year=" + year + '}';
    }
    
}
