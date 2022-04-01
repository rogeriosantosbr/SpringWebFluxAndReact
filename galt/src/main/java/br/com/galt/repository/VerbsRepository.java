package br.com.galt.repository;




import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.galt.entity.Verbs;

@Repository
public interface VerbsRepository extends ReactiveCrudRepository<Verbs, Integer> {
}