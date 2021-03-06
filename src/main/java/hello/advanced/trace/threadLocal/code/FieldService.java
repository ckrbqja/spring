package hello.advanced.trace.threadLocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    private String nameStore;

    public String logic(String name){
        log.info("์ ์ฅ name={} -> namestore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("์กฐํ namestore={}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
