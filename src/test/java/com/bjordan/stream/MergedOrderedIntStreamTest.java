package com.bjordan.stream;

import junit.framework.TestCase;

import java.util.Arrays;

public class MergedOrderedIntStreamTest extends TestCase {

	public void mergeStreamDataWerkz() {
		OrderedIntStreamImpl stream1 = new OrderedIntStreamImpl(new int[] {1,1,2,2,3,4,6,7,8,9,10,11,17,21});
		OrderedIntStreamImpl stream2 = new OrderedIntStreamImpl(new int[] {1,2,2,5,6,7,9,9,10,11,15,15,19,20});
		OrderedIntStreamImpl stream3 = new OrderedIntStreamImpl(new int[] {15,19,20,40,50});

		MergedOrderedIntStream merged = new MergedOrderedIntStream(Arrays.asList(stream1, stream2, stream3));
		while(merged.hasNext())
			System.out.println(merged.next());
	}
}
