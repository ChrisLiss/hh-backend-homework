package ru.hh.school.resource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.school.dto.EmployerDto;
import ru.hh.school.dto.VacancyDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExampleHttpClient {

    private final int page = 0;
    private final int per_page = 10;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();

    public EmployerDto[] getEmployers() throws Exception {

        // TODO: 04.04.2022 Возвращает массив EmployerDTO

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/employers?" + "page=" + Integer.toString(page) + "&per_page=" + Integer.toString(per_page)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        JsonNode jsonNode = objectMapper.readTree(response.body()).get("items");
        EmployerDto[] employersDto = objectMapper.readValue(jsonNode.toString(), EmployerDto[].class);

        return employersDto;
    }

    public EmployerDto getEmployerById(Integer employerId ) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/employers/" + Integer.toString(employerId)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        EmployerDto employerDto = objectMapper.readValue(response.body(), EmployerDto.class);

        return employerDto;

    }

    public EmployerDto getFavoriteEmployerById(Integer employerId) throws Exception {   // то же, что и getEmployerById

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/employers/" + Integer.toString(employerId)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        EmployerDto employerFavorite = objectMapper.readValue(response.body(), EmployerDto.class);

        return employerFavorite;

    }

    public VacancyDto[] getVacancies() throws Exception {

        // TODO: 04.04.2022 Возвращает массив VacancyDTO

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/vacancies?" + "page=" + Integer.toString(page) + "&per_page=" + Integer.toString(per_page)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        JsonNode jsonNode = objectMapper.readTree(response.body()).get("items");
        VacancyDto[] vacanciesDto= objectMapper.readValue(jsonNode.toString(), VacancyDto[].class);

        return vacanciesDto;

    }

    public VacancyDto getVacancyById(Integer vacancyId) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.hh.ru/vacancies/" + Integer.toString(vacancyId)))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // обработать ошибки
//        if (response.statusCode() == 200) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(response.body(), VacancyDto.class);

    }





}
