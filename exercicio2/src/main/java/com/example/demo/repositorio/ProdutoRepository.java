package com.example.demo.repositorio;

import com.example.demo.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :nomeProduto")
    Optional<Produto> findByNome(@Param("nomeProduto") String nomeProduto);

    @Query(value = "SELECT * FROM produto WHERE nome = :nomeProduto", nativeQuery = true)
    Optional<Produto> findByNomeSQL(@Param("nomeProduto") String nomeProduto);
}



