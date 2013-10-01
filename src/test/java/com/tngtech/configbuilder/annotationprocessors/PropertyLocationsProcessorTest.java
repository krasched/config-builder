package com.tngtech.configbuilder.annotationprocessors;

import com.tngtech.configbuilder.annotations.PropertyLocations;
import com.tngtech.propertyloader.PropertyLoader;
import com.tngtech.propertyloader.impl.DefaultPropertyLocationContainer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyLocationsProcessorTest {

    @Mock
    private PropertyLocations propertyLocations;
    @Mock
    DefaultPropertyLocationContainer propertyLocation;
    @Mock
    PropertyLoader propertyLoader;

    @Test
    public void testPropertyLocationsProcessor(){

        PropertyLocationsProcessor propertyLocationsProcessor = new PropertyLocationsProcessor();

        String[] dirs = new String[]{"dir1","dir2"};
        Class[] classes = new Class[]{this.getClass(), Object.class};

        when(propertyLoader.getLocations()).thenReturn(propertyLocation);
        when(propertyLocations.directories()).thenReturn(dirs);
        when(propertyLocations.resourcesForClasses()).thenReturn(classes);

        propertyLocationsProcessor.configurePropertyLoader(propertyLocations, propertyLoader);

        verify(propertyLocation).clear();
        verify(propertyLocation).atDirectory("dir1");
        verify(propertyLocation).atDirectory("dir2");
        verify(propertyLocation).atRelativeToClass(this.getClass());
        verify(propertyLocation).atRelativeToClass(Object.class);
    }
}
