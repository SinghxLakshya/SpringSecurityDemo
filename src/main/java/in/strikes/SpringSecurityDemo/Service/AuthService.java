package in.strikes.SpringSecurityDemo.Service;

import in.strikes.SpringSecurityDemo.DTO.UserRegisterRequestDto;
import in.strikes.SpringSecurityDemo.DTO.UserRegisterResponseDto;
import in.strikes.SpringSecurityDemo.Entity.Role;
import in.strikes.SpringSecurityDemo.Entity.User;
import in.strikes.SpringSecurityDemo.Repo.RoleRepository;
import in.strikes.SpringSecurityDemo.Repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(
            UserRegisterRequestDto registerRequestDto) {

        User user = new User();
        user.setUsername(registerRequestDto.getUsername());

        String encodedPassword =
                passwordEncoder.encode(registerRequestDto.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role=roleRepository.findByName("ROLE_USER").get();
        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto responseDto = new
                UserRegisterResponseDto();

        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User saved Successfully");

        return responseDto;

    }

    public Boolean login(UserRegisterRequestDto registerRequestDto) {
        Optional<User> userOptional = userRepository.findByUsername(
                registerRequestDto.getUsername());

        User user = userOptional.get();

        String encodedPassword = user.getPassword();

        return passwordEncoder.matches(
                registerRequestDto.getPassword(),
                encodedPassword
        );
    }
}
