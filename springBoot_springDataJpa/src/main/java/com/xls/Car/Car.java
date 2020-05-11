package com.xls.Car;

import javax.persistence.*;

/**
 * @Entity 实体
 * @Table 对应数据库的表名
 */
@Entity
@Table(name = "t_car")
public class Car{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "city")
    private String city;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                ", city='" + city + '\'' +
                '}';
    }
}
