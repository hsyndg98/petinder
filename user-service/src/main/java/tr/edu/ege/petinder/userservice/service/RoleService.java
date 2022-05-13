package tr.edu.ege.petinder.userservice.service;

import tr.edu.ege.petinder.userservice.model.Role;

public interface RoleService {
    Role findByName(String name);

}
