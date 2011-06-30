package org.springframework.samples.mvc.basic.service;

import java.util.List;

import org.springframework.samples.mvc.basic.model.AclEntry;

public interface AccessControlListService  {

    public List<AclEntry> listAvailableEntries();
    public boolean isAccessible();

}
