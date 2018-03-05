package com.sic.jobboard.util;

import java.text.DecimalFormat;

public class Coordinate implements Comparable<Coordinate> {

	private float latitude;
	private float longitude;
	private DecimalFormat format;

	public Coordinate(float latitude, float longitude) {
		if(CoordinateManager.isValidLatitude(latitude) && CoordinateManager.isValidLongitude(longitude)) {
			this.latitude = latitude;
			this.longitude = longitude;
		} else {
			throw new IllegalArgumentException("The parameters did not pass validation as defined by the CoordinateManager class");
		}
		this.format = new DecimalFormat("##.######");
	}

	/*
	 * get and set methods
	 */
	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLatitude(float latitude) {
		if(CoordinateManager.isValidLatitude(latitude)) {
			this.latitude = latitude;
		} else {
			throw new IllegalArgumentException("The parameter did not pass validation as defined by the CoordinateManager class");
		}
	}

	public void setLongitude(float longitude) {
		if(CoordinateManager.isValidLongitude(longitude)) {
			this.longitude = longitude;
		} else {
			throw new IllegalArgumentException("The parameter did not pass validation as defined by the CoordinateManager class");
		}
	}

	public String getLatitudeAsString() {
		return format.format(latitude);
	}

	public String getLongitudeAsString() {
		return format.format(longitude);
	}

	public String toString() {
		return format.format(latitude) + ", " + format.format(longitude);
	}

	/*
	 * methods required for ordering in collections
	 * http://java.sun.com/docs/books/tutorial/collections/interfaces/order.html
	 */

	/**
	 * A method to determine if one event is the same as another
	 *
	 * @param o the object to compare this one to
	 *
	 * @return  true if they are equal, false if they are not
	 */
	public boolean equals(Object o) {
		// check to make sure the object is an event
		if (!(o instanceof Coordinate)) {
			// o is not an event object
			return false;
		}

		// compare these two events
		Coordinate c = (Coordinate)o;

		// build items for comparison
		String me  = this.getLatitudeAsString() + this.getLongitudeAsString();
		String you = c.getLatitudeAsString() + c.getLongitudeAsString();

		return me.equals(you);
	}

	/**
	 * Overide the default hashcode method
	 *
	 * @return a hashcode for this object
	 */
	public int hashCode() {

		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		return 31*me.hashCode();
	}

	/**
	 * The compareTo method compares the receiving object with the specified object and returns a
	 * negative integer, 0, or a positive integer depending on whether the receiving object is
	 * less than, equal to, or greater than the specified object.
	 *
	 * @param c the event to compare this one to
	 *
	 * @return  an integer indicating comparison result
	 */
	public int compareTo(Coordinate c) {

		String me  = this.getLatitudeAsString() + this.getLongitudeAsString();
		String you = c.getLatitudeAsString() + c.getLongitudeAsString();

		Double meDbl  = Double.valueOf(me);
		Double youDbl = Double.valueOf(you);

		if(meDbl.equals(youDbl)) {
			return 0;
		} else {
			Double tmp = Math.floor(meDbl - youDbl);
			return tmp.intValue();
		}
	}
}
