package be.umons_project.pgl_back_end.repositries;

import be.umons_project.pgl_back_end.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepositories extends JpaRepository<Person,Integer> {

}
