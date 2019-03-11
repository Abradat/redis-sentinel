package mp01.examples.redis.sentinel.domain.rest;

import mp01.examples.redis.sentinel.domain.State;
import mp01.examples.redis.sentinel.domain.SystemState;

public class CreateSystemStateRequest {

    private String systemName;
    private State state;

    public CreateSystemStateRequest(String systemName, State state) {
        this.systemName = systemName;
        this.state = state;
    }

    public CreateSystemStateRequest() {
    }

    public String getSystemName() {
        return systemName;
    }

    public State getState() {
        return state;
    }
}
