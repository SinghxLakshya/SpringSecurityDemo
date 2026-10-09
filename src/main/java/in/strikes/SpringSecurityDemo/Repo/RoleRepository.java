package in.strikes.SpringSecurityDemo.Repo;

import in.strikes.SpringSecurityDemo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
