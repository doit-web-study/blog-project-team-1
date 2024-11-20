package doit.blog.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 아이디 중복 검사
    boolean existsByUserLoginId(String userLoginId);
}