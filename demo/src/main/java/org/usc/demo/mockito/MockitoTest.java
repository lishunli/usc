package org.usc.demo.mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;

/**
 * 
 * @author ShunLi
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MockitoTest {

	@Test
	public void test1() {
		// mock creation
		List mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add(eq("one"));
		verify(mockedList).clear();
	}

}
