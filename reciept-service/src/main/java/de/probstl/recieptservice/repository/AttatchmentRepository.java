package de.probstl.recieptservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.probstl.recieptservice.data.Attachment;

/**
 * Repository for accessing Attachments from the database
 * 
 * @author Florian
 */
public interface AttatchmentRepository extends JpaRepository<Attachment, Long> {
}
