package furvent.stockwine.webService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import furvent.stockwine.webService.entity.WineDomain;

public interface WineDomainRepository extends JpaRepository<WineDomain, Long> {

}
