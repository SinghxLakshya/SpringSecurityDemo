package in.strikes.SpringSecurityDemo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginreponseDto {
    private String acessToken;

    public LoginreponseDto(String acessToken) {
        this.acessToken = acessToken;
    }
}
