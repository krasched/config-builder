package com.tngtech.configbuilder.annotationprocessors;


import com.tngtech.configbuilder.annotationprocessors.interfaces.IValueExtractorProcessor;
import com.tngtech.configbuilder.impl.BuilderConfiguration;
import com.tngtech.configbuilder.annotations.CommandLineValue;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class CommandLineValueProcessor  implements IValueExtractorProcessor {

    public String getValue(Annotation annotation, BuilderConfiguration builderConfiguration) {
        return builderConfiguration.getCommandLineArgs().getOptionValue(((CommandLineValue)annotation).shortOpt());
    }
}
