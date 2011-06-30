package com.taifook.mtss.mss.acl.service;

import java.util.List;

import com.taifook.mtss.mss.acl.model.AclEntry;

public interface AccessControlListService  {

    public List<AclEntry> listAvailableEntries();
    public boolean isAccessible();

}
