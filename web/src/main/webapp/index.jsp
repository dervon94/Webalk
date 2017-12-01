<html>
<head>
    <meta charset="UTF-8"/>
    <script src="../../../../../../registryapp/web/src/main/webapp/js/jquery-3.2.1.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#listRunners').click(function () {
                $.get('registry/',function (data) {
                    //For better solutions, take part in Web Technologies course.
                    var table = '<table>';

                    for(var i = 0; i< data.length; i++){
                        table += "<tr>";
                        table += "<td>"+ data[i]['name'] +"</td>";
                        //table += "<td>"+ data[i]['brand'] +"</td>";
                        //table += "<td>"+ data[i]['carModel'] +"</td>";
                        table += "</tr>";
                    }
                    table += "</table>";
                    $('#Content').html(table);
                })
            });
        });

    </script>
</head>
<body>
<div id="MenuBar"><button id="listRunners">Runners</button></div>

</div>
<div id="Content">
</div>
</body>
</html>
