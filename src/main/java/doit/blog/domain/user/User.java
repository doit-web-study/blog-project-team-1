package doit.blog.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userLoginId;
    private String userPassword;
    private String userName;
    private String userNickname;

    @Builder
    public User(String userLoginId, String userPassword, String userName,
                String userNickname) {
        this.userLoginId = userLoginId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
    }
}