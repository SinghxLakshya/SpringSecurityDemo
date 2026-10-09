package in.strikes.SpringSecurityDemo.Service;

import in.strikes.SpringSecurityDemo.Entity.Role;
import in.strikes.SpringSecurityDemo.Repo.RoleRepository;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }
}
