package org.usc.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * 测试所有的测试
 * 
 * @author ShunLi
 * @Time 2010-1-1
 */
@RunWith(Suite.class)
@SuiteClasses(
{ org.usc.tests.TestIbatis.class })
public class AllTests
{
}
// 测试所有的测试，最好再每个包测试在建一个小的整合测试，再把他们整合起来形成大的整体的测试
