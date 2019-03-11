package mp01.examples.redis.sentinel.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("SystemState")
public class SystemState implements Serializable {

    @Id
    private String id;

    @Indexed
    private String systemName;

    @Indexed
    private State state;

    public SystemState(String systemName, State state) {
        this.systemName = systemName;
        this.state = state;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SystemState{" +
                "id='" + id + '\'' +
                ", systemName='" + systemName + '\'' +
                ", state=" + state +
                '}';
    }
}
