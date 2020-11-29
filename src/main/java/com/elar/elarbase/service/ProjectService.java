package com.elar.elarbase.service;

import com.elar.elarbase.bl.SessionUtil;
import com.elar.elarbase.dao.ProjectDao;
import com.elar.elarbase.domain.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;


public class ProjectService extends SessionUtil implements ProjectDao {


    @Override
    public Project createProject (Project project) throws SQLException {

        openTransactionSession();            //открытие
        Session session = getSession();  // логика транзакции
        session.save(project);           // логика транзакции
        closeTransactionSession();          //закрытие
        return project;

    }


    @Override
    public List<Project> getAll() throws SQLException {

        openTransactionSession();

        String sql = "select * from project";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class); // обычный SQL запрос у сущьности Address
        List<Project> projectsList = query.list();

        closeTransactionSession();

        return projectsList;
    }

    @Override
    public Project getById(int id) throws SQLException {
        openTransactionSession();

        String sql = "select * from project where id = ?";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter(1, id);

        Project project = (Project) query.getSingleResult();

        closeTransactionSession();
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {

    }

    @Override
    public void remove(Project project) throws SQLException {

    }
}
