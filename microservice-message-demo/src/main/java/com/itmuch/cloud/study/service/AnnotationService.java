package com.itmuch.cloud.study.service;

import com.itmuch.cloud.study.annotation.WanghAnnotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AnnotationService {


	@WanghAnnotation(name = "wangh", value = "new test")
	public void say() {
		System.out.println("i am say method");
	}

	public static void main(String[] args) {
		AnnotationService.trackUseCases(AnnotationService.class);

	}

	public static void trackUseCases( Class<?> cl) {
		for (Method m : cl.getDeclaredMethods()) {
			WanghAnnotation uc = m.getAnnotation(WanghAnnotation.class);
			if (uc != null) {
				System.out.println("Found Use Case:" + uc.name() + " "
					+ uc.value());
			}
		}

	}

}
