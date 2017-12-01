package hu.iit.uni.miskolc.dao;

import hu.iit.uni.miskolc.dao.exceptions.RunnerAlreadyExistException;
import hu.iit.uni.miskolc.dao.exceptions.RunnerNotFoundException;
import hu.iit.uni.miskolc.model.Runner;
import hu.iit.uni.miskolc.model.RunnerCountry;
import hu.iit.uni.miskolc.model.RunnerDistance;
import hu.iit.uni.miskolc.model.RunnerGender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class RunnerMemoryDAO implements RunnerDAO {
    private static Collection<Runner> db;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

    static {
        try {
            db = new ArrayList<Runner>(Arrays.asList(
                    new Runner("AB123456", "Viz Elek", RunnerCountry.HUNGARY, sdf.parse("10-10-1991"), "Miskolc", RunnerGender.MALE, RunnerDistance.KM10),
                    new Runner("XY864513", "Nagy Árpi", RunnerCountry.AUSTRIA, sdf.parse("10-12-1992"), "Wiena", RunnerGender.MALE, RunnerDistance.KM5),
                    new Runner("XS123456", "Nyomo Réka", RunnerCountry.SLOVAKIA, sdf.parse("2-2-1890"), "Kassa", RunnerGender.FEMALE, RunnerDistance.KM40),
                    new Runner("HJ125689", "Va Gina", RunnerCountry.HUNGARY, sdf.parse("1-1-2001"), "Bugyi", RunnerGender.FEMALE, RunnerDistance.KM10)
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Collection<Runner> listRunners() {
        return new HashSet<Runner>(db);
    }

    @Override
    public Collection<Runner> listRunnersByCountry(RunnerCountry country){
        Collection<Runner> result = new HashSet<Runner>();
        for (Runner runner : db) {
            if (runner.getCountry().equals(country)) {
                result.add(runner);
            }
        }
        return result;
    }

    @Override
    public Runner readRunnerById(String idNumber) throws RunnerNotFoundException {
        for (Runner r :db){
            if(r.getIdNumber().matches(idNumber)){
                return r;
            }
        }
        throw new  RunnerNotFoundException();
    }


    @Override
    public void registRunner(Runner runner) throws RunnerAlreadyExistException {
        for (Runner reg : db) {
            if (reg.getIdNumber().matches(runner.getIdNumber()))
                throw new RunnerAlreadyExistException();
        }

        db.add(runner);

    }
}
