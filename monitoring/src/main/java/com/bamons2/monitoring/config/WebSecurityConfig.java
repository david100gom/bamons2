package com.bamons2.monitoring.config;

import com.bamons2.monitoring.process.member.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by david100gom on 2017. 8. 17.
 *
 * Github : https://github.com/david100gom
 *
 * TODO DB 연동 커스텀 인증 필요
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberService memberService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.html");
    }

    // 일반 폼 인증
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        // 인증 필요 URL
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user/**").hasAuthority("USER")
//                .antMatchers("/admin/member").hasAuthority("ADMIN1")
//                .antMatchers("/admin/**").hasAuthority("ADMIN")
//                .anyRequest().authenticated();
//
//        // 로그인화면
//        http.formLogin().loginProcessingUrl("/login");

        // 모두 차단
        // 커스텀 로그인화면
        // TODO http://websystique.com/spring-security/spring-security-4-custom-login-form-annotation-example/
        http.authorizeRequests()
                .antMatchers("/member/login").permitAll()
                .antMatchers("/user/**").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/").authenticated()
                .and().formLogin().loginPage("/member/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/accessDeny");


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