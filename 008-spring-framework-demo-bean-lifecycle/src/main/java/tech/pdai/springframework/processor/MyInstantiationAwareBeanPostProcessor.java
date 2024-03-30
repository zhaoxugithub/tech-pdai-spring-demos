package tech.pdai.springframework.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/*



InstantiationAwareBeanPostProcessor是Spring框架中的一个特殊类型的BeanPostProcessor接口。它提供了在Bean实例化过程中对Bean进行自定义处理的能力。
与普通的BeanPostProcessor接口不同，InstantiationAwareBeanPostProcessor在Bean实例化的不同阶段提供了更细粒度的控制。
通过实现InstantiationAwareBeanPostProcessor接口，我们可以在Spring容器对Bean进行实例化的不同阶段，对Bean进行更灵活和细粒度的自定义处理。它提供了更多的控制能力，让我们能够在Bean实例化过程中进行更高级的操作。
 */
@Slf4j
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("execute InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation for {}", beanName);
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("execute InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation for {}", beanName);
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        log.info("execute InstantiationAwareBeanPostProcessor#postProcessProperties for {}", beanName);
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
