/**
 * Created by User on 11.02.2019.
 */
function deleteUniversity(id){

    $.ajax({

        url: "/university/delete?id=" +id,
        type: "POST",
        dataType:"json",
        contentType: "application/json",
        success: function(result,status,xhr){

            console.log("success", result, "status : " , status, "xhr : ", xhr.status );

        },

        error: function(xhr,status,error){



            console.log("error", "status : " ,status, "errpor" , error, "xhr : " , xhr)
        }

    });
}
