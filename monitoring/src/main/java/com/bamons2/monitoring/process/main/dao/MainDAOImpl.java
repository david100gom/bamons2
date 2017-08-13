package com.bamons2.monitoring.process.main.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by david100gom on 2017. 8. 14.
 *
 * Github : https://github.com/david100gom
 */
@Repository
public class MainDAOImpl implements MainDAO{

    @Autowired
    @Qualifier("firstSqlSessionTemplate")
    private SqlSession sqlSession;

    @Override
    public String today() {
        return sqlSession.selectOne("mainDAO.GET_NOW");
    }
}
