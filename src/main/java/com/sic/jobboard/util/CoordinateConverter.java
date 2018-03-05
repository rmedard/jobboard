package com.sic.jobboard.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CoordinateConverter implements AttributeConverter<Coordinate, String> {

	private static final String SEPARATOR = "|";
	private static final String VALUE_SEPARATOR = ":";

	@Override
	public String convertToDatabaseColumn(Coordinate coordinate) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("lat").append(VALUE_SEPARATOR)
				.append(coordinate.getLatitudeAsString())
				.append(SEPARATOR)
				.append("long").append(VALUE_SEPARATOR)
				.append(coordinate.getLongitudeAsString());
		return stringBuilder.toString();
	}

	@Override
	public Coordinate convertToEntityAttribute(String coordinateString) {
		String[] coordinateValues = coordinateString.split(SEPARATOR);
		return new Coordinate(Float.valueOf(coordinateValues[0].substring(coordinateValues[0].indexOf(":") + 1)),
				Float.valueOf(coordinateValues[0].substring(coordinateValues[1].indexOf(":") + 1)));
	}
}
