/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unapec.nomina.configuration;

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

/**
 *
 * @author phenom
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.unapec.nomina")
public class NominaxConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public BasicDataSource basicDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/Nominas");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("mysql");

        return basicDataSource;
    }
    
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(basicDataSource());
        Properties prop = new Properties();
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        localSessionFactoryBean.setHibernateProperties(prop);
        localSessionFactoryBean.setMappingResources(
                "/edu/unapec/nomina/modelos/Departamentos.hbm.xml",
                "/edu/unapec/nomina/modelos/Puestos.hbm.xml",
                "/edu/unapec/nomina/modelos/Empleados.hbm.xml",
                "/edu/unapec/nomina/modelos/EmpleadoDepartamento.hbm.xml",
                "/edu/unapec/nomina/modelos/Transacciones.hbm.xml",
                "/edu/unapec/nomina/modelos/TipoIngresoDeduccion.hbm.xml",
                "/edu/unapec/nomina/modelos/Nominas.hbm.xml");

        return localSessionFactoryBean;
    }

    //TODO los Bean Restantes
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

}
