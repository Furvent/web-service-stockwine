package furvent.stockwine.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import furvent.stockwine.webService.entity.WineReference;

public interface WineReferenceRepository extends JpaRepository<WineReference, Long> {

}
