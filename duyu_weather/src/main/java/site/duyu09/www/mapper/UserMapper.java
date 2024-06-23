package site.duyu09.www.mapper;

import site.duyu09.www.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE phoneNum = #{phoneNum}")
    User findByPhoneNum(String phoneNum);

    @Select("INSERT into user (phoneNum, password) " + "VALUES (#{phoneNum}, #{password})")
    void registerUser(User newUser);

    @Select("UPDATE user SET password = #{password} WHERE phoneNum = #{phoneNum}")
    void updatePassword(User user);
}

