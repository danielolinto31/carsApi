package tech.dev.daniel.carsApi.api;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tech.dev.daniel.carsApi.entity.Car;

@RepositoryRestResource(
        path = "cars",
        collectionResourceRel = "cars"
)
public interface CarRestRepository extends
        CrudRepository<Car, UUID>,
        PagingAndSortingRepository<Car, UUID> {

    List<Car> findByModelo(@Param("modelo") String modelo);

    @Override
    @RestResource(exported = false)
    void deleteById(UUID uuid);
}
