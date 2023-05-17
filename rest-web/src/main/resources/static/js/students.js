var buttonLoad;
var dropdownStudents;
var buttonAdd;
var fieldStudentName;
var fieldStudentSurname;
var fieldStudentId;
var labelStudentId;
var labelStudentName;
var labelStudentSurname;
var buttonUpdate;
var buttonDelete;


$(document).ready(function(){
buttonLoad=$("#buttonLoadStudents");
dropdownStudents=$("#dropDownStudents");
fieldStudentName=$("#fieldStudentName");
fieldStudentId=$("#fieldStudentId");
labelStudentId=$("#labelStudentId");
labelStudentName=$("#labelStudentName");
buttonAdd=$("#buttonAdd");
buttonUpdate=$("#buttonUpdate");
buttonDelete=$("#buttonDelete");

buttonLoad.click(function(){
    loadStudents();
});
buttonAdd.click(function(){
    addStudent();

});
buttonUpdate.click(function(){
    updateStudent();

});
dropdownStudents.on("change",function(){
       changeFormStateToSelectStudent();
 });
 buttonDelete.click(function(){
     deleteStudent();
 });
});

function loadStudents() {
    url="/student";
    $.get(url,function(responseJson){
        dropdownStudents.empty();

        $.each(responseJson,function(index, student){
            $("<option>").val(student.studentId).text(student.name)
            .appendTo(dropdownStudents);
        });

    }).done(function(){

        buttonLoad.val("Refresh List");
    }).fail(function(){


    });
}
function addStudent(){
       url= "/student";
       studentName= fieldStudentName.val();
       studentSurname= fieldStudentSurname.val();
       studentId=fieldStudentId.val();
       jsonData={studentId:studentId,name: studentName};

       $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(jsonData),
        contentType: "application/json"
       }).done(function(message){
       selectNewlyAddedStudent(studentId, studentName);
       }).fail(function(){
       alert("failed");
       });
}

function selectNewlyAddedStudent(studentId, studentName){
    $("<option>").val(studentId).text(studentName).appendTo(dropdownStudents);
    $("#dropDownStudents option[value='"+studentId+"']").prop("selected",true);
    fieldStudentName.val("");
    fieldStudentSurname.val("");
    fieldStudentId.val("").focus();

}

function changeFormStateToSelectStudent(){
    selectedStudentName=$("#dropDownStudents option:selected").text();
    selectedStudentId=$("#dropDownStudents option:selected").val();

    fieldStudentName.val(selectedStudentName);
    fieldStudentId.val(selectedStudentId);
    labelStudentName.text("Selected Student:");
    buttonAdd.prop("value","New");
    buttonUpdate.prop("disabled",false);
    buttonDelete.prop("disabled",false);
};

function updateStudent(){
       url= "/student";
       studentId=dropdownStudents.val();
       studentName= fieldStudentName.val();
       studentId=fieldStudentId.val();
       jsonData={studentId:studentId,name: studentName};

       $.ajax({
        type: "PUT",
        url: url,
        data: JSON.stringify(jsonData),
        contentType: "application/json"
       }).done(function(studentId){
       $("#dropDownStudents option:selected").text(studentName);
       changeFormStateToNewStudent();
       }).fail(function(){
       alert("failed");
       });
}

function changeFormStateToNewStudent(){
    buttonAdd.val("Add");
    labelStudentName.text("Student Name: ");

        buttonUpdate.prop("disabled",true);
        buttonDelete.prop("disabled",true);
        fieldStudentName.val("");
        fieldStudentSurname.val("");
        fieldStudentId.val("").focus();
}

function deleteStudent(){
        studentId=dropdownStudents.val();

        url="/student/"+studentId;

        $.get(url).done(function(){
        $("#dropDownStudents option:selected").remove();
        changeFormStateToNewStudent();
        });
}