package crebito.kswelder.com.github.crebito.repositorios;

import crebito.kswelder.com.github.crebito.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
