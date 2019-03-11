package mp01.examples.redis.sentinel.domain.rest;

import mp01.examples.redis.sentinel.domain.State;

public class SystemStateResponse {

    private String systemName;
    private State state;

    public SystemStateResponse(String systemName, State state) {
        this.systemName = systemName;
        this.state = state;
    }

    public SystemStateResponse() {
    }

    public String getSystemName() {
        return systemName;
    }

    public State getState() {
        return state;
    }
}
