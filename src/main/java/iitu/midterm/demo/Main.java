package iitu.midterm.demo;

import iitu.midterm.demo.config.AppConfigBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigBean.class);
        Library library = applicationContext.getBean("library", Library.class);
        library.run();
    }
}
