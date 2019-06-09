package guru.springframework.repositories;

import guru.springframework.models.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jleoirab on 2019-06-09
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
