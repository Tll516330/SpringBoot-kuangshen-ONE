package cn.tll.dao;

import cn.tll.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tll
 * @create 2020/7/12 14:34
 * 部门Dao  交给Spring托管
 */
@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    //静态代码块
    static {
        departments = new HashMap<>();
        departments.put(101,new Department(101,"教研部"));
        departments.put(102,new Department(102,"人事部"));
        departments.put(103,new Department(103,"教学部"));
        departments.put(104,new Department(104,"招生部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    /**
     * 获取所有部门信息
     * @return
     */
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    /**
     * 通过id 查询部门
     * @param id
     * @return
     */
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
