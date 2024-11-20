package doit.blog.service.user;

import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.domain.user.User;
import doit.blog.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public void validateLoginId(String userLoginId) {
        if (userRepository.existsByUserLoginId(userLoginId)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    @Transactional
    public void signUp(UserSignUpRequest request) {
        // 아이디 중복 검사
        validateLoginId(request.userLoginId());

        // 회원 가입 처리
        User user = User.builder()
                .userLoginId(request.userLoginId())
                .userPassword(request.userPassword())
                .userName(request.userName())
                .userNickname(request.userNickname())
                .build();

        userRepository.save(user);
    }
}