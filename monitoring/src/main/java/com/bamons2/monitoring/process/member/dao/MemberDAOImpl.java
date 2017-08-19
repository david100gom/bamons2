package com.bamons2.monitoring.process.member.dao;

import com.bamons2.monitoring.process.member.domain.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by david100gom on 2017. 8. 19.
 *
 * Github : https://github.com/david100gom
 */
@Repository
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    @Qualifier("firstSqlSessionTemplate")
    private SqlSession sqlSession;

    /**
     * 계정정보
     *
     * @param username
     * @return
     */
    @Override
    public Member getMember(String username) {
        return sqlSession.selectOne("memberDAO.GET_MEMBER", username);
    }

    /**
     * 권한정보
     *
     * @param username
     * @return
     */
    @Override
    public List<String> getAuthority(String username) {
        return sqlSession.selectList("memberDAO.GET_AUTHORITY", username);
    }
}
