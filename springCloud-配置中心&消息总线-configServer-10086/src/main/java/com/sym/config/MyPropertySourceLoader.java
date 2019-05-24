package com.sym.config;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * spring cloud config 使用 PropertySourceLoader接口来解析配置文件
 * .yml和.yaml文件使用 YamlPropertySourceLoader 这个类来解析
 * .properties和.xml文件使用 PropertiesPropertySourceLoader 来解析
 * 所以我们只需要照着 PropertiesPropertySourceLoader 来实现我们自己的解析类，指定使用utf-8编码，即可解决中文乱码问题（yml不会发生中文乱码）
 * <p>
 * Created by 沈燕明 on 2019/3/9.
 */
public class MyPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            try {
                // spring cloud config 就是使用Properties去解析配置文件的
                Properties prop = new Properties();
                InputStream is = resource.getInputStream();
                InputStreamReader isr = null;
                try {
                    String fileName = resource.getFilename();
                    if (null != fileName && fileName.endsWith(".xml")) {
                        // xml默认是以utf-8去解析的
                        prop.loadFromXML(is);
                    } else {
                        // .properties默认是以iso-8859-1解析，我们重新处理，让他以utf-8的编码格式去解析
                        isr = new InputStreamReader(is, "utf-8");
                        prop.load(isr);
                    }
                    // 如果有解析到配置文件再返回PropertiesPropertySource对象
                    if (!prop.isEmpty()) {
                        return new PropertiesPropertySource(name, prop);
                    }
                } finally {
                    // 如果开启了 InputStreamReader，我们直接关闭它会连带关闭 InputStream
                    if (null != isr) {
                        isr.close();
                    }else{
                        // 否则我们需要手动关闭InputStream
                        is.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
