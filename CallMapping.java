package model;

public class CallMapping {
    private Segment segment;
    private Reason reason;
    private Service service;

    //convert strings to enum

    public Segment getSegment(String seg) {
        segment = Segment.valueOf(seg);
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Reason getReason(String r) {
        reason = Reason.valueOf(r);
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public Service getService(String ser) {
        service = Service.valueOf(ser);
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "CallMapping{" +
                "segment='" + segment + '\'' +
                ", reason='" + reason + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
