package com.adobedam.core.swagger;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Adobe DAM | Swagger UI Tool", description = "OSGi Configuration for API Spec URL")
public @interface Config {

    @AttributeDefinition(name = "API Spec URL", description = "Enter the absolute URL of the API Spec")
    String apiSpecUrl();

}