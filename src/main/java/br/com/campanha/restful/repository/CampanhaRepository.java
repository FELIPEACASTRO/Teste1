package br.com.campanha.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.campanha.restful.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}
