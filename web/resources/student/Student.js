


$(document).ready(function () {

    $('#successStudentButton').hide();
    $('#errorStudentMessage').hide();
    $('#nameValidation').hide();
    $('#surNameValidation').hide();
    $('#ageValidation').hide();


})

function validation (){

    $('#nameValidation').hide();
    $('#surNameValidation').hide();
    $('#ageValidation').hide();

}

function saveStudentAction(){

    var name = $('#name').val();
    var surName =$('#surName').val();
    var age = $('#age').val();

    if(name===null || name==="" || name===undefined){

        $('#nameValidation').show();
        return;

    }

        else if(surName===null || surName==="" || surName===undefined){

        $('#surNameValidation').show();

        return;

        }
            else if(age===null || age==="" || age===undefined){

        $('#ageValidation').show();

        return;

    }



    var student = {};

    var id = $('#id').val();
    var name =  $('#name').val();
    var surname = $('#surName').val();
    var age = $('#age').val();


    student['id'] = id;
    student['name'] = name;
    student['surname'] = surname;
    student['age'] = age;

    console.log('original ', student);
    console.log('stringify ', JSON.stringify(student));

    $.ajax({

        url: "/student",
        type: "POST",
        dataType:"json",
        data: JSON.stringify(student),
        contentType: "application/json",
        success: function(result,status,xhr){
            $('#form').hide();

            console.log("success", result, "status : " , status, "xhr : ", xhr.status );
            $('#successStudentButton').show();
        },

        error: function(xhr,status,error){
            $('#errorStudentMessage').show();
            $('#form').hide();
            console.log("error", "status : " ,status, "errpor" , error, "xhr : " , xhr)
        }
    });
}



/*
function deleteStudent(id){

    $.ajax({

        url: "/student/delete?id=" +id,
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
}*/
