package mp01.examples.redis.sentinel.controller;


import mp01.examples.redis.sentinel.domain.SystemState;
import mp01.examples.redis.sentinel.domain.rest.CreateSystemStateRequest;
import mp01.examples.redis.sentinel.domain.rest.SystemStateResponse;
import mp01.examples.redis.sentinel.domain.rest.UpdateSystemStateRequest;
import mp01.examples.redis.sentinel.repository.SystemStateRepository;
import mp01.examples.redis.sentinel.service.SystemStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/state")
public class SystemStateController {

    @Autowired
    private SystemStateService systemStateService;

    @Autowired
    private SystemStateRepository systemStateRepository;

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSystemState(@RequestBody UpdateSystemStateRequest updateSystemStateRequest) {
        SystemState systemState = new SystemState(updateSystemStateRequest.getSystemName(), updateSystemStateRequest.getState());
        SystemState resultSystemState = systemStateService.updateSystemState(systemState);
        if(resultSystemState != null) { return new ResponseEntity<>(HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createSystemState(@RequestBody CreateSystemStateRequest createSystemStateRequest) {
        SystemState systemState = new SystemState(createSystemStateRequest.getSystemName(), createSystemStateRequest.getState());
        SystemState resultSystemState = systemStateService.createSystemState(systemState);
        if(resultSystemState != null) {return new ResponseEntity<>(HttpStatus.CREATED);}
        else {return new ResponseEntity<>(HttpStatus.CONFLICT);}
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{systemName}")
    public ResponseEntity<SystemStateResponse> retrieveSystemState(@PathVariable("systemName") String systemName) {
        SystemState systemState = systemStateRepository.findSystemStateBySystemName(systemName);
        if(systemState != null) {
            SystemStateResponse systemStateResponse = new SystemStateResponse(systemState.getSystemName(), systemState.getState());
            return new ResponseEntity<>(systemStateResponse, HttpStatus.OK);
        } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }


}
