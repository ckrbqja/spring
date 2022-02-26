package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV0 {

    void save(String itemId) {
        //저장로직
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외");
        }

        sleep(100);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
