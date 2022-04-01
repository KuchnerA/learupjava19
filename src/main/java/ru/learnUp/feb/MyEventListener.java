package ru.learnUp.feb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import java.util.Locale;

import static ru.learnUp.feb.Main.x;

@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent>, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void onApplicationEvent(MyEvent event) {
        Locale locale = Locale.getDefault();

        if (x == event.getNumber()) {
            System.out.println(context.getMessage("victory", new Object[]{x}, locale));

        } else if (event.getNumber() > x) {
            System.out.println(context.getMessage("less", null, locale));
        } else {
            System.out.println(context.getMessage("more", null, locale));
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
