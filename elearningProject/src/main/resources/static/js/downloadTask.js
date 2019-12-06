async function  downloadTask(name){


                let response = await fetch("http://macibas.linkpc.net/task", {
                    headers:
                        {
                            "Authorization": $("#tkn2").text(),
                            "taskId": name
                        }

                });

                let blob = await response.blob();
let fileExtension = await response.headers.get("fileExtension");

                download(blob, "uzdevums_"+fileExtension);
                //$( "#avatar" ).attr("src", URL.createObjectURL(blob) );






}