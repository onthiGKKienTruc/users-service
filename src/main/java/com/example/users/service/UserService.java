package com.example.users.service;

import com.example.users.VO.Order;
import com.example.users.VO.ResponseTemplateVO;
import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public ResponseTemplateVO getUserWithOrder(Long userId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();
        vo.setUser(user);
        Order order =restTemplate.getForObject("http://localhost:9001/orders/"+user.getOrderId(),Order.class);
        vo.setOrder(order);
        return vo;
    }

}
