package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.InstitutionReadDto;
import pl.coderslab.charity.dto.InstitutionWriteDto;
import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface InstitutionService {
    List<InstitutionReadDto> findNFirst(int size);
    void save(InstitutionWriteDto institutionWriteDto);
    void delete(Long id);
    InstitutionReadDto findById(Long id);
    void update(InstitutionReadDto institutionReadDto);
}
