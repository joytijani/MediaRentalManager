package mediaRentalManager;

/**
 * Class that defines what a Media
 * 
 * @author joycetijani
 *
 */
public class Media implements Comparable<Media> {
	private String title;
	private int numOfCopies;

	/**
	 * creates a media Object
	 * 
	 * @param title
	 * @param numOfCopies
	 */
	public Media(String title, int numOfCopies) {
		this.title = title;
		this.numOfCopies = numOfCopies;
	}

	/**
	 * returns the title of the media
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * returns the number of copies avaliable for the media
	 * 
	 * @return
	 */
	public int getNumOfCopies() {
		return numOfCopies;
	}

	/**
	 * increases the number of copies avaliable for the media
	 */
	public void increaseCopies() {
		numOfCopies++;
	}

	/**
	 * decreases the number of copies avaliable for the media
	 */
	public void removeCopies() {
		numOfCopies--;
	}

	/**
	 * compares Media by their title
	 */
	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.title);
	}

	/**
	 * returns a string of the title and number of copies avaliable
	 */
	public String toString() {
		return "Title: " + getTitle() + ", Copies Available: " + 
	getNumOfCopies();
	}
}
