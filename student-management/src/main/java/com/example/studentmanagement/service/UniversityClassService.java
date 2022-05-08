package com.example.studentmanagement.service;

import com.example.studentmanagement.dao.UnversityClassDao;
import com.example.studentmanagement.exceptions.invalidUniversityClassException;
import com.example.studentmanagement.model.UniversityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class UniversityClassService {
    UnversityClassDao universityClassDao;

    @Autowired
    public UniversityClassService(UnversityClassDao universityClassDao) {
        this.universityClassDao = universityClassDao;
    }

    public List<UniversityClass> getAllClasses(){
        return (List<UniversityClass>) universityClassDao.findAll();
    }
    public UniversityClass addClass(UniversityClass universityClass){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(universityClass.getYear()<currentYear){
            throw new invalidUniversityClassException("Can not add class in the past");
        }

        if(universityClass.getYear()>currentYear+1){
            throw new invalidUniversityClassException("Can not add class in the far future");
        }

        return universityClassDao.save(universityClass);
    }
}
