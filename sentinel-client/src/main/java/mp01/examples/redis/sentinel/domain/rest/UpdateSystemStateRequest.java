package mp01.examples.redis.sentinel.domain.rest;

import mp01.examples.redis.sentinel.domain.State;

public class UpdateSystemStateRequest {

    private String systemName;
    private State state;

    public UpdateSystemStateRequest(String systemName, State state) {
        this.systemName = systemName;
        this.state = state;
    }

    public UpdateSystemStateRequest() {
    }

    public String getSystemName() {
        return systemName;
    }

    public State getState() {
        return state;
    }
}
