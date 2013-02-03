package com.biswa.ep.entities.dyna;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import com.biswa.ep.entities.Attribute;

public class ConcreteAttributeProvider implements DynamicAttributeProvider {
	private ServiceLoader<DynamicAttributeProvider> loader;
	public ConcreteAttributeProvider(){
		loader = ServiceLoader.load(DynamicAttributeProvider.class);
	}
	
	@Override
	public Attribute getAttribute(String expression) {
        try {
            Iterator<DynamicAttributeProvider> dynamicAttributeProvider = loader.iterator();
            while (dynamicAttributeProvider.hasNext()) {
            	DynamicAttributeProvider d = dynamicAttributeProvider.next();
                return d.getAttribute(expression);
            }
        } catch (ServiceConfigurationError serviceError) {
            throw new RuntimeException(serviceError);
        }
        throw new RuntimeException("No Dynamic Attribute Provider Sevice Located");
	}

}
