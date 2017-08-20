package com.bamons2.monitoring.process.member.service;

import com.bamons2.monitoring.process.member.dao.MemberDAO;
import com.bamons2.monitoring.process.member.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by david100gom on 2017. 8. 20.
 *
 * Github : https://github.com/david100gom
 */
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDAO memberDAO;

    /**
     *
     * 권한 정보 매핑
     *
     * @param username
     * @return
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities(String username) {

        List<String> list = memberDAO.getAuthority(username);
        List<GrantedAuthority> gaList = new ArrayList<>();

        for(String str : list) {
            gaList.add(new SimpleGrantedAuthority(str));
        }

        return gaList;
    }

    /**
     *
     * 권한 체크
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberDAO.getMember(username);

        if(member == null) throw new UsernameNotFoundException("No Data");

//        Collection<GrantedAuthority> gaList = getAuthorities(username);
//
//        for(GrantedAuthority g: gaList) {
//            System.out.println(g.getAuthority().toString());
//        }

        member.setAuthorities(getAuthorities(username));
        return member;
    }
}
