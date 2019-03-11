package mp01.examples.redis.sentinel.service;

import mp01.examples.redis.sentinel.domain.SystemState;
import mp01.examples.redis.sentinel.repository.SystemStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemStateService {

    @Autowired
    private SystemStateRepository systemStateRepository;

    public SystemState createSystemState(SystemState systemState) {
        if (systemStateRepository.findSystemStateBySystemName(systemState.getSystemName()) == null) {
            SystemState resultSystemState = systemStateRepository.save(systemState);
            return resultSystemState;
        } else {
            return null;
        }
    }

    public SystemState updateSystemState(SystemState systemState) {
        SystemState retrievedSystemState = systemStateRepository.findSystemStateBySystemName(systemState.getSystemName());
        if(retrievedSystemState != null) {
            retrievedSystemState.setState(systemState.getState());
            systemStateRepository.save(retrievedSystemState);
            return retrievedSystemState;
        } else {return null;}
    }
}
