package cn.caofanqi.study.studyspringdatajpa.pojo.domain;

import cn.caofanqi.study.studyspringdatajpa.pojo.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 用户表
 * @author caofanqi
 */
@Data
@Entity
@Builder
@Table(name = "jpa_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(columnDefinition = "INT(3) UNSIGNED")
    private int age;

    private LocalDate birthday;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

}
