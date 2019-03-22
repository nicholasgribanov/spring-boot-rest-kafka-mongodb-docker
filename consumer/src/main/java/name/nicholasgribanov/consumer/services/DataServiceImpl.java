package name.nicholasgribanov.consumer.services;


import name.nicholasgribanov.consumer.repositories.DataRepository;
import name.nicholasgribanov.dto.Data;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    private DataRepository repository;

    public DataServiceImpl(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Data saveMessage(Data data) {
        return repository.save(data);
    }
}
