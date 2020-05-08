package mediaRentalManager;

import java.util.ArrayList;

/*
 * Class that defines a Customer
 * A Customer has a name, address, plan, and rented and queue
 */
/**
 * Class that defines a Customer
 * 
 * @author joycetijani
 *
 */
public class Customer implements Comparable<Customer> {
	private String name;
	private String address;
	private String plan;
	private ArrayList<String> queue;
	private ArrayList<String> rented;
	private static int mediaLimit;

	/**
	 * Creates a customer object
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 */
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.queue = new ArrayList<String>();
		this.rented = new ArrayList<String>();
		if (this.plan.equals("LIMITED")) {
			mediaLimit = 2;
		}
	}

	/**
	 * adds the String of the title to the queue for the customer
	 * 
	 * @param mediaTitle
	 */
	public void addQueue(String mediaTitle) {
		queue.add(mediaTitle);
	}

	/**
	 * removes the String of the title from the queue for the customer
	 * 
	 * @param mediaTitle
	 */
	public void removeQueue(String mediaTitle) {
		queue.remove(mediaTitle);
	}

	/**
	 * adds the title of the media to the rented queue for a customer
	 * 
	 * @param mediaTitle
	 */
	public void addRented(String mediaTitle) {
		rented.add(mediaTitle);
	}

	/**
	 * removes the title of the media to the rented queue for a customer
	 * 
	 * @param mediaTitle
	 */
	public void removeRented(String mediaTitle) {
		rented.remove(mediaTitle);
	}

	/**
	 * returns the queue
	 * 
	 * @return
	 */
	public ArrayList<String> getQueue() {
		return queue;
	}

	/**
	 * returns the rented queue
	 * 
	 * @return
	 */
	public ArrayList<String> getRented() {
		return rented;
	}

	/**
	 * returns the name of the customer
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the plan that the customer has
	 * 
	 * @return
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * gets the mediaLimit for the customer's plan
	 * 
	 * @return
	 */
	public int getMediaLimit() {
		return mediaLimit;
	}

	/**
	 * sets the media that can be rented by the parameter passed in
	 * 
	 * @param limitAmount
	 */
	public static void setMediaLimit(int limitAmount) {
		mediaLimit = limitAmount;
	}

	/**
	 * returns a string with the name, address, plan, rented, and queue for the
	 * customer
	 */
	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Plan: " + plan + 
				"\nRented: " + rented + "\nQueue: "
				+ queue;
	}

	/**
	 * compares the customers by their names
	 */
	public int compareTo(Customer c) {
		return this.name.compareTo(c.name);
	}
}
