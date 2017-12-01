package hu.iit.uni.miskolc;

import hu.iit.uni.miskolc.model.Runner;
import hu.iit.uni.miskolc.model.exceptions.InvalidCountryException;
import hu.iit.uni.miskolc.model.exceptions.InvalidDistanceException;
import hu.iit.uni.miskolc.model.exceptions.InvalidGenderException;
import hu.iit.uni.miskolc.service.RegistryManagerService;
import hu.iit.uni.miskolc.service.exceptions.ExistingIdNumberException;
import hu.uni.miskolc.iit.registry.controller.dto.RunnerRegistrationRequest;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingPlateNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/runner")
public class RegistryController {
    private RegistryManagerService registryManager;

    public RegistryController(RegistryManagerService registryManager) {
        this.registryManager = registryManager;
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Runner> listAllRunners() {
        return registryManager.listRunners();
    }

    @RequestMapping(value = {"/{country}"}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Runner> listAllRunnerfromCountry(@PathVariable(value = "country") String c) throws InvalidCountryException {
        return registryManager.listRunnersByCountry(c);
    }

    @RequestMapping(value = {"/register"}, method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void register(@RequestBody RunnerRegistrationRequest registrationRequest) throws ExistingIdNumberException, InvalidGenderException, InvalidCountryException, InvalidDistanceException {
        System.out.println(registrationRequest.toString());
        Runner runner = new Runner(registrationRequest.getIdNumber(), registrationRequest.getName(), registrationRequest.getHomeCountry(),
                registrationRequest.getBirthDate(), registrationRequest.getBirthCity(), registrationRequest.getGender(), registrationRequest.getDistance());
        registryManager.registRunner(runner);
    }
    @ExceptionHandler(value = {ExistingIdNumberException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public String existingIdNoExHandler(Exception ex){
        return "Id number is exist      "+ex.getMessage();
    }

    @ExceptionHandler(value = {InvalidCountryException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String InvalidCountryExHandler(Exception ex){
        return "Invalid Country     "+ex.getMessage();
    }

    @ExceptionHandler(value = {InvalidGenderException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String InvalidGenderExHandler(Exception ex){
        return "Invalid Gender (MALE,FEMALE)!       "+ex.getMessage();
    }

    @ExceptionHandler(value = {InvalidDistanceException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String InvalidDistanceExHandler(Exception ex){
        return "Invalid distance        "+ex.getMessage();
    }



}

