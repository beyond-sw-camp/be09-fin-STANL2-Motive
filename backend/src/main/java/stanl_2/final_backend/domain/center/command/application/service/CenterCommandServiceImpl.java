package stanl_2.final_backend.domain.center.command.application.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stanl_2.final_backend.domain.center.command.application.dto.request.CenterRegistRequestDTO;
import stanl_2.final_backend.domain.center.command.application.dto.response.CenterRegistResponseDTO;
import stanl_2.final_backend.domain.center.command.domain.aggregate.entity.Center;
import stanl_2.final_backend.domain.center.command.domain.repository.CenterRepository;

@Slf4j
@Service("commandCenterServiceImpl")
public class CenterCommandServiceImpl implements CenterCommandService {

    private final CenterRepository centerRepository;
    private final ModelMapper modelMapper;


    public CenterCommandServiceImpl(CenterRepository centerRepository, ModelMapper modelMapper) {
        this.centerRepository = centerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public CenterRegistResponseDTO registCenter(CenterRegistRequestDTO centerRegistRequestDTO) {

//        Center center = new Center();
//        center.setName(centerRegistRequestDTO.getName());
//        center.setAddress(centerRegistRequestDTO.getAddress());
//        center.setPhone(centerRegistRequestDTO.getPhone());
//        center.setMemberCount(centerRegistRequestDTO.getMemberCount());
//        center.setOperatingAt(centerRegistRequestDTO.getOperatingAt());


        Center center = modelMapper.map(centerRegistRequestDTO, Center.class);
        center.setCreatedAt(center.getCreatedAt());
        center.setUpdatedAt(center.getUpdatedAt());

        centerRepository.save(center);

        CenterRegistResponseDTO centerRegistResponseDTO = modelMapper.map(center, CenterRegistResponseDTO.class);

        return centerRegistResponseDTO;
    }
}
