package practice.springinaction.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import practice.springinaction.domain.Taco;

public interface TacoRepository extends ReactiveCrudRepository<Taco, Long> {
}
