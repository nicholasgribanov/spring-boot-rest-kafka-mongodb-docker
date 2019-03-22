package name.nicholasgribanov.producer.restclient.services;

import name.nicholasgribanov.dto.Data;

import java.util.List;

public interface ApiService {
    List<Data> getData(Integer limit);
}
