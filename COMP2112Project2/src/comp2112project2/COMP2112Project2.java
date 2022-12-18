
package comp2112project2;

import java.util.Scanner;

public class COMP2112Project2 {
 
    
    
    
        
        
        
        
        
    public static void main(String[] args) {
        AvlTreeWithId tree1 = new AvlTreeWithId();
        AvlTreeWithSongName tree2 = new AvlTreeWithSongName();
        AvlTreeWithArtist tree3 = new AvlTreeWithArtist();
        
        Scanner scanner = new Scanner(System.in);
        
        
        //Create the array in here
        Song[] songArray = new Song[5];
        
        
    
        //Create the objects in here
        Song s1 = new Song("a", "b", 0, "Rock", 2);
        Song s2 = new Song("c", "d", 1, "Pop", 4);
        Song s3 = new Song("e", "f", 2, "Edm", 6);
        Song s4 = new Song("g", "h", 3, "Phonk", 8);
        Song s5 = new Song("j", "k", 4, "Pop", 10);
        //Add the objects into the array
        
        songArray[0] = s1;
        songArray[1] = s2;
        songArray[2] = s3;
        songArray[3] = s4;
        songArray[4] = s5;
        
        SongNodeWithId idSong1 = new SongNodeWithId();
        SongNodeWithId idSong2 = new SongNodeWithId();
        SongNodeWithId idSong3 = new SongNodeWithId();
        SongNodeWithId idSong4 = new SongNodeWithId();
        SongNodeWithId idSong5 = new SongNodeWithId();
        
        
        tree1.root = tree1.insert(tree1.root, idSong1);
	tree1.root = tree1.insert(tree1.root, idSong2);
	tree1.root = tree1.insert(tree1.root, idSong3);
	tree1.root = tree1.insert(tree1.root, idSong4);
	tree1.root = tree1.insert(tree1.root, idSong5);
		
       
        
        
        SongNodeWithSongName songName1 = new SongNodeWithSongName("a");
        SongNodeWithSongName songName2 = new SongNodeWithSongName("c");
        SongNodeWithSongName songName3 = new SongNodeWithSongName("e");
        SongNodeWithSongName songName4 = new SongNodeWithSongName("g");
        SongNodeWithSongName songName5 = new SongNodeWithSongName("j");
        
       
        tree2.root = tree2.insert(tree2.root, songName1);
        tree2.root = tree2.insert(tree2.root, songName2);
        tree2.root = tree2.insert(tree2.root, songName3);
        tree2.root = tree2.insert(tree2.root, songName4);
        tree2.root = tree2.insert(tree2.root, songName5);
        
       
        
        
        SongNodeWithArtist artist1 = new SongNodeWithArtist("b");
        SongNodeWithArtist artist2 = new SongNodeWithArtist("d");
        SongNodeWithArtist artist3 = new SongNodeWithArtist("f");
        SongNodeWithArtist artist4 = new SongNodeWithArtist("h");
        SongNodeWithArtist artist5 = new SongNodeWithArtist("k");
        
        tree3.root = tree3.insert(tree3.root, artist1);
        tree3.root = tree3.insert(tree3.root, artist2);
        tree3.root = tree3.insert(tree3.root, artist3);
        tree3.root = tree3.insert(tree3.root, artist4);
        tree3.root = tree3.insert(tree3.root, artist5);
            
        
            
            
             
             
             
             
             
            
        System.out.println("Welcome");
        
        boolean condition = true;
        while(condition) {
            System.out.println("1- Search with Id \n2- Search with song name \n3- Search with artist name \n4- Delete with id \n5- Search within the range \n6- Exit");
            int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("Enter the id you want to search : ");
                int id = scanner.nextInt();
                int indexArray = tree1.search(tree1.root, id).indexOfArray;
                System.out.println(songArray[indexArray].toString());
                break;
            case 2:
                System.out.println("Enter the song name you want to search : ");
                String songName = scanner.next();
                int indexArray2 = tree2.search(tree2.root, songName).indexOfArray;
                System.out.println(songArray[indexArray2]);
                break;
            case 3:
                System.out.println("Enter the artist name you want to search : ");
                String artistName = scanner.next();
                int indexArray3 = tree3.search(tree3.root, artistName).indexOfArray;
                System.out.println(songArray[indexArray3]);
                break;
            case 4:
                System.out.println("Enter the id you want to delete : ");
                int deleteId = scanner.nextInt();
                tree1.root = tree1.deleteNode(tree1.root, deleteId);
                tree2.root = tree2.deleteNode(tree2.root, deleteId);
                tree3.root = tree3.deleteNode(tree3.root, deleteId);
                System.out.println("---");
                tree1.preOrder(tree1.root);
                tree2.preOrder(tree2.root);
                tree3.preOrder(tree3.root);
                break;
            case 5:
                System.out.println("Enter the ranges you want to traverse : ");
                System.out.println("Enter the min value :");
                int min = scanner.nextInt();
                System.out.println("Enter the max value : ");
                int max = scanner.nextInt();
                tree1.preOrderWithinTheRange(tree1.root, min, max, songArray);
                break;
            case 6:
                condition = false;
                System.out.println("Exit");
                break;
                default:
                    System.out.println("Unvalid operation");
                    break;
                /*
            case 2:
     
                System.out.println("Enter the id you want to delete : ");
                int id2 = scanner.nextInt();
                int indexArray2 = tree1.search(tree1.root, id2).indexOfArray;
                tree1.deleteNode(tree1.root, id2);
                tree1.preOrder(tree1.root);
                break;
                */
        }
        }
       
       
        
        
        
    }
}
