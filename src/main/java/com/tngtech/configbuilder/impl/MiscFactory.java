package com.tngtech.configbuilder.impl;

import com.tngtech.propertyloader.PropertyLoader;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Component
public class MiscFactory {

    public CommandLineParser createCommandLineParser() {
        return new GnuParser();
    }

    public Options createOptions() {
        return new Options();
    }

    public PropertyLoader createPropertyLoader() {
        return new PropertyLoader();
    }

    public StringBuilder createStringBuilder() {
        return new StringBuilder();
    }

    public ValidatorFactory getValidatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }
}
