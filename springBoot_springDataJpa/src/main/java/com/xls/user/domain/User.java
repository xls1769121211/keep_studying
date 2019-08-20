package com.xls.user.domain;

import com.xls.role.domain.Role;

import javax.persistence.*;

/**
 * 用户实体
 * @Entity 实体
 * @Table 对应数据库的表名
 */
@Entity
@Table(name = "t_user")
public class User{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name",nullable = false)
    private String  userName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city")
    private String city;

    //@JoinColumn维护外键关系
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
