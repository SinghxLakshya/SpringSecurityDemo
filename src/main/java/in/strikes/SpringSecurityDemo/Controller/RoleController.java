package in.strikes.SpringSecurityDemo.Controller;

import in.strikes.SpringSecurityDemo.Entity.Role;
import in.strikes.SpringSecurityDemo.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
@PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role){
       roleService.createRole(role);
       return ResponseEntity.ok("done");
    }
}
