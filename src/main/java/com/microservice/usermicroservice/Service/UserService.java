package com.microservice.usermicroservice.Service;

import com.microservice.usermicroservice.Entity.User;
import com.microservice.usermicroservice.Repository.UserRepository;
import com.microservice.usermicroservice.ValueObject.ResponseTemplateVO;
import com.microservice.usermicroservice.ValueObject.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Save method of UserService");
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        log.info("Get method of UserService");
        return userRepository.findByUserID(userId);
    }

    public ResponseTemplateVO getTasksbyUserId(Long userId) {
        log.info("Get users with tasks method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserID(userId);

        Todo todo = restTemplate.getForObject("http://localhost:9001/todo/findByUser/" + userId,Todo.class);

        vo.setUser(user);
        vo.setTodo(todo);

        return vo;
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
