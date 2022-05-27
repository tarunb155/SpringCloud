
package com.accenture.lkm.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.accenture.lkm.test")
//@SelectClasses
@SuiteDisplayName("Junit Platform Suit demo")
public class JunitTestSuite {

}
