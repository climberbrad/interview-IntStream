package com.bjordan.stream;

public class OrderedIntStreamImpl implements OrderedIntStream {
	private int position;
	private int[] stream;

	public OrderedIntStreamImpl(int[] stream) {
		this.stream = stream;
		this.position = 0;
	}

	public int next() {
		int result = -1;
		if (position < stream.length) {
			result = stream[position];
			position++;
		}
		return result;
	}

	public boolean hasNext() {
		return position < stream.length;
	}
}
