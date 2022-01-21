package com.example.test.controller;

import com.example.test.VO.UserVO;
import com.example.test.entity.User;
import com.example.test.repo.UserRepository;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // JSON 형태 결과값을 반환해줌 (@ResponseBody가 필요없음)
@RequiredArgsConstructor // final 객체를 Constructor Injection 해줌. (Autowired 역할)
@RequestMapping("/v1") // version1의 API
public class UserController {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    //맴버 조회
    @GetMapping("allUser")
    public List<User> getAllUser() {
        logger.info("INFO Level 테스트");

        //return userRepository.findAll();
        return userService.findAll();
    }

    //특정 ID로 맴버 조회
    @GetMapping("getUser/{id}")
    public Optional<User> getUser(@PathVariable("id") long id){
        Optional<User> user = userService.findById(id);
        return user;
    }
    
    //회원 가입
    @PostMapping("registerUser")
    public User registerUser(@RequestBody UserVO userVO) {
        final User user = User.builder()
                .name(userVO.getName())
                .email(userVO.getEmail())
                .build();

        //return userRepository.save(user);
        return userService.save(user);
    }
    
    //회원 번호로 회원 삭제
    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long id)
    {
        userService.deleteById(id);
    }

    //회원 번호의 회원 수정
    @PutMapping("updateUser/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody UserVO userVO)
    {
        final User user = User.builder()
                .name(userVO.getName())
                .email(userVO.getEmail())
                .build();

        userService.updateById(id, user);
        return user;
    }
}
