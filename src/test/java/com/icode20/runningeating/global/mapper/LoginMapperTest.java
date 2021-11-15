package com.icode20.runningeating.global.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class LoginMapperTest {
    @Autowired
    GlobalMapper loginMapper;

    @Test
    public void testFindUserByName() {
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        System.out.println(loginMapper.findUserByName("admin"));
    }

}