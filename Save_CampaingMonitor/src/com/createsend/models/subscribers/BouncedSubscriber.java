package com.createsend.models.subscribers;

public class BouncedSubscriber extends Subscriber {
    public String BounceType;
    public String Reason;

    @Override
    public String toString() {
        return String.format("{ Subscriber: %s, BouncedSubscriber: { BounceType: %s, Reason: %s } }", super.toString(), BounceType, Reason);
    }
}
