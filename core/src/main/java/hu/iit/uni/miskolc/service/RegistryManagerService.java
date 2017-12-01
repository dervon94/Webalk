package hu.iit.uni.miskolc.service;

import hu.iit.uni.miskolc.model.Runner;
import hu.iit.uni.miskolc.model.RunnerCountry;
import hu.iit.uni.miskolc.model.RunnerDistance;
import hu.iit.uni.miskolc.model.RunnerGender;
import hu.iit.uni.miskolc.model.exceptions.InvalidCountryException;
import hu.iit.uni.miskolc.service.exceptions.ExistingIdNumberException;

import java.util.Collection;
import java.util.Date;

public interface RegistryManagerService {
    /**
     * @return Collection of all Cars
     */
    Collection<Runner> listRunners();

    Collection<Runner> listRunnersByCountry(RunnerCountry country) throws InvalidCountryException;

    Collection<Runner> listRunnersByCountry(String country) throws InvalidCountryException;

   // Runner searchRunnerById(String Id) throws  RunnerNotFoundException;

    void registRunner(Runner runner) throws ExistingIdNumberException;

    void registRunner(String idNumber, String name, RunnerCountry country, Date birthDate, String birthCity, RunnerGender gender, RunnerDistance distance, Date regdate) throws ExistingIdNumberException;

}
