package com.foodparcel.Service.impl;

/*Danielle Johnson
Student no: 214104281*/

import com.foodparcel.Service.ApplicationService;
import com.foodparcel.entity.Application;
import com.foodparcel.factory.ApplicationFactory;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplicationServiceImplTest{

    @Autowired
    private static ApplicationService service ;
    //application 1
    private static Application application = ApplicationFactory.createApplication("5656675", "FHGkjhsdkj",
            "Johnson", "17 Krisnic", "0981235673",
            2, 5600.00);


    @org.junit.Test
    public void a_Create() {
        Application createAppl = service.create(application);
        assertEquals(application.getId(), createAppl.getId());
        System.out.println("Application created : " + createAppl);
    }

    @org.junit.Test
    public void b_Read() {
        Application readApplication = service.read(application.getId());
        System.out.println("Read Application : " + readApplication);

    }

    @org.junit.Test
    public void c_Update() {
        Application updateApplication = new Application.Builder().copy(application).setfirstName("Danielle").build();
        updateApplication = service.update(updateApplication);
        System.out.println("Application updated : " + updateApplication);
    }


    @org.junit.Test
    public void d_GetAll() {
        Set<Application> applications = service.getAll();
        assertEquals(1, applications.size());
        System.out.println("All applications : " + applications);
    }

    @org.junit.Test
    public void e_notEmpty() {
        Set<Application> applications = service.noEmptyValues();
        assertNotNull(application.getId());
        assertNotNull(application.getFirstName());
        assertNotNull(application.getLastName());
        assertNotNull(application.getHomeAddress());


    }

    @org.junit.Test
    public void f_Delete() {
        service.delete(application.getId());
        System.out.println("Application deleted");

    }

}

