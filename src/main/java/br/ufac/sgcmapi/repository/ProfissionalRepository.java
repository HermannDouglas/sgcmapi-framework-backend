package br.ufac.sgcmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufac.sgcmapi.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @Query("SELECT a FROM Profissional a" +
        " LEFT JOIN Profissional p ON p.id = a.profissional" +
        " LEFT JOIN Paciente pa ON pa.id = a.paciente" +
        " LEFT JOIN Convenio c ON c.id = a.convenio" +
        " LEFT JOIN Unidade u ON u.id = p.unidade" +
        " WHERE p.nome LIKE %?1%" +
        " OR pa.nome LIKE %?1%" +
        " OR c.nome LIKE %?1%" +
        " OR u.nome LIKE %?1%" + 
        " OR a.status LIKE %?1%")
    List<Profissional> findByAll(String termoBusca);
    
}
