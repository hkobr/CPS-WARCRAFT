package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.error.ErrorTestsAll;
import tests.normal.NormalTestsAll;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ErrorTestsAll.class,
	NormalTestsAll.class,	
})

public class TestsAll {

}
