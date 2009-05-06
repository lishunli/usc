package com.test.TestAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({com.test.JUnit4.TestAll.class})
//测试所有的测试，最好再每个包测试在建一个小的整合测试，再把他们整合起来形成大的整体的测试
public class TestAllTest
{

}
