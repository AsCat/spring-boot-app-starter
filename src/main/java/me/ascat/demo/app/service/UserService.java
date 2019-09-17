package me.ascat.demo.app.service;

import me.ascat.demo.app.bean.User;
import me.ascat.demo.app.dao.UserDao;
import me.ascat.demo.app.dao.UserRepository;
import me.ascat.demo.app.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wengyanghui@gmail.com
 * Hibernate和Mybatis混合使用主要是用以演示
 * 用户可根据实际情况自行选择其中一种ORM框架
 * 也可以混合使用例如在复杂查询时使用Mybatis Mapper编写sql等
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepo;

    /**
     * 根据名字查找所有符合用户 使用Mybatis查询
     */
    public List<User> selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    /**
     * 根据id 查询唯一确定用户 使用Hibernate查询
     */
    public User selectUserById(Long id) {
        return userRepo.findById(id).get();
    }

    /**
     * 查找所有用户 使用Mybatis查询
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 插入一个用户 使用Hibernate创建
     * 如果传入的对象为空，则创建一个随机用户
     */
    public void insertService(User user) {
        // using Hibernate to create user
        if (user == null) {
            user = new User();
            user.setName(RandomUtil.getRandName());
            user.setAge(RandomUtil.getRandAge(20, 40));
            user.setMoney(0);
        }
        userRepo.save(user);
    }

    /**
     * 根据id 删除用户 使用Mybatis删除
     */
    public void deleteUserById(Long id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务，由于加上了 @Transactional注解
     * 如果转账中途出了意外 计划修改的数据都不会改变
     * 使用Hibernate查询Mybatis更新
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateUserById(Long id) {
        User findUser = userRepo.getOne(id);
        if (findUser != null) {
            userDao.updateUser(findUser.getName(), findUser.getAge(), findUser.getMoney() + 1000, id);
            // 模拟转账过程中可能遇到的意外状况
            int temp = 1 / 0;
            userDao.updateUser(findUser.getName(), findUser.getAge() + 1, findUser.getMoney(), id);
        }
    }

}
