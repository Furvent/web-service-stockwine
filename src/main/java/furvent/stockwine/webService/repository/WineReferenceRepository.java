package furvent.stockwine.webService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import furvent.stockwine.webService.entity.WineReference;

public interface WineReferenceRepository extends JpaRepository<WineReference, Long> {
	public List<WineReference> findAllByNameContaining(String name);
	
	public Optional<WineReference> findByPublicId(String publicId);
}
