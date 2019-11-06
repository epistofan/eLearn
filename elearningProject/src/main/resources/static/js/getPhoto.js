async function  getPhoto(){


                let response = await fetch("http://macibas.linkpc.net/image", {headers: {"Authorization": $("#tkn2").text() }});

                let blob = await response.blob();


                $( "#avatar" ).attr("src", URL.createObjectURL(blob) );






}