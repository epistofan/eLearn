package lv.elearning.elearningProject.Controllers;


import lv.elearning.elearningProject.DAL.Repository;
import lv.elearning.elearningProject.Domain.*;
import lv.elearning.elearningProject.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {

    @Autowired
    Repository repository;
    @Autowired
    TokenManager tokenManager;


    @PostMapping("/newTask")
    public String uploadFile(@RequestPart("taskName") String taskName, @RequestPart("name") String name, @RequestPart("obj") MultipartFile multiPartFile, ServletRequest servletRequest){

        File file = new File("/usr/bin/"+multiPartFile.getOriginalFilename());



        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {

           // Part filePart =  request.getPart("obj");
            multiPartFile.transferTo(file);


           // InputStream fileInputStream = filePart.getInputStream();


            //Path file = Files.createFile(Paths.get().fileInputStream);

            //Files.copy(fileInputStream, )
            //FileOutputStream fileOutputStream = new FileOutputStream("C:\\test.txt");


        }catch (Exception e) {

        }
        System.out.println("upload");

        Task task = new Task();
        task.setTaskName(taskName);
        task.setTaskSubject(name);
        task.setLink(multiPartFile.getOriginalFilename());
        repository.addTask(task);



        return "home";
    }


    @GetMapping("/getWorkers")
    public List<Worker> getWorkers(){



        return repository.getWorkers();

    }

    @GetMapping("/getTasks")
    public ResponseEntity<List<Task>> getTasks(ServletRequest servletRequest){

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(tokenManager.parseToken(request.getHeader("Authorization")).getRole().equals("master")){


            //return repository.getTasks();
            return ResponseEntity.status(HttpStatus.OK).body(repository.getTasks());
        }else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        }



        }






    @PostMapping("/setComplete")
    public void setComplete(@RequestBody String name, ServletRequest servletRequest){

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeader("Authorization");

        repository.setCompleted(tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId(), Integer.valueOf(name));


        System.out.println("completed");
    }



    @GetMapping("/getWorkerTask")
    public List<WorkerTask1> getWorkerTask(ServletRequest servletRequest){



        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeader("Authorization");

        String name = (String) request.getHeader("user");
        System.out.println(name);
        //tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId();
        return repository.getWorkerTask1(Integer.valueOf(name));
    }

    @GetMapping("/workerTask")
    public List<WorkerTask1> myWorkerTask(ServletRequest servletRequest){


        HttpServletRequest request = (HttpServletRequest) servletRequest;

        return repository.getWorkerTask1(tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId());
    }


    @GetMapping("/workerTaskHistory")
    public List<WorkerTask1> workerTaskHistory(ServletRequest servletRequest){


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId());

        return repository.workerTaskHistory(tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId());
    }
    @PostMapping("/sendTask")
    public void sendTask(@RequestBody String name){

        int taskId = Integer.parseInt(name);

        System.out.println("sent");

        repository.getWorkers();
        repository.addWorkerTask(taskId, repository.getWorkers() );
    }

    @GetMapping("/uncompletedWorkerTask")
    public Map<Integer, List<uncompletedWorkerTask>> uncompletedWorkerTask(ServletRequest servletRequest, ServletResponse servletResponse){

        Map<Integer, List<uncompletedWorkerTask>> map = new HashMap<>();

        int i;
        int j;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(tokenManager.parseToken(request.getHeader("Authorization")).getRole().equals("master")) {

            List<uncompletedWorkerTask> uncompletedWorkerTasksList = repository.uncompletedWorkerTask();

            List<Worker> workerList = repository.getWorkers();

            for (i = 0; i < workerList.size(); i++) {
                List<uncompletedWorkerTask> tempList = new ArrayList<>();
                for (j = 0; j < uncompletedWorkerTasksList.size(); j++) {

                    if (workerList.get(i).getWorkerId() == uncompletedWorkerTasksList.get(j).getWorkerId()) {

                        tempList.add(uncompletedWorkerTasksList.get(j));

                    }


                }
                map.put(workerList.get(i).getWorkerId(), tempList);

            }
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("mapLength", String.valueOf(map.size()));
            return map;
        }else {
            return null;
        }
    }


    @PutMapping("/task")
    public void deleteTask(@RequestBody String name, ServletRequest servletRequest){

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeader("Authorization");


        repository.deleteTask(Integer.valueOf(name));



    }
    @PutMapping("/worker")
    public void addWorker(@RequestBody Worker worker, ServletRequest servletRequest){


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeader("Authorization");



        repository.addWorker(worker);



    }
}
