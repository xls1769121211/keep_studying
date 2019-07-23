package com.xls.user.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/***
 * 用户实体类
 *
 * SpringBoot中使用了Hibernate-validate校验框架
 * 使用方式
 * 在实体类字段加上相应校验注解 例如
     * @NotBlank: 判断字符串是否为null或者是空串(去掉首尾空格)。
     * @NotEmpty: 判断字符串是否null或者是空串。
     * @Length: 判断字符的长度(最大或者最小)
     * @Min: 判断数值最小值
     * @Max: 判断数值最大值
     * @Email: 判断邮箱是否合法
 * 在controller层中 参数列表加上@Valid 注解标识启用注解来校验
 *      校验的结果存在一个类里面 BindingResult:封装了校验的结果 其中返回到前台可以看做是个map
 *      key是存在modelAndView中的key value默认对用实体类中的字段名称
 *      key 按照驼峰命名法则默认是实体类对应的小写key，也可以自定义
 *      自定义key值可以使用注解@ModelAttribute("aa")，对应的页面中的key也得改变
 */
public class User {
    @NotBlank(message = "用户名不能为空")
    private String userName;

    private String password;

    @Range(max = 11,min = 2,message = "最大11，最小2")
    private Integer age;

    @Email(message = "email....",regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
