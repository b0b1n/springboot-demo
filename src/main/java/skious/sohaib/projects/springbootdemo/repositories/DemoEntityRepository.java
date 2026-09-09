package skious.sohaib.projects.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import skious.sohaib.projects.springbootdemo.entities.DemoEntity;

@Repository
public interface DemoEntityRepository extends JpaRepository<DemoEntity, Integer> {}