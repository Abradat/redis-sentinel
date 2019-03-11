package mp01.examples.redis.sentinel.repository;

import mp01.examples.redis.sentinel.domain.SystemState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SystemStateRepository extends CrudRepository<SystemState, String> {
    SystemState findSystemStateBySystemName(String systemName);
}
