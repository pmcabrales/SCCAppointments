package gw.appointment.controller;

import gw.appointment.entity.Skill;
import gw.appointment.repository.SkillRepository;
import org.springframework.stereotype.Controller;

@Controller
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public Skill getSkill(Integer skillId) throws Exception {
        return skillRepository.findById(skillId.longValue()).orElseThrow(Exception::new);
    }

}
