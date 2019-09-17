package me.ascat.demo.app.dao;

import me.ascat.demo.app.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wengyanghui@gmail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
