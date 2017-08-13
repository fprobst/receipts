package de.probstl.recieptservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.probstl.recieptservice.data.Shop;

/**
 * Interface for accessing Shop classes from database
 * 
 * @author Florian
 */
public interface ShopRepository extends CrudRepository<Shop, Long> {

	public List<Shop> findByAccountId(Long id);
}
