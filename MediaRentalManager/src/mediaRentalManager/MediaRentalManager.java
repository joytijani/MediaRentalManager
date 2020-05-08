package mediaRentalManager;

import java.util.*;

public class MediaRentalManager implements MediaRentalManagerInt {
	private ArrayList<Customer> customers;
	private ArrayList<Media> media;

	public MediaRentalManager() {
		customers = new ArrayList<Customer>();
		media = new ArrayList<Media>();
	}

	public void addCustomer(String name, String address, String plan) {
		customers.add(new Customer(name, address, plan));
	}

	public void addMovie(String title, int copiesAvailable, String rating) {
		media.add(new Movie(title, copiesAvailable, rating));
	}

	public void addAlbum(String title, int copiesAvailable, String artist, 
			String songs) {
		media.add(new Album(title, copiesAvailable, artist, songs));
	}

	public void setLimitedPlanLimit(int value) {
		Customer.setMediaLimit(value);
	}

	public String getAllCustomersInfo() {
		Collections.sort(customers);
		String customerInfo = "***** Customers' Information *****\n";
		for (Customer c : customers) {
			customerInfo += c.toString() + "\n";
		}

		return customerInfo;
	}

	public String getAllMediaInfo() {
		Collections.sort(media);
		String mediaInfo = "***** Media Information *****\n";
		for (Media m : media) {
			mediaInfo += m.toString() + "\n";
		}

		return mediaInfo;
	}

	public boolean addToQueue(String customerName, String mediaTitle) {
		for (Customer c : customers) {
			if (c.getName().equals(customerName)) {
				if (c.getQueue().contains(mediaTitle)) {
					return false;
				} else {
					c.addQueue(mediaTitle);
					return true;
				}
			}
		}
		return false;
	}

	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for (Customer c : customers) {
			if (c.getName().equals(customerName)) {
				if (!c.getQueue().contains(mediaTitle)) {
					return false;
				} else {
					c.removeQueue(mediaTitle);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * checks the number of copies avaliable for a specific piece of media
	 * 
	 * @param mediaTitle
	 * @return
	 */
	private boolean copiesAvaiable(String mediaTitle) {
		for (Media m : media) {
			if (m.getTitle().equals(mediaTitle)) {
				if (m.getNumOfCopies() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * rents a piece of media to a customer by adding it to their rented queue and
	 * also removes a copy from the media
	 * 
	 * @param c
	 * @param mediaTitle
	 */
	private void rentMedia(Customer c, String mediaTitle) {
		c.addRented(mediaTitle);
		for (Media m : media) {
			if (m.getTitle().equals(mediaTitle)) {
				m.removeCopies();
			}
		}
	}

	public String processRequests() {
		String sending = "";
		ArrayList<String> rentedOut = new ArrayList<String>();
		Collections.sort(customers);
		for (Customer c : customers) {
			if (c.getPlan().equals("UNLIMITED")) {
				for (String m : c.getQueue()) {
					if (copiesAvaiable(m)) {
						rentedOut.add(m);
						rentMedia(c, m);
						sending += "Sending " + m + " to " + c.getName() + "\n";
					}
				}
			} else if (c.getPlan().equals("LIMITED") && c.getRented().size() <= c.getMediaLimit()) {
				for (String m : c.getQueue()) {
					if (c.getRented().size() < c.getMediaLimit() && copiesAvaiable(m)) {
						rentedOut.add(m);
						rentMedia(c, m);
						sending += "Sending " + m + " to " + c.getName() + "\n";
					}
				}
			}
			for (String m : rentedOut) {
				c.removeQueue(m);
			}
			rentedOut.clear();
		}

		return sending;
	}

	public boolean returnMedia(String customerName, String mediaTitle) {
		for (Customer c : customers) {
			if (c.getName().equals(customerName)) {
				c.removeRented(mediaTitle);
				Customer.setMediaLimit(c.getMediaLimit() + 1);
				for (Media m : media) {
					if (m.getTitle().equals(mediaTitle)) {
						m.increaseCopies();
					}
				}
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> searchMedia(String title, String rating, 
			String artist, String songs) {
		Collections.sort(media);
		ArrayList<String> ans = new ArrayList<String>();
		if (title == null && rating == null && artist == null && songs == null) {
			for (Media m : media) {
				ans.add(m.getTitle());
			}
			return ans;
		}

		for (Media m : media) {
			if (title != null) {
				if (m.getTitle().equals(title)) {
					ans.add(m.getTitle());
				}
			}
			if (m instanceof Movie) {
				if (rating != null) {
					if (((Movie) m).getRating().equals(rating)) {
						ans.add(m.getTitle());
					}
				}

			}
			if (m instanceof Album) {
				if (artist != null) {
					if (((Album) m).getArtist().equals(artist)) {
						ans.add(m.getTitle());
					}
				}
				if (songs != null) {
					if (((Album) m).getSongs().contains(songs)) {
						ans.add(m.getTitle());
					}
				}
			}
		}
		return ans;
	}
}
