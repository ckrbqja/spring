package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class ThreadLocalLogTraceTest {

    ThreadLoaclLogTrace trace = new ThreadLoaclLogTrace();
    @Test
    void begind_end_trace2() {

        TraceStatus status1 = trace.begin("1");
        TraceStatus status2 = trace.begin("2");

        trace.end(status2);
        trace.end(status1);

    }


    @Test
    void begind_end_exception() {

        TraceStatus status1 = trace.begin("1");
        TraceStatus status2 = trace.begin("2");

        trace.exception(status2, new Exception());
        trace.exception(status1, new Exception());

    }


}