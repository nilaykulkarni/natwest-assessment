package com.natwest.assessment;

import com.natwest.assessment.controller.PrimeNumberController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NatwestAssessmentApplicationTests {

	@Autowired
	private PrimeNumberController primeNumberController;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(primeNumberController);
	}

}
