package uk.co.killoran.codingassessment;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@CucumberContextConfiguration
@SpringBootTest
class CodingAssessmentApplicationTests {

	@Test
	void contextLoads() {
	}
}
