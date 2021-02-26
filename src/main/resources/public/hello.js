$(document).ready(function() {
    $("#load").click(function(){
        $.ajax({
        url: "https://labaddressbook.herokuapp.com/addressBook?id="+$("#id").val()
    }).then(function(data) {
        $('.addressBook-id').append(data.id);
        $.each(data.buddies,function(k,v){
            $('.addressBook-buddies').append("<div> Name: "+v.name+" Address:"+v.address +" PhoneNumber:" + v.phoneNumber+"</div>");
        });
    });
    }
    )});