package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {
    private final HelloTraceV2 trace;

    void save(TraceId traceId, String itemId) {
        //저장로직
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId,"repository");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외");
            }

            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }


        sleep(10);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
