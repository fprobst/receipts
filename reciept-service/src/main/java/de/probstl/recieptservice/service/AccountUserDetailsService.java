package de.probstl.recieptservice.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.probstl.recieptservice.data.Account;
import de.probstl.recieptservice.repository.AccountRepository;

/**
 * Service for loading the user details from the database
 * 
 * @author Florian
 */
@Service(value = "userDetailsService")
public class AccountUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository m_AccountRepository;

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Account account = m_AccountRepository.findByEmail(username);
		if (account == null) {
			throw new UsernameNotFoundException("No Account for E-Mail address");
		}

		User toReturn = new User(account.getEmail(), account.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority("USER")));
		detailsChecker.check(toReturn);
		return toReturn;
	}
}
