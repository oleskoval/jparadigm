package com.sunny.rose.service;


import com.sunny.rose.domains.enterprise.Role;
import com.sunny.rose.exceptions.RepositoryDataException;

public interface AdminService
{
    void  saveRole(Role role)  throws RepositoryDataException;
}
