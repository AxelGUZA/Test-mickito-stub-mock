
 import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import org.junit.Test;

public class TestDoublures {
	
	@Test
	public void test_UnpremierStub() {
		
		User user = mock(User.class);
		when(user.getLogin()).thenReturn("Fabien");
		System.out.println(user.getLogin());
		assertEquals(user.getLogin(), "Fabien");
		//assertEquals(user.getLogin(), "Mathieu");
	}
	
	@Test
	public void test_UnpremierMock() {
		
		User user = mock(User.class);
		when(user.getLogin()).thenReturn("Fabien");
		
		System.out.println(user.getLogin());
		System.out.println(user.getLogin());
		verify(user,times(2)).getLogin();
	}
	
	@Test
	public void test_OptionVerification() {
		LinkedList<String> mockedList = mock(LinkedList.class);
		
		 mockedList.add("once");

		 mockedList.add("twice");
		 mockedList.add("twice");

		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");

		//following two verifications work exactly the same - times(1) is used by default
		 verify(mockedList).add("once");
		 verify(mockedList, times(1)).add("once");

		 //exact number of invocations verification
		 verify(mockedList, times(2)).add("twice");
		 verify(mockedList, times(3)).add("three times");

		 //verification using never(). never() is an alias to times(0)
		 verify(mockedList, never()).add("never happened");

		 //verification using atLeast()/atMost()
		 verify(mockedList, atLeastOnce()).add("three times");
		 verify(mockedList, atLeast(2)).add("three times");
		 verify(mockedList, atMost(5)).add("three times");
	}

}
