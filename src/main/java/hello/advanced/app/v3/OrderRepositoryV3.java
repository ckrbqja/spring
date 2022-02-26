package hello.advanced.app.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV3 {
    private final LogTrace trace;

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


        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
