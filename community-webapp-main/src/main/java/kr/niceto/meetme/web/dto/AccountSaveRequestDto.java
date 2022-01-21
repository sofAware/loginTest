package kr.niceto.meetme.web.dto;

import kr.niceto.meetme.domain.accounts.Account;
import kr.niceto.meetme.domain.accounts.AccountRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AccountSaveRequestDto {
    private String username;
    private String password;
    private String email;
    private AccountRole role;

    @Builder
    public AccountSaveRequestDto(String username, String password, String email, AccountRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Account toEntity() {
        return Account.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(role).build();
    }
}
