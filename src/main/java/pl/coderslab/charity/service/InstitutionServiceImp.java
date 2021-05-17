package pl.coderslab.charity.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImp implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImp(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findNFirst(int size){
        return institutionRepository.findAll(PageRequest.of(0,size)).getContent();
    }
}
