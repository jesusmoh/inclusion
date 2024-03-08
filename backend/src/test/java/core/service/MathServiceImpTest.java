package core.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import core.model.dto.in.RequestKDTO;

@SpringBootTest
class MathServiceImpTest {

	@Autowired
	IMathService mathService;

	@Test
	void findTheMaximumIntegerK_test() {

		var request = new RequestKDTO();
		request.setX(2);
		request.setY(-222);
		request.setN(99);
		var k = this.mathService.findTheMaximumIntegerK(request);
		assertThat(k.getK()).isEqualTo(98);

	}

}
