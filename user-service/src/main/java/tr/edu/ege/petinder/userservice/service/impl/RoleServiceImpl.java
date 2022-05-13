package tr.edu.ege.petinder.userservice.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.edu.ege.petinder.userservice.exceptions.RoleNotFoundException;
import tr.edu.ege.petinder.userservice.model.Role;
import tr.edu.ege.petinder.userservice.repository.RoleRepository;
import tr.edu.ege.petinder.userservice.service.RoleService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        Objects.requireNonNull(name,"role name cannot be null");
        return roleRepository.findByName(name).orElseThrow(RoleNotFoundException::new);
    }
}
