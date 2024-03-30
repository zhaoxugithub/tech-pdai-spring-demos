package tech.pdai.springframework.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*
BeanPostProcessor是Spring框架中的一个接口，它提供了在Bean实例化和依赖注入过程中对Bean进行后置处理的能力。
实现了BeanPostProcessor接口的类可以在Bean的初始化前后对其进行自定义操作。

 */
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

  // bean初始化之前执行
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    log.info("execute BeanPostProcessor#postProcessBeforeInitialization for {}", beanName);
    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  // bean初始化之后执行
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("execute BeanPostProcessor#postProcessAfterInitialization for {}", beanName);
    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
  }
}
