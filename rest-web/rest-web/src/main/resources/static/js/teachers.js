var buttonLoad;
var dropdownTeachers;
var buttonAdd;
var fieldTeacherName;
var fieldTeacherId;
var labelTeacherId;
var labelTeacherName;
var buttonUpdate;
var buttonDelete;


$(document).ready(function(){
buttonLoad=$("#buttonLoadTeachers");
dropdownTeachers=$("#dropDownTeachers");
fieldTeacherName=$("#fieldTeacherName");
fieldTeacherId=$("#fieldTeacherId");
labelTeacherId=$("#labelTeacherId");
labelTeacherName=$("#labelTeacherName");
buttonAdd=$("#buttonAdd");
buttonUpdate=$("#buttonUpdate");
buttonDelete=$("#buttonDelete");

buttonLoad.click(function(){
    loadTeachers();
});
buttonAdd.click(function(){
    addTeacher();

});
buttonUpdate.click(function(){
    updateTeacher();

});
dropdownTeachers.on("change",function(){
       changeFormStateToSelectTeacher();
 });
 buttonDelete.click(function(){
     deleteTeacher();
 });
});

function loadTeachers() {
    url="/teacher";
    $.get(url,function(responseJson){
        dropdownTeachers.empty();

        $.each(responseJson,function(index, teacher){
            $("<option>").val(teacher.teacherId).text(teacher.name)
            .appendTo(dropdownTeachers);
        });

    }).done(function(){

        buttonLoad.val("Refresh List");
    }).fail(function(){


    });
}
function addTeacher(){
       url= "/teacher";
       teacherName= fieldTeacherName.val();
       teacherId=fieldTeacherId.val();
       jsonData={teacherId:teacherId,name: teacherName};

       $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(jsonData),
        contentType: "application/json"
       }).done(function(message){
       selectNewlyAddedTeacher(teacherId, teacherName);
       }).fail(function(){
       alert("failed");
       });
}

function selectNewlyAddedTeacher(teacherId, teacherName){
    $("<option>").val(teacherId).text(teacherName).appendTo(dropdownTeachers);
    $("#dropDownTeachers option[value='"+teacherId+"']").prop("selected",true);
    fieldTeacherName.val("");
    fieldTeacherId.val("").focus();
}

function changeFormStateToSelectTeacher(){
    selectedTeacherName=$("#dropDownTeachers option:selected").text();
    selectedTeacherId=$("#dropDownTeachers option:selected").val();

    fieldTeacherName.val(selectedTeacherName);
    fieldTeacherId.val(selectedTeacherId);
    labelTeacherName.text("Selected Teacher:");
    buttonAdd.prop("value","New");
    buttonUpdate.prop("disabled",false);
    buttonDelete.prop("disabled",false);
};

function updateTeacher(){
       url= "/teacher";
       teacherId=dropdownTeachers.val();
       teacherName= fieldTeacherName.val();
       teacherId=fieldTeacherId.val();
       jsonData={teacherId:teacherId,name: teacherName};

       $.ajax({
        type: "PUT",
        url: url,
        data: JSON.stringify(jsonData),
        contentType: "application/json"
       }).done(function(teacherId){
       $("#dropDownTeachers option:selected").text(teacherName);
       changeFormStateToNewTeacher();
       }).fail(function(){
       alert("failed");
       });
}

function changeFormStateToNewTeacher(){
    buttonAdd.val("Add");
    labelTeacherName.text("Teacher Name: ");

        buttonUpdate.prop("disabled",true);
        buttonDelete.prop("disabled",true);
        fieldTeacherName.val("");
        fieldTeacherId.val("").focus();
}

function deleteTeacher(){
        teacherId=dropdownTeachers.val();

        url="/teacher/"+teacherId;

        $.get(url).done(function(){
        $("#dropDownTeachers option:selected").remove();
        changeFormStateToNewTeacher();
        });
}