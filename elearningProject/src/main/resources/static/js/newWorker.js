function newWorker() {


    let worker =

                        $.ajaxSetup({async: true,
                                            headers: {},
                                            dataType: "json",
                                            data: worker

                                            });


                      $.post("http://macibas.linkpc.net/getWorkerTask", function (data) {

                          if ($(div).text().length ==0) {

                              $.each(data, function (index, value) {


                                  div.append(value.taskId + " " + value.taskName + "<br>" + value.taskSubject);
                                  div.append("<br>");

                              });

                          }else{$(div).empty()}


                        })

                    });




    data[i].forEach(function (item) {


       // $(".content2").text(item.taskId + " " +item.taskName);


                                    });



        $("#users").append(list);
$(list).append(button);

            }catch (error) {
                console.log("error");
            }


            }

        }else {

            return "no access";
        }
    }






}

