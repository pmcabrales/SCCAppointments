package gw.appointment.repository;

import gw.appointment.entity.ServiceSkill;
import gw.appointment.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceSkillRepository extends JpaRepository<ServiceSkill, Long> {
}
