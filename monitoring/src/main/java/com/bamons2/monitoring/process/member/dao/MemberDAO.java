package com.bamons2.monitoring.process.member.dao;

import com.bamons2.monitoring.process.member.domain.Member;

import java.util.List;

/**
 * Created by david100gom on 2017. 8. 19.
 *
 * Github : https://github.com/david100gom
 */
public interface MemberDAO {

    // 계정정보
    public Member getMember(String username);

    // 권한정보
    public List<String> getAuthority(String username);


}
