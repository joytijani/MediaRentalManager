package mediaRentalManager;

/**
 * Defines what an Album which is a type of Media
 * 
 * @author joycetijani
 *
 */
public class Album extends Media {
	private String artist;
	private String songs;

	/**
	 * Makes an Album Object
	 * 
	 * @param title
	 * @param numOfCopies
	 * @param artist
	 * @param songs
	 */
	public Album(String title, int numOfCopies, String artist, String songs) {
		super(title, numOfCopies);
		this.artist = artist;
		this.songs = songs;
	}

	/**
	 * returns the artist for the Album Object
	 * 
	 * @return
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * returns the songs for the Album Object
	 * 
	 * @return
	 */
	public String getSongs() {
		return songs;
	}

	/**
	 * returns a string with the title, number of copies available, the artist
	 * and
	 * the songs of the Album object
	 */
	public String toString() {
		return super.toString() + ", Artist: " + getArtist() + ", Songs: " + 
	getSongs();
	}
}
