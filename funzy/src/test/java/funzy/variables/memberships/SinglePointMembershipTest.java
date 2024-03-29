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
package funzy.variables.memberships;

import static funzy.variables.memberships.PointMembership.newPoint;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import funzy.variables.IllegalRangeException;

/**
 * Test of a graph point.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class SinglePointMembershipTest {
	private double a, b;
	private PointMembership p;

	@Before
	public void setup() {
		a = 20;
		b = 30;
		p = newPoint(a, b);
	}

	@Test
	public void checkNewPoint() {
		assertEquals(a, p.x());
		assertEquals(b, p.y());
	}

	@Test
	public void checkEqualsPoint() {
		assertEquals(p, newPoint(a,b));
	}
	
	@Test
	public void fuzzy() {
		assertEquals(b,p.fuzzy(a));
	}

	@Test(expected=IllegalRangeException.class)
	public void fuzzyFailure() {
		p.fuzzy(b);
	}

	@Test
	public void unfuzzy() {
		assertEquals(a,p.unfuzzy(b));
	}

	@Test(expected=IllegalRangeException.class)
	public void unfuzzyFailure() {
		p.unfuzzy(a);
	}
}