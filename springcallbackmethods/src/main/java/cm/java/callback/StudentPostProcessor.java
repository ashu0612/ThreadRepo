package cm.java.callback;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudentPostProcessor implements BeanPostProcessor{
	//it will create wrapper around the instance and return the 
	//properties when bean gets initialized.
	public Object postProcessBeforeInitialization(Object bean,
            String beanName)
     throws BeansException {
		System.out.println("bean before initialization is :"+beanName);
		return bean;
		
	}
	public Object postProcessAfterInitialization(Object bean,
            String beanName)
     throws BeansException {
		System.out.println("bean after initialization is :"+beanName);
		return bean;
		
	}
	
}
