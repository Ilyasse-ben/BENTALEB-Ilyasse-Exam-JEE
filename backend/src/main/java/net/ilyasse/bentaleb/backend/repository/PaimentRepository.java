package net.ilyasse.bentaleb.backend.repository;

import net.ilyasse.bentaleb.backend.entity.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaimentRepository extends JpaRepository<Paiment,Long> {
}
