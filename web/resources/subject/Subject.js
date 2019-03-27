/**
 * Created by User on 11.02.2019.
 */
$(document).ready(function () {

    $('#successButton').hide();
    $('#errorMessage').hide();

})



function saveSubjectAction(){




    if(name ===null || name ==="" || name == undefined){


    alert("Name field is mandatory")

    return;

    }
    else if(credits ===null || credits ==="" || credits == undefined){

        alert("credits field is mandatory")

        return;
    } else if(semestar ===null || semestar ==="" || semestar == undefined){

        alert("semestar field is mandatory")

        return;
    }

    var subject = {};

    var id = $('#id').val();
    var name =  $('#name').val();
    var credits = $('#credits').val();
    var semestar = $('#semestar').val();


    subject['id'] = id;
    subject['name'] = name;
    subject['credits'] = credits;
    subject['semestar'] = semestar;

    console.log('original ', subject);
    console.log('stringify ', JSON.stringify(subject));

    $.ajax({

        url: "/subject",
        type: "POST",
        dataType:"json",
        data: JSON.stringify(subject),
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