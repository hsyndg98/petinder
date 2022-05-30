package tr.edu.ege.petinder.userservice.service;

import tr.edu.ege.petinder.userservice.model.RoleType;

public interface RoleService {
    String findByName(RoleType name);

}
