package edu.unapec.nomina.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.unapec.nomina")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {

    @Bean(name = "HelloWorld")
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    
    @Bean(name = "dataSource")
    public BasicDataSource basicDataSource()
    {
        BasicDataSource basic = new BasicDataSource();
        basic.setDriverClassName("com.mysql.jdbc.Driver");
        basic.setUrl("jdbc:mysql://localhost:3306/Nominas");
        basic.setUsername("root");
        basic.setPassword("mysql");
        
        return basic;
    }
    
    @Bean(name = "hibernate3SessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean()
    {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(basicDataSource());
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        lsfb.setHibernateProperties(props);
        
        List<Object> list = new ArrayList<Object>();
        lsfb.setMappingResources("/edu/unapec/nomina/modelos/Departamentos.hbm.xml",
                                "/edu/unapec/nomina/modelos/Puestos.hbm.xml",
                                "/edu/unapec/nomina/modelos/Empleados.hbm.xml",
                                "/edu/unapec/nomina/modelos/EmpleadoDepartamento.hbm.xml",
                                "/edu/unapec/nomina/modelos/Transacciones.hbm.xml",
                                "/edu/unapec/nomina/modelos/TipoIngresoDeduccion.hbm.xml",
                                "/edu/unapec/nomina/modelos/Nominas.hbm.xml");
        
        return lsfb;
    }

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
