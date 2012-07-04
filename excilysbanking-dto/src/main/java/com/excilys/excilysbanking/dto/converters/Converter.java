
package com.excilys.excilysbanking.dto.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Converter<S, T> {

	public abstract T convert(S s);

	public List<T> convert(Collection<S> sColl) {
		List<T> result = new ArrayList<T>(sColl.size());
		for (S s : sColl)
			result.add(convert(s));
		return result;
	}
}
