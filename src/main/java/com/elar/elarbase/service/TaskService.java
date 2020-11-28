package com.elar.elarbase.service;

import com.elar.elarbase.bl.SessionUtil;
import com.elar.elarbase.entity.Device;
import com.elar.elarbase.entity.Project;
import com.elar.elarbase.entity.Task;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class TaskService extends SessionUtil {


    public Device addTask (String nameDevice, List<Project> projectList){
        openTransactionSession();
        Session session = getSession();

        Device device1 = new Device();
        device1.setNameDevice(nameDevice);
        device1.setProjects(projectList);

        session.save(device1);

        closeTransactionSession();
        return device1;
    }

    public Task createTask (Task task) throws SQLException {

        openTransactionSession();            //открытие
        Session session = getSession();  // логика транзакции
        session.save(task);           // логика транзакции
        closeTransactionSession();          //закрытие
        return task;

    }


    public void printTask (String nameDevice){
        openTransactionSession();

        Session session = getSession();

        String sql ="SELECT d2.id , d2.name_device ,p2.title, p2.status ,p2.project_id FROM device d2 INNER JOIN project p2  ON d2.id = p2.project_id where d2.name_device = 'Партия 2'";
        Query query = session.createNativeQuery(sql).addEntity(Project.class); // обычный SQL запрос у сущьности Address

        List<Project> projectsList = query.list(); //полученный результат из запроса приобразовываем в лист

        for (Project project :projectsList) {
            System.out.println(project);
        }

        closeTransactionSession();

    }
}
