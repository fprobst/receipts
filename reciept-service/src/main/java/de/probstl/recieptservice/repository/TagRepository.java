package de.probstl.recieptservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.probstl.recieptservice.data.Tag;

/**
 * Repository for accessing tags from the database
 * 
 * @author Florian
 */
public interface TagRepository extends CrudRepository<Tag, Long> {

	public List<Tag> findByAccountId(Long id);

}
