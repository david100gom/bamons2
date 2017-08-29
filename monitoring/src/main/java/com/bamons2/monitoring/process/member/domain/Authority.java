package com.bamons2.monitoring.process.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by david100gom on 2017. 8. 29.
 *
 * Github : https://github.com/david100gom
 */
@Entity
@Table(name="AUTHORITY")
public class Authority {

    @Id
    private int seq;                // PK
    private String username;        // 아이디

    @Column(name="authority_name")
    private String authorityName;   // 권한명

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
