package com.bjordan.stream;

import java.util.List;

public class MergedOrderedIntStream implements OrderedIntStream {
	private final List<OrderedIntStreamImpl> streams;

	public MergedOrderedIntStream(List<OrderedIntStreamImpl> streams) {
		this.streams = streams;
	}

	@Override
	public int next() {
		return 0;
	}

	@Override
	public boolean hasNext() {
		return false;
	}
}
