package com.test.TestAllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({com.test.junit3.TestAll.class,com.test.junit4.TestAll.class,com.test.dao.TestAll.class})
//�������еĲ��ԣ������ÿ���������ڽ�һ��С�����ϲ��ԣ��ٰ��������������γɴ������Ĳ���
public class TestAllTest
{

}
