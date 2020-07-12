package cn.tll.dao;

import cn.tll.pojo.Department;
import cn.tll.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tll
 * @create 2020/7/12 14:53
 * 员工Dao
 * 交给Spring托管
 */
@Repository
public class EmployeeDao {

    /**
     * 注入Department
     */
    @Autowired
    private DepartmentDao departmentDao;
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //初始化员工数据 static优先加载  静态块调用不了变量
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","2289091393@qq.com",1,new Department(101,"教研部")));
        employees.put(1002,new Employee(1002,"BB","2289091393@qq.com",0,new Department(102,"人事部")));
        employees.put(1003,new Employee(1003,"CC","2289091393@qq.com",1,new Department(103,"教学部")));
        employees.put(1004,new Employee(1004,"DD","2289091393@qq.com",0,new Department(104,"招生部")));
        employees.put(1005,new Employee(1005,"EE","2289091393@qq.com",1,new Department(105,"后勤部")));
    }

    //模拟主键自增
    private static Integer initId = 1006;

    /**
     * 增加一个员工
     */
    public void  addEmployee(Employee employee){
        //判断员工是否有id
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        //员工添加部门详细信息
        //因为前端传来只有部门的id   需要通过id再给Department赋值
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        //保存员工
        employees.put(employee.getId(),employee);
    }

    /**
     * 获取全部员工信息
     * @return
     */
    public Collection<Employee> getEmploees(){
        return employees.values();
    }

    /**
     * 通过id查询员工
     * @param id
     * @return
     */
    public Employee getEmploeeById(Integer id){
        return employees.get(id);
    }

    /**
     * 通过id删除员工
     * @param id
     */
    public void  deletEmploeeById(Integer id){
        employees.remove(id);
    }

}
