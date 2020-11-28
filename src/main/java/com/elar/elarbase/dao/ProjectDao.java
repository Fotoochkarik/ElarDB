package com.elar.elarbase.dao;

import com.elar.elarbase.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {

    //create
    Project createProject (Project project) throws SQLException;

    //read
    List<Project> getAll() throws SQLException;

    Project getById (int id) throws SQLException;

    //update
    void update (Project project) throws SQLException;

    //delete
    void remove(Project project) throws SQLException;
}
