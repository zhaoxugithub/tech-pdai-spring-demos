package tech.pdai.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tech.pdai.springframework.aspect.LogAspect;
import tech.pdai.springframework.dao.UserDaoImpl;
import tech.pdai.springframework.service.UserServiceImpl;

/**
 * @author pdai
 */
/*
    开启切面的必要条件：@Aspect, @Bean @EnableAspectJAutoProxy
    切点：连接点的集合
    切面：切点(在哪里)+通知(做什么)

 */
@EnableAspectJAutoProxy
@Configuration
public class BeansConfig {

    /**
     * @return user dao
     */
    @Bean("userDao")
    public UserDaoImpl userDao() {
        return new UserDaoImpl();
    }

    /**
     * @return user service
     */
    @Bean("userService")
    public UserServiceImpl userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao());
        return userService;
    }

    /**
     * @return log aspect
     */
    @Bean("logAspect")
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
