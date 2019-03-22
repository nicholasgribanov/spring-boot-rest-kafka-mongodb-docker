package name.nicholasgribanov.consumer.repositories;

import name.nicholasgribanov.dto.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, String> {
}
