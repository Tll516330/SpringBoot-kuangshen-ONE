package cn.tll.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author tll
 * @create 2020/7/12 11:12
 * 员工表
 */
@Data
@NoArgsConstructor
public class Employee {
    /**
     * 员工id
     */
    private Integer id;
    /**
     * 员工姓名
     */
    private String lastName;
    /**
     *员工邮箱
     */
    private String email;
    /**
     * 性别 0：女 1：男
     */
    private Integer gender;
    /**
     * 部门
     */
    private Department department;
    /**
     * 出生日期
     */
    private Date birthday;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birthday = new Date();
    }
}
