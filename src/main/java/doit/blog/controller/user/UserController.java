package doit.blog.controller.user;

import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.controller.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import doit.blog.controller.user.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements UserControllerDocs {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/validate")
    public void checkDuplicateId(@RequestParam String id) {
        if(userService.checkDuplicateId(id)){
            ResponseEntity.status(400).body("이미 존재하는 아이디입니다.");
            System.out.println("duplicate");
        }
        else {
            ResponseEntity.status(200).body("사용할 수 있는 아이디입니다.");
            System.out.println("success");
        }
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        userService.save(userSignUpRequest.toEntity());
        System.out.println(userRepository.findByUserLoginId(userSignUpRequest.userLoginId()));
    }

    @PostMapping("/login")
    public UserIdResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return null;
    }

    @GetMapping("/{userId}")
    public UserInfoResponse getUserInfo(@PathVariable Long userId) {
        return null;
    }
}
