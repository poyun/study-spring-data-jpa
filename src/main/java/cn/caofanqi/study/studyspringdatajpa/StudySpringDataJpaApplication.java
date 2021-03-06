package cn.caofanqi.study.studyspringdatajpa;

import cn.caofanqi.study.studyspringdatajpa.pojo.domain.AuditUser;
import cn.caofanqi.study.studyspringdatajpa.repository.RepositoryScan;
import cn.caofanqi.study.studyspringdatajpa.repository.impl.MyRepositoryImpl;
import cn.caofanqi.study.studyspringdatajpa.support.AuditorAwareImpl;
import cn.caofanqi.study.studyspringdatajpa.support.IdAuditorAwareImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.sql.DataSource;

/**
 * 启动类
 * @author caofanqi
 */
@EnableAsync
@EnableJpaRepositories(/*basePackages = {"cn.caofanqi.study.studyspringdatajpa.repository"}*/
        /*basePackageClasses = RepositoryScan.class*/
        /*excludeFilters = {@ComponentScan.Filter(value = {Controller.class, Service.class})}*/
        /*repositoryImplementationPostfix = "MyPostfix"*/
        /*queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND*/
        /*repositoryBaseClass = MyRepositoryImpl.class*/)
@EnableJpaAuditing(auditorAwareRef = "idAuditorAwareImpl")
@SpringBootApplication
public class StudySpringDataJpaApplication implements CommandLineRunner {

    @Resource
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(StudySpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("使用的 DataSource : " + dataSource.getClass().getName());
    }

    /**
     * 如果ApplicationContext中只有一个AuditorAware类型的bean，Spring-Date会自动选择，
     * 如果又多个，需要通过@EnableJpaAuditing注解的auditorAwareRef属性进行设置。
     */
    @Bean(name = "auditorAwareImpl")
    public AuditorAware<AuditUser> auditorAwareImpl() {
        return new AuditorAwareImpl();
    }

    @Bean(name = "idAuditorAwareImpl")
    public AuditorAware<Long> idAuditorAwareImpl() {
        return new IdAuditorAwareImpl();
    }

}
