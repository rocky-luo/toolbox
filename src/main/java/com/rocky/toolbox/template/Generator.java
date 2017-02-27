package com.rocky.toolbox.template;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.Map;

/**
 * Created by rocky on 17/2/24.
 */
public class Generator {
    private final static Logger LOGGER = LoggerFactory.getLogger(Generator.class);

    public static String classpathTemplateGen(String templateFile, Map<String, Object> data) {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
        ClassLoader classLoader = Generator.class.getClassLoader();
        URL url = classLoader.getResource("");
        StringWriter out = new StringWriter();
        try {
            configuration.setDirectoryForTemplateLoading(new File(url.getFile()));
            Template template = configuration.getTemplate(templateFile);
            template.process(data, out);
        }catch (IOException | TemplateException e) {
            LOGGER.error("", e);
        }
        return out.toString();
    }
}
