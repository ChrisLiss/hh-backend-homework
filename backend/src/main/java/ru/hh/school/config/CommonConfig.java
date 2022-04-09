package ru.hh.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.starter.NabCommonConfig;
import ru.hh.school.dao.EmployerDao;
import ru.hh.school.dao.SalaryDao;
import ru.hh.school.dao.VacancyDao;
import ru.hh.school.resource.ExampleHttpClient;
import ru.hh.school.resource.ExampleResource;
import ru.hh.school.service.*;

@Configuration
@Import({
  // import your beans here
  ExampleResource.class,
  NabCommonConfig.class,
  ExampleHttpClient.class,
  EmployerMapper.class,
  EmployerDao.class,
  EmployerService.class,
  AreaMapper.class,
  VacancyDao.class,
  VacancyService.class,
  VacancyMapper.class,
  SalaryDao.class

})
public class CommonConfig {

  @Bean
  public MappingConfig mappingConfig() {
    MappingConfig mappingConfig = new MappingConfig();
    mappingConfig.addPackagesToScan("ru.hh.school.entity");
    return mappingConfig;
  }
}
