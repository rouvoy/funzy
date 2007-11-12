// The MIT License - Copyright (c) 2007 Universitetet i Oslo

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE. 
package funzy.variables.fuzzy;

import funzy.variables.memberships.FuzzyMembership;
import funzy.variables.memberships.Line;

/**
 * Implementation of a Fuzzy function.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class FuzzyfierImpl implements Fuzzyfier {
	private final double unknown;
	
	public FuzzyfierImpl(double value) {
		this.unknown = value;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see funzy.functions.FuzzyFunction#fuzzy(double,funzy.membership.FuzzyMembership)
	 */
	public double fuzzy(double value, FuzzyMembership membership) {
		for (Line line : membership.get())
			if (line.inXRange(value))
				return (value - line.a().x()) * line.delta().y() + line.a().y();
		return unknown;
	}
}