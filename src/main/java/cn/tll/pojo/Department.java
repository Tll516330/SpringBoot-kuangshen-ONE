package cn.tll.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tll
 * @create 2020/7/12 11:10
 * 部门实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
     * 部门id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String departmentName;
}
