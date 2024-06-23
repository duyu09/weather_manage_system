package site.duyu09.www.service;

import site.duyu09.www.entity.User;
import site.duyu09.www.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean checkPassword(String phoneNum, String password){
        User user = userMapper.findByPhoneNum(phoneNum);
        if (user != null) {
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            return user.getPassword().equals(md5Password);
        }
        return false;
    }

    public boolean login(String phoneNum, String password) {
        return checkPassword(phoneNum, password);
    }

    public boolean register(String phoneNum, String password) {
         // 检查手机号是否已注册
        if (userMapper.findByPhoneNum(phoneNum) != null) {
            return false;
        }
        // 创建新用户
        User newUser = new User();
        newUser.setPhoneNum(phoneNum);
        newUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userMapper.registerUser(newUser);
        return true;
    }

    public boolean updatePassword(String phoneNum, String newPassword) {
        User user = new User();
        user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
        user.setPhoneNum(phoneNum);
        userMapper.updatePassword(user);
        return true;
    }
}

