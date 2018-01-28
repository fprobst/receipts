package de.probstl.recieptservice.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.probstl.recieptservice.data.Account;
import de.probstl.recieptservice.data.Registration;
import de.probstl.recieptservice.repository.AccountRepository;

@RestController
public class ReceiptController {

	/** The Repository for looking up users */
	@Autowired
	private AccountRepository m_AccountRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public void register(@RequestBody Registration registration) {

		Account account = m_AccountRepository.findByEmail(registration.getEmail());
		if (account != null) {
			// Error - E-Mail address already taken
			throw new IllegalArgumentException("E-Mail adresse already taken");
		}

		account = new Account();
		account.setFirstname(registration.getFirstname());
		account.setLastname(registration.getLastname());
		account.setEmail(registration.getEmail());
		account.setPassword(registration.getPassword());

		m_AccountRepository.save(account);
	}

	@ExceptionHandler
	public void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response)
			throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

}
