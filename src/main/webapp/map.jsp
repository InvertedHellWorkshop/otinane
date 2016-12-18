
<!--
* Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
*/-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html>
<head>

    <title>Geolocation</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link href="${contextPath}/resources/css/map.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>

<div id="map-canvas">
    </div>
    <div class="inventory overlap">
        <div id="inventory">
            <h1>Inventory</h1>
            <p>   <script>
                var status1 = "${flag1}";
                if(status1 == "ok") {
                    var apantisi = "${apantisi}";
                    document.write(apantisi);
                }
            </script>
            </p>
        </div>
        <div class="msgBox overlap">
            <div id="msgBox">

                <p>  <script>
                    var message2 = "${message}";
                    document.write(message2);
                </script>
                </p>
                <a id="close">[close]</a>

            </div>
            <script>
                close = document.getElementById("close");
                close.addEventListener('click', function() {
                    var msgBox = document.getElementById("msgBox");
                    msgBox.style.display = 'none';
                }, false);
            </script>
        </div>
    </div>
<script>
    var x = document.getElementById("map-canvas");
    function initMap() {


        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);

        }
        function showPosition(position) {
            var latx = position.coords.latitude;
            var lonx = position.coords.longitude;
            var resultx = new google.maps.LatLng(latx, lonx);


            var map = new google.maps.Map(document.getElementById('map-canvas'), {
                zoom: 17,
                scrollwheel: true,
                center: resultx,
                mapTypeId: google.maps.MapTypeId.ROADMAP


            });

            var xmlhttp = new XMLHttpRequest();
            var url = "http://localhost:8080/items";
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var itemsCollection = JSON.parse(this.responseText);
                    printItems(itemsCollection)
                }
            };
            xmlhttp.open("GET", url, true);
            xmlhttp.send();

           // '<form class="form-wrapper cf"> <input type="text" id="field1" value=""  placeholder="Write your Answer" required> <button type="submit" onclick="myFunction()">OK</button></form>'
            var infowindow = new google.maps.InfoWindow;
            var path =["${contextPath}/answerform","${contextPath}/answerform1"] ;
            var message2 = "${message}";
            var arxiko=[];
            var status1=[];
            var contentString=[];
            var Swsto=[];
            var Lathos=[];
            var radius = 0.000120;
            var bottomItemLat = [];
            var upperItemLat = [];
            var bottomItemLng = [];
            var upperItemLng = [];


            function printItems(items) {
                var out = "";
                var marker, i;
                for (i = 0; i < items.length; i++) {
                    out += 'Name:' + items[i].name + '</br>Description:' + items[i].description + '<br><br>';
                    arxiko[i] = '<h1 id="firstHeading" class="firstHeading">'+items[i].name+'</h1>'+items[i].description+'<br><br><br>'+
                            '<form name="answerform'+i+'" method="POST" action='+path[i]+'>'+
                            'Answer <input type="text" placeholder="Think before you write" name="fname'+i+'"><br>'+
                            '<input type="submit" value="OK"> </form> ';
                    Swsto[i]="Your answer for riddle about"+items[i].name+"was Correct";
                    Lathos[i]='<h1 id="firstHeading" class="firstHeading">'+items[i].name+'</h1>'+items[i].description+'<br><br><br>'+
                            '<form name="answerform'+i+'" method="POST" action='+path[i]+'>'+
                            'Answer <input type="text" placeholder="Think before you write" name="fname'+i+'"><br>'+
                            '<input type="submit" value="OK"> </form>' +
                            '<span>'+message2+'</span> ';

                    //database checking status
                   /* if(items[i].Status=="A"){
                        contentString[i]=arxiko[i];
                    }else if(items[i].Status=="S"){
                        contentString[i]=Swsto[i];
                    }else{
                        contentString[i]=Lathos[i];
                    }*/
                    //contentString[i] =items[i].grifos+'<form method="POST" class="form-wrapper cf"><input type="text"  id="field1" value=""  placeholder="Write your Answer" required><button type="button" onclick="myFunction()">OK</button> </form>';
                    var image = {
                            url: '/resources/icons/'+items[i].name+'.png',
                            size: new google.maps.Size(55, 55),
                            origin: new google.maps.Point(0, 0),
                            anchor: new google.maps.Point(17, 34),
                            scaledSize: new google.maps.Size(55, 55)
                        };
                        marker = new google.maps.Marker({
                            position: new google.maps.LatLng(items[i].latitude, items[i].longitude),
                            map: map,
                            icon: image

                        });


                    google.maps.event.addListener(marker, 'click', (function (marker, i) {
                            return function () {
                                //var outLat = 'user lat: ' + latx + ' ,' + bottomItemLat + ' ... ' + upperItemLat;
                                //var outLng = 'user lng: ' + lonx + ' ,' + bottomItemLng + ' ... ' + upperItemLng;
                                //document.getElementById("test").innerHTML = outLat+'<br>'+ outLng;

                                bottomItemLat[i] = items[i].latitude - radius;
                                upperItemLat[i] = items[i].latitude + radius;
                                bottomItemLng[i] = items[i].longitude - radius;
                                upperItemLng[i] = items[i].longitude + radius;

                                if ((latx >= upperItemLat[i] || latx <= bottomItemLat[i]) && (lonx >= upperItemLng[i] || lonx <= bottomItemLng[i])) {
                                    infowindow.setContent("You are not in range to see this riddle");
                                } else {
                                    status1[0]= "${flag1}";
                                status1[1]="${flag2}";
                                //Push to item.Status
                                if (status1[i] == "ok" ) {
                                        infowindow.setContent("${message}");
                                } else {
                                        infowindow.setContent(arxiko[i]);

                                    }

                               }
                                infowindow.open(map, marker);
                            }
                        })(marker, i));
                }

            }

            var imageChar = {
                    url: '/resources/icons/Char.png',
                    // This marker is 20 pixels wide by 32 pixels high.
                    size: new google.maps.Size(55, 55),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(55, 55)

                };


                var marker2 = new google.maps.Marker({

                    position: new google.maps.LatLng(latx, lonx),
                    map: map,
                    icon: imageChar

                });


                google.maps.event.addListener(marker2, 'click', (function (marker2) {
                    return function () {
                        infowindow.setContent("You are HERE");
                        infowindow.open(map, marker2);
                    }
                })(marker2))

            }
        }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZ_CL_bAA7VK5OVfdkZNRSF8s7qEkcPj0&callback=initMap">
</script>




</body>
</html>