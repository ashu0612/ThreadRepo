package org.java.rest.Messanger.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

//This is the custom comparator that will convert path param
//to custom data mapper that is Test comparator.
@Provider
public class MapParamConverter implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		// TODO Auto-generated method stub
		// logic that will define for converter
		if (rawType.getName().equals(TestComparator.class.getName())) {
			return new ParamConverter<T>() {
				int noOfDays;

				@Override
				public T fromString(String value) {
					// TODO Auto-generated method stub
					if ("year".equals(value)) {
						noOfDays = 365;
					}
					if ("month".equalsIgnoreCase(value)) {
						noOfDays = 31;
					}
					if ("week".equalsIgnoreCase(value)) {
						noOfDays = 7;
					}
					TestComparator test = new TestComparator();
					test.setNoOfDays(noOfDays);
					// this will cast generic type to our custom
					// comparator code.
					return rawType.cast(test);
				}

				@Override
				public String toString(T value) {
					// TODO Auto-generated method stub
					if (value != null) {
						return value.toString();
					} else {
						return null;
					}

				}
			};
		}
		return null;

	}

}
