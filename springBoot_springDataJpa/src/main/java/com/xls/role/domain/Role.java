package com.xls.role.domain;

import com.xls.menu.domain.Menu;
import com.xls.user.domain.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_code")
    private String roleCode;

    //用户集合一对多 一个角色多个用户
    //mappedBy 多方中对应此实体的对象的名称
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();



    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<Menu> menus = new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", users=" + users +
                ", menus=" + menus +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
