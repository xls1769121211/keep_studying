package com.xls.menu.domain;

import com.xls.role.domain.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_menu")
public class Menu{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "pid")
    private Integer pid;

    // @JoinTable 多对多关联的中间表
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_role_menu",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns=@JoinColumn(name="menu_id"))
    private Set<Role> roles = new HashSet<Role>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
