package com.bamons2.monitoring.config;

import com.bamons2.monitoring.process.member.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by david100gom on 2017. 8. 17.
 *
 * Github : https://github.com/david100gom
 *
 * TODO DB 연동 커스텀 인증 필요
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberService memberService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 인증 필요 URL
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").hasAuthority("USER")
                .antMatchers("/admin/member").hasAuthority("ADMIN1")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated();

        // 로그인화면
        http.formLogin().loginProcessingUrl("/login");

        // 로그아웃 + 로그아웃후 포워딩 URL
        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");

    }

    /**
     * 커스텀 인증
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService);
    }

    // 테스트용 인증 설정
    //@Autowired
    //public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.inMemoryAuthentication().withUser("admin").password("1111").roles("USER");
    //}

}