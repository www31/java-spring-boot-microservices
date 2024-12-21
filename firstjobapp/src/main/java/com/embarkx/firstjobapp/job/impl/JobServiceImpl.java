package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatedJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

//    private List<Job> jobs = new ArrayList<>();
//    private Long nextId = 1L;
//
//    public JobServiceImpl(List<Job> jobs) {
//        this.jobs = jobs;
//    }
//
//    @Override
//    public List<Job> findAll() {
//        return jobs;
//    }
//
//    @Override
//    public void createJob(Job job) {
//        job.setId(nextId++);
//        jobs.add(job);
//    }
//
//    @Override
//    public Job getJobById(Long id) {
//        for (Job job : jobs) {
//            if (job.getId().equals(id)) {
//                return job;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId().equals(id)) {
//                System.out.println("deleteJobById id: " + id);
//                System.out.println("deleteJobById job id: " + job.getId());
//                System.out.println("deleteJobById iterator: " + job);
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updatedJob(Long id, Job updateJob) {
//        for (Job job : jobs) {
//            if (job.getId().equals(id)) {
//                job.setTitle(updateJob.getTitle());
//                job.setDescription(updateJob.getDescription());
//                job.setMinSalary(updateJob.getMinSalary());
//                job.setMaxSalary(updateJob.getMaxSalary());
//                job.setLocation(updateJob.getLocation());
//                return true;
//            }
//        }
//        return false;
//    }
}
