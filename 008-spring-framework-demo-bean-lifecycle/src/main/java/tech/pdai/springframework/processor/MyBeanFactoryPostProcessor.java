package tech.pdai.springframework.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author pdai
 * <p>
 * BeanFactoryPostProcessor是Spring框架中的一个接口， 它允许我们在Spring容器实例化和配置Bean之前，对Bean的定义进行修改和处理。
 * 在Spring的Bean生命周期中，BeanFactoryPostProcessor是在BeanFactory标准初始化之后、任何Bean被实例化之前执行的。
 * 它可以对应用上下文中的Bean定义进行修改，例如添加、删除或修改Bean的属性。
 */
@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  /*
ConfigurableListableBeanFactory是Spring框架中的一个接口，它是BeanFactory的子接口之一，提供了对BeanFactory的扩展功能。
ConfigurableListableBeanFactory在BeanFactory的基础上增加了对Bean定义的管理和访问能力。
ConfigurableListableBeanFactory接口继承了ListableBeanFactory和ConfigurableBeanFactory接口，它定义了一系列方法来获取和管理Bean定义，包括以下几个主要方法：
getBeanDefinition(String beanName)：根据bean的名称获取对应的BeanDefinition对象，用于获取Bean的配置信息。
getBeanDefinitionNames()：获取所有Bean定义的名称，用于遍历和检索Bean定义的信息。
getBeanDefinitionCount()：获取Bean定义的数量。
registerBeanDefinition(String beanName, BeanDefinition beanDefinition)：向容器注册一个新的Bean定义。
removeBeanDefinition(String beanName)：从容器中移除指定名称的Bean定义。
preInstantiateSingletons()：预实例化所有的单例Bean，确保在容器启动时，所有的单例Bean都已经被实例化。
   */

  /*
      它在Spring容器实例化和配置Bean之后，在任何Bean被实例化之前执行,可以对Bean定义进行修改和处理,只会执行一次
   */
  @Override
  public void postProcessBeanFactory(
      ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    // 在这里可以对Bean定义进行修改和处理
    // 例如，可以添加新的Bean定义、修改已有Bean的属性等
    log.info("execute BeanFactoryPostProcessor#postProcessBeanFactory");
    log.info("BeanDefinition count: {}", configurableListableBeanFactory.getBeanDefinitionCount());
    log.info("BeanDefinition names: {}",
        (Object) configurableListableBeanFactory.getBeanDefinitionNames());
  }
}
