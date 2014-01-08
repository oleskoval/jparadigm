package com.sunny.rose.service;

import com.sunny.rose.domains.enterprise.Role;
import com.sunny.rose.exceptions.RepositoryDataException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Service("adminService")
@Repository
@Transactional
public class JpaAdminService implements AdminService, Serializable
{
    private static final long serialVersionUID = 1L;

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em)
    {
        this.em = em;
    }

    @Transactional
    public void saveRole(Role role) throws RepositoryDataException
    {
//        Query query = em.createQuery("select r from Role r where r.roleName = :rolename ")
//                .setParameter("rolename", role.getRoleName());
//        List<Role> roles = query.getResultList();
//        if (roles != null && roles.size() > 0)
//        {
//            return;      //TODO
//        }

        em.persist(role);
    }
}
