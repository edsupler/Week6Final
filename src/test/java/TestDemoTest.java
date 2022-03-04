import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments; //this came from Jiii
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
class TestDemoTest {
	
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	
	


	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly() {
		int a;
		int b;
		int expected;
		Boolean expectException;
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			//this instruction came from 4e directly, I can't get rid of
			// of the red line, no idea why
		} else {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);

		}
	}
	
	@Test
	private void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
		static Stream<Arguments> argumentsForAddPositive(){
			return Stream.of(
				arguments(2,4,6, false),
				arguments(4,4,8, false),
				arguments(0,0,0, true),
				arguments(5,5,10, false),
				arguments(-1,-1,-2, true)
				);
		}
		
		
			
		
		
		
	}
