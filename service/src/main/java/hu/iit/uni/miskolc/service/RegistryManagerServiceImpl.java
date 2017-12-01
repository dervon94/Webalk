package hu.iit.uni.miskolc.service;

import hu.iit.uni.miskolc.dao.RunnerDAO;
import hu.iit.uni.miskolc.dao.exceptions.RunnerAlreadyExistException;
import hu.iit.uni.miskolc.dao.exceptions.RunnerNotFoundException;
import hu.iit.uni.miskolc.model.Runner;
import hu.iit.uni.miskolc.model.RunnerCountry;
import hu.iit.uni.miskolc.model.RunnerDistance;
import hu.iit.uni.miskolc.model.RunnerGender;
import hu.iit.uni.miskolc.model.exceptions.InvalidCountryException;
import hu.iit.uni.miskolc.service.exceptions.ExistingIdNumberException;

import java.util.Collection;
import java.util.Date;

public class RegistryManagerServiceImpl implements RegistryManagerService {
    private RunnerDAO runnerDAO;

    public RegistryManagerServiceImpl(RunnerDAO runnerDAO) {
        this.runnerDAO = runnerDAO;
    }

    public Collection<Runner> listRunners() {
        return runnerDAO.listRunners();
    }

    public Collection<Runner> listRunnersByCountry(RunnerCountry country) throws InvalidCountryException {
        return runnerDAO.listRunnersByCountry(country);
    }

    public Collection<Runner> listRunnersByCountry(String country) throws InvalidCountryException {
        try {
            RunnerCountry r = RunnerCountry.valueOf(country);
        }catch (IllegalArgumentException e){
            throw new InvalidCountryException(e);
        }

        return runnerDAO.listRunnersByCountry(RunnerCountry.valueOf(country));
    }

    public Runner searchRunnerById(String id) throws RunnerNotFoundException {

        return  runnerDAO.readRunnerById(id);
    }

    public void registRunner(Runner runner) throws ExistingIdNumberException {
        try {
            runnerDAO.registRunner(runner);
        } catch (RunnerAlreadyExistException e) {
            throw new ExistingIdNumberException(e);
        }
    }

    public void registRunner(String name, String idNumber, RunnerCountry country, Date birthDate, String birthCity, RunnerGender gender, RunnerDistance distance, Date regdate) throws ExistingIdNumberException {

        Runner runner = new Runner(idNumber, name, country, birthDate, birthCity, gender, distance);
        try {
            runnerDAO.registRunner(runner);
        } catch (RunnerAlreadyExistException e) {
            throw new ExistingIdNumberException(e);
        }

    }
}
