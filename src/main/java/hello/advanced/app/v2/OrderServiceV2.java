package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    void orderItem(String itemId, TraceId traceId) {
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId,"service");
            orderRepository.save(status.getTraceId(), itemId);

            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

}
