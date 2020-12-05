package org.cz;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class User {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        System.out.println(beanInfo.getAdditionalBeanInfo());
        System.out.println(beanInfo.getPropertyDescriptors());
        System.out.println(beanInfo.getEventSetDescriptors());

        Annotation[] annotations = User.class.getAnnotations();
        Method[] methods = User.class.getMethods();
        Field[] fields = User.class.getFields();
        System.out.println(annotations);
        System.out.println(methods);
        System.out.println(fields);

        User user = new User();
        Component annotation = user.getClass().getAnnotation(Component.class);
        annotation.value();

    }
}
