package ru.learnUp.feb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class Main implements ApplicationContextAware {

    private ApplicationContext context;
    public static int x = (int) (Math.random() * 1000);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        Locale locale = Locale.getDefault();
        System.out.println(context.getMessage("hello", null, locale));
        System.out.println(context.getMessage("attempts", null, locale));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int inputNumber = scanner.nextInt();
            publisher.publishEvent(inputNumber);
            if (inputNumber == x) {
                break;
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
