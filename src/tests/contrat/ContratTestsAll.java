package tests.contrat;

import org.junit.runner.RunWith;	
import org.junit.runners.Suite;

import tests.contrat.error.TestContratAllError;
import tests.contrat.normal.TestContratAllNormal;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestContratAllError.class,
	TestContratAllNormal.class,	
})

public class ContratTestsAll {

}
