package songLib;

/**
 * This is for the Song Object
 * @param A string that contains name, artist, year, album. Seperated by space.
 *
 */
public class Song {
	protected String name;
	protected String artist;
	protected String year;
	protected String album;
	
	public Song(String name, String artist, String year, String album){
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.album = album;
	}
}