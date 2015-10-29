package com.bjordan.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class MergedOrderedIntStreamTest {
	private int int1[] = new int[] {1,1,2,2,3,4,6,7,8,9,10,11,17,21};
	private int int2[] = new int[] {1,2,2,5,6,7,9,9,10,11,15,15,19,20};
	private int int3[] = new int[] {15,19,20,40,50};
	private int MERGED_STREAM_LEN = int1.length +  int2.length + int3.length;

	private OrderedIntStreamImpl stream1;
	private OrderedIntStreamImpl stream2;
	private OrderedIntStreamImpl stream3;
	MergedOrderedIntStream merged;

	@Before
	public void setup() {
		this.stream1 = new OrderedIntStreamImpl(int1);
		this.stream2 = new OrderedIntStreamImpl(int2);
		this.stream3 = new OrderedIntStreamImpl(int3);
		this.merged = new MergedOrderedIntStream(Arrays.asList(stream1, stream2, stream3));
	}

	@Test
	public void orderedStreamHasNext() {
		while(stream1.hasNext()) {
			assertThat(stream1.next()).isGreaterThan(0);
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void orderedStreamThrowsIndexOutOfBounds() {
		for(int i=0;i<int1.length+1;i++) {
			stream1.next();
		}
	}

	@Test
	public void mergeStreamHasValues() {
		assertThat(merged.hasNext()).isTrue();

		while(merged.hasNext()) {
			assertThat(merged.next()).isGreaterThan(0);
		}
	}

	@Test
	public void mergedStreamContainsCorrectCount() {
		int count = 0;
		while(merged.hasNext()) {
			merged.next();
			count++;
		}

		assertThat(count).isEqualTo(MERGED_STREAM_LEN);
	}

	@Test
	public void mergedSpotCheck() {
		List<Integer> mergedResults = new ArrayList();
		while(merged.hasNext())
			mergedResults.add(merged.next());

		assertThat(mergedResults.contains(50)).isTrue();
		assertThat(mergedResults.contains(40)).isTrue();
		assertThat(mergedResults.contains(21)).isTrue();
		assertThat(mergedResults.contains(1)).isTrue();
	}
}
