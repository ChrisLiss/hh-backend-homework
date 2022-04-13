package ru.hh.school.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.starter.NabCommonConfig;
import ru.hh.school.dao.EmployerDao;
import ru.hh.school.dao.VacancyDao;
import ru.hh.school.resource.ExampleHttpClient;
import ru.hh.school.resource.ExampleResource;
import ru.hh.school.service.*;


import java.net.http.HttpClient;

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
  VacancyMapper.class

})
public class CommonConfig {

  @Bean
  public MappingConfig mappingConfig() {
    MappingConfig mappingConfig = new MappingConfig();
    mappingConfig.addPackagesToScan("ru.hh.school.entity");
    return mappingConfig;
  }

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
    return mapper;
  }

  @Bean
  public HttpClient httpClient() {
    HttpClient httpClientExample = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
    return httpClientExample;
  }


}
