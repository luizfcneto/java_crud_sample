package org.sample.crud.demo.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	org.sample.crud.demo.tests.PessoaTests.class,
	org.sample.crud.demo.tests.TarefaTests.class
})
public class AllTests {

}
