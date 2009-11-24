package cn.itcast.web.action.privilege;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Ȩ������
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
	/* ģ���� */
	String model();
	/* Ȩ��ֵ */
	String privilegeValue();
}
