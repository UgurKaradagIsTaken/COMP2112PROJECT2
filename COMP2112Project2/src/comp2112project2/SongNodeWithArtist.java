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
public class SongNodeWithArtist {
    String artist;
    int indexOfArray = -1;
    static int count = -1;
    int height = 1;
    SongNodeWithArtist left;
    SongNodeWithArtist right;

    public SongNodeWithArtist(String artist) {
        SongNodeWithArtist.count++;
        this.artist = artist;
        this.indexOfArray = count;
        left = null;
        right = null;
    }
    
}
