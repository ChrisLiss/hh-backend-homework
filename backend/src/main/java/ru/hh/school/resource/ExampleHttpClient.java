package ru.hh.school.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.school.dto.EmployerDto;
import ru.hh.school.dto.VacancyDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleHttpClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ExampleHttpClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public EmployerDto[] getEmployers(Integer page, Integer perPage, String text) throws Exception {

        String pageQuery = "";
        if (page != null) {
            pageQuery = "page=" + Integer.toString(page);
        }
        String perPageQuery = "";
        if (perPage != null) {
            perPageQuery = "per_page=" + Integer.toString(perPage);
        }
        String textQuery = "";
        if (text != null) {
            textQuery = "text=" + text;
        }

        String queryString = Stream.of(pageQuery, perPageQuery, textQuery)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining("&"));

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/employers?" + queryString))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        JsonNode jsonNode = objectMapper.readTree(response.body()).get("items");

        return objectMapper.readValue(jsonNode.toString(), EmployerDto[].class);
    }

    public EmployerDto getEmployerById(Integer employerId ) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/employers/" + Integer.toString(employerId)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        return objectMapper.readValue(response.body(), EmployerDto.class);
    }


    public VacancyDto[] getVacancies(Integer page, Integer perPage, String text) throws Exception {

        String pageQuery = "";
        if (page != null) {
            pageQuery = "page=" + Integer.toString(page);
        }
        String perPageQuery = "";
        if (perPage != null) {
            perPageQuery = "per_page=" + Integer.toString(perPage);
        }
        String textQuery = "";
        if (text != null) {
            textQuery = "text=" + text;
        }

        String queryString = Stream.of(pageQuery, perPageQuery, textQuery)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining("&"));

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/vacancies?" + queryString))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        JsonNode jsonNode = objectMapper.readTree(response.body()).get("items");

        return objectMapper.readValue(jsonNode.toString(), VacancyDto[].class);
    }

    public VacancyDto getVacancyById(Integer vacancyId) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/vacancies/" + Integer.toString(vacancyId)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        return objectMapper.readValue(response.body(), VacancyDto.class);

    }

}
