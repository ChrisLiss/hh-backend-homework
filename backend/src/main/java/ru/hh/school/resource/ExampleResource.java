package ru.hh.school.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hh.school.dto.EmployerDto;
import ru.hh.school.dto.VacancyDto;
import ru.hh.school.entity.EmployerEntity;
import ru.hh.school.entity.VacancyEntity;
import ru.hh.school.service.EmployerMapper;
import ru.hh.school.service.EmployerService;
import ru.hh.school.service.VacancyMapper;
import ru.hh.school.service.VacancyService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Path("/")
public class ExampleResource {

  private static final Logger logger = LoggerFactory.getLogger(ExampleResource.class);

  private final ExampleHttpClient httpClientExample;
  private final EmployerService employerService;
  private final VacancyService vacancyService;

  @Inject
  public ExampleResource(ExampleHttpClient httpClientExample, EmployerService employerService, VacancyService vacancyService) {
    this.httpClientExample = httpClientExample;
    this.employerService = employerService;
    this.vacancyService = vacancyService;
  }

  @GET
  public void dummy() {
    logger.info("Do nothing");
  }

  @GET
  @Path(value = "/employer")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getEmployers(@QueryParam(value = "page") Integer page, @QueryParam(value = "per_page") Integer perPage,
                               @QueryParam(value = "query") String text) throws Exception {

    logger.info("получить список работодателей");
    return Response.ok(httpClientExample.getEmployers(page, perPage, text)).build();
  }

  @GET
  @Path(value = "/employer/{employer_id}")
  @Produces(MediaType.APPLICATION_JSON)
  // TODO: 02.04.2022 Получить компанию с id с api hh
  public Response getEmployerById(@PathParam(value = "employer_id") Integer employerId) throws Exception {

    logger.info("Получить компанию по id");
    return Response.ok(httpClientExample.getEmployerById(employerId)).build();

  }

  @GET
  @Path(value = "/vacancy")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacancies(@QueryParam(value = "page") Integer page, @QueryParam(value = "per_page") Integer perPage,
                               @QueryParam(value = "query") String text) throws Exception {

    logger.info("получить список вакансий");
    return Response.ok(httpClientExample.getVacancies(page, perPage, text)).build();

  }

  @GET
  @Path(value = "/vacancy/{vacancy_id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacancyById(@PathParam(value = "vacancy_id") Integer vacancyId) throws Exception {

    logger.info("получить вакансию");
    return Response.ok(httpClientExample.getVacancyById(vacancyId)).build();

  }

  @POST
  @Path(value = "/favorites/employer")
  public Response saveFavoriteEmployer(@QueryParam(value = "employer_id") Integer employerId, @QueryParam(value = "comment") String comment) throws Exception {

    logger.info("сохранить избранную компанию");
    EmployerDto employerDto = httpClientExample.getEmployerById(employerId);
    EmployerEntity employerEntity = EmployerMapper.mapDtoToEntity(employerDto, comment);
    employerService.create(employerEntity);

    return Response.ok().build();

  }

  @POST
  @Path(value = "/favorites/employer/{employer_id}/refresh")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateInfoFavoriteEmployer(@PathParam(value = "employer_id") Integer employerId) throws Exception {

    logger.info("обновить данные по избранной компании");
    EmployerDto employerDto = httpClientExample.getEmployerById(employerId);
    employerService.updateInfo(employerDto);
    return Response.ok().build();
  }

  @PUT
  @Path(value = "/favorites/employer/{employer_id}")
  public Response updateCommentFavoriteEmployer(@PathParam(value = "employer_id") Integer id, @QueryParam(value = "comment") String comment) {

    logger.info("обновить комментарий по избранной компании");
    employerService.updateComment(id, comment);
    return Response.ok().build();
  }

  @DELETE
  @Path(value = "/favorites/employer/{employer_id}")
  public Response deleteFavoriteEmployer(@PathParam(value = "employer_id") Integer id) {

    logger.info("удалить компанию из избранного");
    employerService.deleteFromFavorites(id);
    return Response.ok().build();
  }

  @GET
  @Path(value = "/favorites/employer")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getFavoritesEmployers(@QueryParam(value = "page") Integer page, @QueryParam(value = "per_page") Integer perPage) {

    logger.info("получить все избранные компании");
    List<EmployerEntity> employerEntityList = employerService.getEmployers(page, perPage);
    List<EmployerDto> employerDtoList = employerEntityList.stream()
                                             .map(EmployerMapper::mapEntityToDto)
                                             .collect(Collectors.toList());

    employerEntityList.stream().forEach(employerService::updateViewsCount);

    return Response.ok(employerDtoList).build();

  }

  @POST
  @Path(value = "/favorites/vacancy")
  @Produces(MediaType.APPLICATION_JSON)
  public Response saveFavoriteVacancy(@QueryParam(value = "vacancy_id") Integer vacancyId, @QueryParam(value = "comment") String comment) throws Exception {

    logger.info("сохранить избранную вакансию");

    VacancyDto vacancyDto = httpClientExample.getVacancyById(vacancyId);
    VacancyEntity vacancyEntity = VacancyMapper.mapDtoToEntity(vacancyDto, comment);
    vacancyService.create(vacancyEntity);

    return Response.ok().build();
  }

  @DELETE
  @Path(value = "favorites/vacancy/{vacancy_id}")
  public Response deleteFavoriteVacancy(@PathParam(value = "vacancy_id") Integer id) {

    logger.info("удалить вакансию из избранного");
    vacancyService.deleteFromFavorites(id);

    return Response.ok().build();

  }

  @POST
  @Path(value = "/favorites/vacancy/{vacancy_id}/refresh")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateInfoFavoriteVacancy(@PathParam(value = "vacancy_id") Integer vacancyId) throws Exception {

    logger.info("обновить данные по избранной вакансии");
    VacancyDto vacancyDto = httpClientExample.getVacancyById(vacancyId);
    vacancyService.updateInfo(vacancyDto);

    return Response.ok().build();
  }

  @GET
  @Path(value = "/favorites/vacancy")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getFavoritesVacancies(@QueryParam(value = "page") Integer page, @QueryParam(value = "per_page") Integer perPage) {

    logger.info("получить все избранные вакансии");

    List<VacancyEntity> vacancyEntityList =vacancyService.getVacancies(page, perPage);
    List<VacancyDto> vacancyDtoList = vacancyEntityList.stream()
            .map(VacancyMapper::mapEntityToDto)
            .collect(Collectors.toList());

    vacancyEntityList.stream()
            .forEach(vacancyService::updateViewsCountVacancyAndEmployer);

    return Response.ok(vacancyDtoList).build();

  }


}
