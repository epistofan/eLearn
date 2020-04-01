package lv.elearning.elearningProject.Controllers;


import lv.elearning.elearningProject.DAL.Repository;
import lv.elearning.elearningProject.Domain.*;
import lv.elearning.elearningProject.TokenManager;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.IOUtils.toByteArray;


@RestController
public class Controller {

    @Autowired
    Repository repository;
    @Autowired
    TokenManager tokenManager;


    @PutMapping("/newTask")
    public String uploadFile(@RequestPart("task") Task task, @RequestPart("obj") MultipartFile multiPartFile, ServletRequest servletRequest){

        File file = new File("/usr/bin/"+multiPartFile.getOriginalFilename());



        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {

            multiPartFile.transferTo(file);

        }catch (Exception e) {

        }
        System.out.println("upload");

        task.setLink(multiPartFile.getOriginalFilename());
        repository.addTask(task);

        return "success";
    }


    @GetMapping("/workers")
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
    @PostMapping("/worker")
    public void addWorker(@RequestPart("photo") MultipartFile multiPartFile, @RequestPart("worker") Worker worker, @RequestPart("workerAccess") WorkerAccess workerAccess, ServletRequest servletRequest){


        File file = new File("/usr/bin/"+multiPartFile.getOriginalFilename());

        try {
            multiPartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        worker.setPhoto(multiPartFile.getOriginalFilename());
       repository.addWorker(worker, workerAccess);



    }
    @PutMapping("/worker")
    public void updateWorker(@RequestPart("photo") MultipartFile multiPartFile, ServletRequest servletRequest){

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeader("Authorization");

        int workerId = tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId();


        File file = new File("/usr/bin/"+multiPartFile.getOriginalFilename());

        try {
            multiPartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        repository.updateWorker(workerId, multiPartFile.getOriginalFilename());



    }
    @GetMapping("/image2")
    public String downloadTask( HttpServletRequest request,
                                     HttpServletResponse response){


        String fileName = "don.jpg";


        String dataDirectory = "/usr/bin/";
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)){

            response.setContentType("image/jpg");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "image";
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImageAsResponseEntity(ServletRequest servletRequest) throws IOException {

        String avatar;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Worker worker = repository.getWorker(tokenManager.parseToken(request.getHeader("Authorization")).getWorkerId());
                avatar = worker.getPhoto();
        HttpHeaders headers = new HttpHeaders();
        InputStream in = new FileInputStream("/usr/bin/"+avatar);
        byte[] media = IOUtils.toByteArray(in);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/task", produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getTask(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        String taskLink;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Task task = repository.getTask(Integer.valueOf(request.getHeader("taskId")));
        taskLink = task.getLink();
        HttpHeaders headers = new HttpHeaders();
        InputStream in = new FileInputStream("/usr/bin/"+taskLink);
        byte[] media = IOUtils.toByteArray(in);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        response.addHeader("fileExtension", taskLink);

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }
}
