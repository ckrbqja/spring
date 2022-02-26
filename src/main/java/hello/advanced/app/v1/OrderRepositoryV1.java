package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV1 {
    private final HelloTraceV1 trace;

    void save(String itemId) {
        //저장로직
        TraceStatus status = null;

        try {
            status = trace.begin("repository");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외");
            }

            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
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
