package de.probstl.recieptservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import de.probstl.recieptservice.data.Account;

/**
 * Interface for accessing Account classes from database
 * 
 * @author Florian
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	/**
	 * Find an account by the given e-mail address. The method returns only one
	 * account because the e-mail of all accounts must be unique.
	 * 
	 * @param email
	 *            The e-mail of the account user
	 * @return The account or <code>null</code> if there is no account
	 */
	Account findByEmail(String email);

	/**
	 * To a login of the given user. If the password matches the login timestamp
	 * is updated and the value 1 is returned. Otherwise the value 0 is
	 * returned.
	 * 
	 * @param email
	 *            The account's e-mail address
	 * @param password
	 *            The given password
	 * @return Returns 1 if the login was successful otherwise 0
	 */
	@Transactional
	@Modifying
	@Query(value = "update account set lastLogin = current_timestamp where email=?1 and password = crypt(?2, password)", nativeQuery = true)
	int login(String email, String password);

	/**
	 * Updates the password of the given user account. The timestamp of last
	 * password change is updated only by this query
	 * 
	 * @param email
	 *            The e-mail address of the account
	 * @param password
	 *            The new password
	 * @return Returns 1 if successful or 0 when update was not successful
	 */
	@Transactional
	@Modifying
	@Query(value = "update account set password = crypt(?2, password), passwordChanged = current_timestamp where email=?1", nativeQuery = true)
	int updatePassword(String email, String password);

}
