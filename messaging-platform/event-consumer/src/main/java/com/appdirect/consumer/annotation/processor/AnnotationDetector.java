package com.appdirect.consumer.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class AnnotationDetector {

	public static List<Class<?>> detect(Class<? extends Object> classObject) {

		Annotation[] annotations = classObject.getAnnotations();
		List<Class<?>> annotationsList = new ArrayList<Class<?>>();

		for (Annotation annotation : annotations) {
			annotationsList.add(annotation.annotationType());
		}
		return annotationsList;
	}
}