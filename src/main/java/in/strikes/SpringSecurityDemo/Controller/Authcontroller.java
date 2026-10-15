package in.strikes.SpringSecurityDemo.Controller;

import in.strikes.SpringSecurityDemo.DTO.LoginreponseDto;
import in.strikes.SpringSecurityDemo.DTO.LoginrequestDto;
import in.strikes.SpringSecurityDemo.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authcontroller {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    private final ResourceLoader resourceLoader;

    public Authcontroller(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/login")
    public LoginreponseDto login(@RequestBody LoginrequestDto loginrequestDto){
        Authentication authenticationRequest= UsernamePasswordAuthenticationToken.unauthenticated(
                loginrequestDto.getUsername(),loginrequestDto.getPassword());

        Authentication authentication=authenticationManager.authenticate(authenticationRequest);
        String token= jwtService.generateToken(authentication);
                return new LoginreponseDto(token);
    }
}
