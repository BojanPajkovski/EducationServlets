/**
 * Created by User on 10.02.2019.
 */
$(document).ready(function () {

    $('#successButton').hide();
    $('#errorMessage').hide();
    $('#facultytNameValidation').hide();
    $('#facultyDescriptionValidation').hide();

})

function facultyValidation(){

    $('#facultytNameValidation').hide();
    $('#facultyDescriptionValidation').hide();
}


function saveAction(){

    var name = $('#name1').val();
    var description =$('#description1').val();


    if(name===null || name==="" || name===undefined){

        $('#facultytNameValidation').show();
        return;

    }

    else if(description===null || description==="" || description===undefined){

        $('#facultyDescriptionValidation').show();

        return;

    }



    var faculty = {};

    var id = $('#id1').val();
    var name =  $('#name1').val();
    var description = $('#description1').val();
    var technical = $('#tecnical').is(':checked');


    faculty['id'] = id;
    faculty['name'] = name;
    faculty['description'] = description;
    faculty['tecnical'] = technical;

    console.log('original ', faculty);
    console.log('stringify ', JSON.stringify(faculty));

   $.ajax({

        url: "/faculty",
        type: "POST",
        dataType:"json",
        data: JSON.stringify(faculty),
        contentType: "application/json",
        success: function(result,status,xhr){
            $('#form').hide();

            console.log("success", result, "status : " , status, "xhr : ", xhr.status );
            $('#successButton').show();
        },

        error: function(xhr,status,error){
            $('#errorMessage').show();
            $('#form').hide();
            console.log("error", "status : " ,status, "errpor" , error, "xhr : " , xhr)
        }
    });
}