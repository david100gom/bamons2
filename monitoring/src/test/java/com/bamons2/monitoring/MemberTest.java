package com.bamons2.monitoring;

import com.bamons2.monitoring.MonitoringApplication;
import com.bamons2.monitoring.process.member.dao.MemberDAO;
import com.bamons2.monitoring.process.member.domain.Member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * Created by david100gom on 2017. 8. 19.
 *
 * Github : https://github.com/david100gom
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MonitoringApplication.class)
@WebAppConfiguration
public class MemberTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void getMemberTest() {
        Member user = memberDAO.getMember("abc1");

        assertThat("abc1", is(user.getUsername()));
        assertThat("admin", is(user.getName()));
        assertThat("1234", is(user.getPassword()));
    }

    @Test
    public void getAuthorityTest() {
        List<String> authorities = memberDAO.getAuthority("abc1");
        assertThat(authorities, hasItems("ADMIN", "USER"));

        authorities= memberDAO.getAuthority("abc1");
        assertThat(authorities, hasItem("USER"));
    }
}
