/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.io.Serializable;

/**
 * This is for the Song Object
 * @param A string that contains name, artist, year, album. Separated by space.
 *
 */
public class Song implements Comparable<Song>, Serializable{
	protected String name;
	protected String artist;
	protected String year;
	protected String album;
	
	public Song(String name, String artist, String album, String year){
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.album = album;
	}
	
	public int compareTo(Song s2){
		return name.compareToIgnoreCase(s2.name);
	}
	
	public String[] getInfo()
	{
		String[] info= new String[4];
		info[0] = name;
		info[1] = artist;
		info[2] = album;
		info[3] = year;
		return info;
	}
}
