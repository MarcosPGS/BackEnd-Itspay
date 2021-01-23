package com.play.check.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.play.check.model.DadoRequisicao;
@Repository
public interface DadoRequisicaoRepository extends JpaRepository<DadoRequisicao, Long>{
	
//	@Query("SELECT d FROM DadoRequisicao d WHERE MONTH(dataRequisicao) = :mes AND d.cliente.id = :idCliente")
	@Query("select d from DadoRequisicao d join d.cliente c "
			+ "where  upper( c.nome ) like upper( :nome ) and MONTH( d.dataRequisicao ) =:mes")
	public List<DadoRequisicao> findAllDataRequisica(@Param("mes") int mes, @Param("nome") String nome);

}
