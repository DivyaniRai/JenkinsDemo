package com.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
// assignment-solution
//how to test method which returns void.
//how to test an interface which we don't have implementation.
//how to test number of times the test is invoked. if that number of time its invoked then test successful otherwise failed.

class ITest {

	@Test
	void testAbc() {
		I i1 = mock(I.class);
		i1.abc();
		verify(i1,times(1)).abc();
	}

}
