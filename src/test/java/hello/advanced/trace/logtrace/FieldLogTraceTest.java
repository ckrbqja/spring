package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    @Test
    void begind_end_trace2() {
        FieldLogTrace trace = new FieldLogTrace();

        TraceStatus status1 = trace.begin("1");
        TraceStatus status2 = trace.begin("2");

        trace.end(status2);
        trace.end(status1);

    }


    @Test
    void begind_end_exception() {
        FieldLogTrace trace = new FieldLogTrace();

        TraceStatus status1 = trace.begin("1");
        TraceStatus status2 = trace.begin("2");

        trace.exception(status2, new Exception());
        trace.exception(status1, new Exception());

    }


}