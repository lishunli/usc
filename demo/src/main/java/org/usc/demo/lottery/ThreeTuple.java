package org.usc.demo.lottery;

/**
 *
 * @author Shunli
 */
public class ThreeTuple<A, B, C> {
	public final A first;
	public final B second;
	public final C third;


	public ThreeTuple(A first, B second, C third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	public A getFirst() {
		return first;
	}
	public B getSecond() {
		return second;
	}
	public C getThird() {
		return third;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + ((third == null) ? 0 : third.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThreeTuple other = (ThreeTuple) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		if (third == null) {
			if (other.third != null)
				return false;
		} else if (!third.equals(other.third))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThreeTuple [first=" + first + ", second=" + second + ", third=" + third + "]";
	}

}
