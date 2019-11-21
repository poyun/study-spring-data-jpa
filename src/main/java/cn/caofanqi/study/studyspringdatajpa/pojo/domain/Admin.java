package cn.caofanqi.study.studyspringdatajpa.pojo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * admin实体
 *
 * @author caofanqi
 */
@Data
@Entity
@Builder
@Table(name = "jpa_admin")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private LocalDate createTime;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;






}
