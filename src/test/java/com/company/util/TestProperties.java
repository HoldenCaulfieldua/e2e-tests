package com.company.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by oleg on 6/14/17.
 */
public final class TestProperties extends Properties {

    private static TestProperties props = null;

    private TestProperties() throws IOException {
        //ToDo: add exception handling with
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        this.load(in);
        in.close();
    }

    public static synchronized TestProperties getProps() throws IOException {
        if (props == null) {
            synchronized (TestProperties.class) {
                props = new TestProperties();
            }
        }
        return props;
    }
}
