package com.load.testing;

import org.jetbrains.annotations.NotNull;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CglibProxyTest {

	public static void main(String[] args) {
		// sipleProxyMethod();
		methodInterceptProxy();
	}

	private static void methodInterceptProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersonService.class);
		enhancer.setCallback(getMethodInterceptor());
		PersonService proxy = (PersonService) enhancer.create();
		System.out.println(proxy.getName(null, null));
		System.out.println(proxy.getName("Biran", "Syangbo"));
		System.out.println(proxy.age(LocalDate.now().minusYears(10)));
	}

	@NotNull
	private static MethodInterceptor getMethodInterceptor() {
		return (obj, method, args, proxy) -> proxy.invokeSuper(obj, args);
	}

	private static void simpleProxyMethod() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersonService.class);
		enhancer.setCallback(getCallback());
		PersonService proxy = (PersonService) enhancer.create();
		String name = proxy.getName(null, null);
		System.out.println("Name: [" + name + "]");
	}

	private static FixedValue getCallback() {
		return () -> "Biran Syangbo";
	}

}

class PersonService {

	public String getName(String firstName, String lastName) {
		return firstName + "  " + lastName;
	}

	public int age(LocalDate dateOfBirth) {
		return (int) ChronoUnit.DAYS.between(LocalDate.now(), dateOfBirth);
	}

}
