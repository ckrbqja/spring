package hello.advanced.trace.threadLocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalTest {
    private ThreadLocalService fieldService = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();
//        sleep(2000);
        sleep(100);
        threadB.start();
        sleep(2000);
        log.info("main exit");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
