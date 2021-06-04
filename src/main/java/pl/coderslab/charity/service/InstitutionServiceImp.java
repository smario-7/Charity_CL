package pl.coderslab.charity.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionReadDto;
import pl.coderslab.charity.dto.InstitutionWriteDto;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImp implements InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImp(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<InstitutionReadDto> findNFirst(int size){
        return institutionRepository.findAll(PageRequest.of(0,size)).getContent()
                .stream()
                .map(entity -> new InstitutionReadDto(entity.getId(), entity.getName(), entity.getDescription()))
                .collect(Collectors.toList());
    }

    public void save(InstitutionWriteDto institutionWriteDto) {
        Institution newInstitution = new Institution();
        newInstitution.setName(institutionWriteDto.getName());
        newInstitution.setDescription(institutionWriteDto.getDescription());
        institutionRepository.save(newInstitution);
    }
    public void delete(Long id){
        institutionRepository.deleteById(id);
    }

    public InstitutionReadDto findById(Long id){
        Institution institution =  institutionRepository.findById(id).orElseThrow(EntityExistsException::new);
        return new InstitutionReadDto(institution.getId(), institution.getName(), institution.getDescription());
    }

    public void update(InstitutionReadDto institutionReadDto){
        Institution editInstitution = institutionRepository.findById(institutionReadDto.getId()).orElseThrow(EntityNotFoundException::new);
        editInstitution.setName(institutionReadDto.getName());
        editInstitution.setDescription(institutionReadDto.getDescription());
        institutionRepository.save(editInstitution);
    }
}
