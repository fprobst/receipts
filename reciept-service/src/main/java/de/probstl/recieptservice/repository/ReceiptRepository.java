package de.probstl.recieptservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.probstl.recieptservice.data.Receipt;

/**
 * The repository for accessing receipts from the database
 * 
 * @author Florian
 */
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

	public List<Receipt> findByAccountIdAndShopIdAndReceiptDateBetweenOrderByReceiptDateDesc(Long accountId,
			Long shopId, Date from, Date to);

	public List<Receipt> findByAccountIdAndShopIdOrderByReceiptDateDesc(Long accountId, Long shopId);

	public List<Receipt> findByAccountIdAndReceiptDateBetweenOrderByReceiptDateDesc(Long accountId, Date from, Date to);

	public List<Receipt> findByAccountIdAndAnnotationLikeOrderByReceiptDateDesc(Long accountId, String searchString);

	public List<Receipt> findByAccountIdOrderByReceiptDateDesc(Long id);
}
