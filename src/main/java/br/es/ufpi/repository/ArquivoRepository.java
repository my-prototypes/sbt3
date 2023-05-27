package br.es.ufpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.es.ufpi.entity.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
}