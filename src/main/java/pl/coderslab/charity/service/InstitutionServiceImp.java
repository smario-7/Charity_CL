package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImp implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImp(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findAll(){
        return new ArrayList<>(institutionRepository.findAll());
    }
}
