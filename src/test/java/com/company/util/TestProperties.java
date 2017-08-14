package com.company.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public final class TestProperties extends Properties {

    private static TestProperties props = null;

    private TestProperties()  {
        //ToDo: add exception handling with
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
            this.load(in);
            in.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
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
