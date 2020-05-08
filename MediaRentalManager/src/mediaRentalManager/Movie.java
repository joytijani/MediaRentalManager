package mediaRentalManager;

/**
 * Defines what a Movie is which is a type of Media
 * 
 * @author joycetijani
 *
 */
public class Movie extends Media {
	private String rating;

	/**
	 * Makes a movie Object
	 * 
	 * @param title
	 * @param numOfCopies
	 * @param rating
	 */
	public Movie(String title, int numOfCopies, String rating) {
		super(title, numOfCopies);
		this.rating = rating;
	}

	/**
	 * gets the rating of a Movie
	 * 
	 * @return
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * returns a string with the title, number of copies avaiable, and the 
	 * rating of
	 * the movie
	 */
	public String toString() {
		return super.toString() + ", Rating: " + getRating();
	}
}
