package skious.sohaib.projects.springbootdemo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import skious.sohaib.projects.springbootdemo.DemoApplication;
import skious.sohaib.projects.springbootdemo.entities.DemoEntity;

@SpringBootTest(classes = DemoApplication.class)
public class DemoEntityRepositoryTest {

	@Autowired
	private DemoEntityRepository entityRepository;

	@Test
	public void shouldSaveEntity() {
		DemoEntity entity = entityRepository.save(new DemoEntity(3, "The third"));
		DemoEntity foundedEntity = entityRepository.findById(entity.getId()).get();

		assertNotNull(foundedEntity);
		assertEquals(entity.getLabel(), foundedEntity.getLabel());
	}
}