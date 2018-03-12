$(document).ready(function () {
       $('#textId').keyup(function () {

       alert('test');

       // get the input value with:
  var searchstring = $('input[type="text"]', this).val();
  // your ajax request, using the variable above
  var url = "/searchDrug?item="+searchstring;
  $.ajax({
    type: "GET",
    url: url,
    dataType: "jsonp",
    success: function(res){
      console.log(res);
      $('#results').html(res);
    },
    error: function(e){
                            alert('Error: ' + e);
                        }
  });
      });
   });