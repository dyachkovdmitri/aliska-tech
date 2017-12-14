package com.neiron.neiron.config;

import com.neiron.neiron.controllers.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.neiron.neiron.*")
//@Import({ AppSecurityConfig.class })
public class WebConfig  extends WebMvcConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(WebConfig.class);
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("index");
        logger.error("InternalResourceViewResolver INITIALIZED");
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        logger.error("InternalResourceViewResolver INITIALIZED");
        return viewResolver;
    }
//
//    @Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
////        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/dd");
////        driverManagerDataSource.setUsername("postgres");
////        driverManagerDataSource.setPassword("postgres");
//        logger.error("DATA SOURCE INITIALIZED");
//        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
//        driverManagerDataSource.setUrl("jdbc:postgresql://ec2-107-22-165-47.compute-1.amazonaws.com:5432/d726pn04csmqqc");
//        driverManagerDataSource.setUsername("vhfaivnimxdhsl");
//        driverManagerDataSource.setPassword("375a8eeff896bb7a74202c45d188ce27a2272c534a229322579cc6f4af2e6ec3");
//        return driverManagerDataSource;
//    }



    @Bean
    MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);//587
        mailSender.setUsername("dyachkovdmitri@gmail.com");
        mailSender.setPassword("Shikaka1");
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(prop);
        return mailSender;
    }

//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSender mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//
//        mailSender.setUsername("my.gmail@gmail.com");
//        mailSender.setPassword("password");
//
//        Properties props;
//        props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return mailSender;
//    }

//    @Bean //Creates our EntityManagerFactory
//    public AbstractEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        return emf;
//    }
//
//    @Bean //Creates our PlatformTransactionManager. Registering both the EntityManagerFactory and the DataSource to be shared by the EMF and JDBCTemplate
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf, DataSource dataSource){
//        JpaTransactionManager tm = new JpaTransactionManager(emf);
//        tm.setDataSource(dataSource);
//        return tm;
//    }
}