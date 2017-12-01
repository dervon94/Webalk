package hu.iit.uni.miskolc.dao;

import hu.iit.uni.miskolc.model.exceptions.InvalidCountryException;
import hu.iit.uni.miskolc.dao.exceptions.RunnerAlreadyExistException;
import hu.iit.uni.miskolc.dao.exceptions.RunnerNotFoundException;
import hu.iit.uni.miskolc.model.Runner;
import hu.iit.uni.miskolc.model.RunnerCountry;

import java.util.Collection;

public interface RunnerDAO {
    Collection <Runner> listRunners();
    Collection <Runner> listRunnersByCountry(RunnerCountry country) throws InvalidCountryException;
    Runner readRunnerById(String idNumber) throws RunnerNotFoundException;
    void registRunner(Runner runner) throws RunnerAlreadyExistException;


}
