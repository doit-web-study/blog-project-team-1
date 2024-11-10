package doit.blog.controller.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import doit.blog.controller.user.repository.User;
import doit.blog.controller.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    public boolean checkDuplicateId(String id){
        List<User> findUsers= userRepository.findByUserLoginId(id);
        return !findUsers.isEmpty();
    }
    public void save(User user){
        userRepository.save(user);
    }

}
