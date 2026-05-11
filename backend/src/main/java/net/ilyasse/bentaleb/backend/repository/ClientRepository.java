package net.ilyasse.bentaleb.backend.repository;

import net.ilyasse.bentaleb.backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
