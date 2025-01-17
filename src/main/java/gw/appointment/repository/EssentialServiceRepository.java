package gw.appointment.repository;

import gw.appointment.entity.EssentialService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssentialServiceRepository extends JpaRepository<EssentialService, Long> {
}
